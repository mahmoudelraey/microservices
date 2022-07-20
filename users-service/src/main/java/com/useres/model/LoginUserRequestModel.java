package com.useres.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginUserRequestModel {
    @NotNull(message = "email can not be null")
    private String email;
    @NotNull(message = "password can not be null")
    private String password;
}
