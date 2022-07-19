package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final Environment environment;

    public AccountController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/status/check")
    public String status(){
        return "Working On Port : " + environment.getProperty("server.port");
    }
}
