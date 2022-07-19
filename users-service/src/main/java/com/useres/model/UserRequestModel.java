package com.useres.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestModel {
    @NotNull(message = "first name can not be null")
    @Size(min = 2, message = "first name size must be at least two character")
    private String firstname;
    @NotNull(message = "last name can not be null")
    @Size(min = 2, message = "last name size must be at least two character")
    private String lastname;
    @NotNull(message = "email can not be null")
    @Email
    private String email;
    @NotNull(message = "password can not be null")
    private String password;
}
