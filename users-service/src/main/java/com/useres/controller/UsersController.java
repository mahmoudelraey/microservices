package com.useres.controller;

import com.useres.model.CreateUserRequestModel;
import com.useres.model.CreateUserResponseModel;
import com.useres.service.UsersService;
import com.useres.shared.UsersDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final Environment environment;
    private final UsersService usersService;


    public UsersController(Environment environment, UsersService usersService) {
        this.environment = environment;
        this.usersService = usersService;
    }

    @GetMapping("/status/check")
    public String status() {
        return "Working On Port : " + environment.getProperty("local.server.port");
    }

    @PostMapping(
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody @Valid CreateUserRequestModel createUserRequestModel) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UsersDto usersDto = modelMapper.map(createUserRequestModel, UsersDto.class);
        UsersDto createdUserDto = usersService.createUser(usersDto);

        CreateUserResponseModel createdUserResponse = modelMapper.map(createdUserDto, CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserResponse);
    }
}
