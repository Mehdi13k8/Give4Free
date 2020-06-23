package com.epitech.give4free.ws.io.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epitech.give4free.ws.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	UserEntity	findByEmail(String email);
	//UserEntity  findUserByEmail(String email);
	UserEntity  findByUserId(String userId);
}
