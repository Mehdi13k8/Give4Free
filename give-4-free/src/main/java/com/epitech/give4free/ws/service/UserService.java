package com.epitech.give4free.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

// import java.util.List;

import com.epitech.give4free.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	UserDto	createUser(UserDto user);
	Iterable<UserDto> getAllUsers();
	UserDto getUser(String email);
	UserDto getUserByUserID(String userID);	
	UserDto updateUser(String id, UserDto user);
	void deleteUser(String userId);
	void addPaypalEmail(String userId, String paypalEmail);
}
