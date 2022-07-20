package com.useres.repository;

import com.useres.data.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UsersEntity,Long> {

    UsersEntity findByEmail(String email);
}
