package com.will.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "will")
public class Hello {

    @RequestMapping(value = "hello")
    public String hello(){
        return "hello";
    }



}
