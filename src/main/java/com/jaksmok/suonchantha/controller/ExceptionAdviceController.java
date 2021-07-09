package com.jaksmok.suonchantha.controller;

import com.jaksmok.suonchantha.infrastructure.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdviceController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception e){
        return BaseResponse.failed(
                HttpStatus.BAD_REQUEST,
                e.getMessage()
        );
    }
}
