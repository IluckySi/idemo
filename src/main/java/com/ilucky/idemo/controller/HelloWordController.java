package com.ilucky.idemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWordController {

    @RequestMapping("/helloworld")
    public String hellowrod(){
        return "Hello World～";
    }
}
