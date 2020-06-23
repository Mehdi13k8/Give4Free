package com.epitech.give4free.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.epitech.give4free.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	UserDto	createUser(UserDto user);
	UserDto getUser(String email);
	UserDto getUserByUserID(String userID);	
	UserDto updateUser(String id, UserDto user);
	void deleteUser(String userId);
}
