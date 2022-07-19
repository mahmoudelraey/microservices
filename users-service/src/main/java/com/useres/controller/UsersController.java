package com.useres.controller;

import com.useres.model.UserRequestModel;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final Environment environment;

    public UsersController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/status/check")
    public String status(){
        return "Working On Port : " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@RequestBody @Valid UserRequestModel userRequestModel){

        return "create User Called";
    }
}
