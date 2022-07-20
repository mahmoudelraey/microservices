package com.useres.service;

import com.fasterxml.jackson.core.format.MatchStrength;
import com.useres.data.UsersEntity;
import com.useres.repository.UsersRepository;
import com.useres.shared.UsersDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.UUID;


@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UsersDto createUser(UsersDto userDetail) {
        userDetail.setUserId(UUID.randomUUID().toString());
        userDetail.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetail.getPassword()));

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UsersEntity usersEntity = modelMapper.map(userDetail, UsersEntity.class);
        usersRepository.save(usersEntity);

        UsersDto createdUserDto = modelMapper.map(usersEntity, UsersDto.class);
        return createdUserDto;
    }

    @Override
    public UsersDto getUserByEmail(String email) {
        UsersEntity usersEntity = usersRepository.findByEmail(email);
        return new ModelMapper().map(usersEntity,UsersDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity usersEntity = usersRepository.findByEmail(username);
        if(usersEntity == null){
            throw new UsernameNotFoundException("email not found");
        }
        return new User(usersEntity.getEmail(), usersEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
    }
}
