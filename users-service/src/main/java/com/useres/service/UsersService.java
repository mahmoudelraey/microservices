package com.useres.service;

import com.useres.shared.UsersDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {

    UsersDto createUser(UsersDto userDetail);
    UsersDto getUserByEmail(String email);
}
