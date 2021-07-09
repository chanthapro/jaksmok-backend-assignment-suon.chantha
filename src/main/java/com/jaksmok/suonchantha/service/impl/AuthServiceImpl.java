package com.jaksmok.suonchantha.service.impl;

import com.jaksmok.suonchantha.infrastructure.repository.BaseRepository;
import com.jaksmok.suonchantha.infrastructure.service.BaseServiceImpl;
import com.jaksmok.suonchantha.model.entity.UserEntity;
import com.jaksmok.suonchantha.model.request.UserRequest;
import com.jaksmok.suonchantha.repository.UserRepository;
import com.jaksmok.suonchantha.security.JwtResponse;
import com.jaksmok.suonchantha.security.JwtTokenUtil;
import com.jaksmok.suonchantha.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl extends BaseServiceImpl<UserEntity,Long> implements AuthService {


    private final UserRepository userRepository;

//    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
//        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByUsername(username);
        if(user != null){
            return user;
        }
        else{
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }


    @Override
    public UserEntity register(UserRequest request) throws Exception {

        if(request.getUsername().trim().length() <= 0 || request.getPassword().trim().length() <= 0){
            throw new Exception("Pleas input username or password");
        }

        UserEntity u = AlreadyExitsValue("username",request.getUsername());

        if(u != null ){
            throw new Exception("Already exits username");
        }

        UserEntity user = new UserEntity(
                request.getUsername(),
                request.getPassword(),
                "ROLE_USER"
        );

        return userRepository.save(user);

    }

    @Override
    public JwtResponse login(UserRequest request) throws Exception {

        if(request.getUsername().trim().length() <= 0 || request.getPassword().trim().length() <= 0){
            throw new Exception("Pleas input username or password");
        }

        UserDetails userDetails = loadUserByUsername(request.getUsername());

        if(!jwtTokenUtil.passwordEncoder().matches(request.getPassword(),userDetails.getPassword())){
            throw new Exception("Invalid username or password");
        }

        String token = jwtTokenUtil.generateToken(userDetails);

        return new JwtResponse(token);
    }


    @Override
    public UserEntity getCurrentUser() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

       if(authentication.getPrincipal() == null) return null;

       return (UserEntity) authentication.getPrincipal();
    }


    @Override
    public BaseRepository<UserEntity, Long> getRepository() {
        return userRepository;
    }

}
