package com.jaksmok.suonchantha.controller;

import com.jaksmok.suonchantha.constant.RestUriConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(value = RestUriConstant.INDEX)
public class IndexController {


    @GetMapping
    public RedirectView index(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("swagger-ui.html");
        return redirectView;
    }



}
