package com.jaksmok.suonchantha.controller;

import com.jaksmok.suonchantha.constant.RestUriConstant;
import com.jaksmok.suonchantha.infrastructure.response.BaseResponse;
import com.jaksmok.suonchantha.model.entity.UserEntity;
import com.jaksmok.suonchantha.model.request.UserRequest;
import com.jaksmok.suonchantha.security.JwtResponse;
import com.jaksmok.suonchantha.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = RestUriConstant.AUTHENTICATION)
public class AuthenticationController {


    private AuthServiceImpl authService;

    @Autowired
    public AuthenticationController(AuthServiceImpl authService){
        this.authService = authService;
    }


    @PostMapping
    private ResponseEntity<Object> register(
            @RequestBody UserRequest userRequest
            ) throws Exception {
        UserEntity user = authService.register(userRequest);
        return BaseResponse.success(user.toResponse(),"");
    }

    @PostMapping("/login")
    private ResponseEntity<Object> login(
            @RequestBody UserRequest userRequest
    ) throws Exception {
        JwtResponse token = authService.login(userRequest);
        return BaseResponse.success(token,"Login Success");
    }


    @GetMapping("/me")
    private ResponseEntity<Object> fetchCurrentUser() throws Exception {
        UserEntity user = authService.getCurrentUser();
        if(user == null){
            throw new Exception("Current user is invalid");
        }
        return BaseResponse.success(user.toResponse(),"Success");
    }

}
