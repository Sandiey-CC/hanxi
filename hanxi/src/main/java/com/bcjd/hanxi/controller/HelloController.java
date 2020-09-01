package com.bcjd.hanxi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class HelloController {
    @RequestMapping("/hello")
    public String Hello(){
        System.out.println("Springboot!!");
        return "Springboot";
    }
}
