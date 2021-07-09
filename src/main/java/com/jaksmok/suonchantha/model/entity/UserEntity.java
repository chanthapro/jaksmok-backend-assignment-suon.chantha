package com.jaksmok.suonchantha.model.entity;

import com.jaksmok.suonchantha.constant.TableConstant;
import com.jaksmok.suonchantha.infrastructure.entity.BaseWithAudible;
import com.jaksmok.suonchantha.model.response.UserResponse;
import com.jaksmok.suonchantha.security.JwtGrantedAuthority;
import com.jaksmok.suonchantha.security.JwtTokenUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.beans.Encoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Table
@Entity(name = TableConstant.USER)
public class UserEntity extends BaseWithAudible<Long> implements UserDetails {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private String authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
        list.add(new JwtGrantedAuthority(authorities));
        return list;
    }


    @PostPersist
    @Override
    public void beforeSave() {
        super.beforeSave();
        encodePassword(this.password);
    }


    @Transient
    public UserResponse toResponse(){
        return new UserResponse(
                getId(),
                getUsername(),
                authorities
        );
    }


    private void encodePassword(String rawPassword){
        if(rawPassword.trim().length() > 0){
            JwtTokenUtil util = new JwtTokenUtil();
            this.password = util.passwordEncoder().encode(rawPassword);
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserEntity(String username, String password, String authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public UserEntity() {
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
