package com.jaksmok.suonchantha.service;

import com.jaksmok.suonchantha.model.entity.UserEntity;
import com.jaksmok.suonchantha.model.request.UserRequest;
import com.jaksmok.suonchantha.security.JwtResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    UserEntity register(UserRequest request) throws Exception;

    JwtResponse login(UserRequest request) throws Exception;

    UserEntity getCurrentUser() throws Exception;


}
