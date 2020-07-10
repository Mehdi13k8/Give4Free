package com.epitech.give4free.ws.ui.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epitech.give4free.ws.service.UserService;
import com.epitech.give4free.ws.shared.dto.UserDto;
import com.epitech.give4free.ws.ui.model.request.UserDetailsRequestModel;
import com.epitech.give4free.ws.ui.model.response.UserRest;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import com.google.gson.reflect.TypeToken;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path="/",
	consumes = { MediaType.APPLICATION_JSON_VALUE},
	produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public Iterable<UserRest> getallUsers()
	{
		Iterable<UserDto> userDto = userService.getAllUsers();

		Type listType = new TypeToken<Iterable<UserDto>>(){}.getType();
		Iterable<UserRest> usersRest = modelMapper.map(userDto, listType);
		return usersRest;
	}

	@GetMapping(path="/{userID}",
			consumes = { MediaType.APPLICATION_JSON_VALUE},
			produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public UserRest getUser(@PathVariable String userID)
	{
		UserRest returnValue = new UserRest();
		
		// user data object qui contient le vrai user, user service me donne des fonctions
		UserDto userDto = userService.getUserByUserID(userID);
		BeanUtils.copyProperties(userDto, returnValue);
		
		return returnValue;
	}

	@PostMapping(
			consumes = { MediaType.APPLICATION_JSON_VALUE},
			produces = { MediaType.APPLICATION_JSON_VALUE }
			)
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) 
	{
		UserRest returnValue = new UserRest();
		
		if (userDetails.getFirstName().isEmpty() || userDetails.getLastName().isEmpty() || userDetails.getEmail().isEmpty()) throw new RuntimeException("Error on user add check documentation");

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		//ModelMapper modelMapper = new ModelMapper();
		//modelMapper.map(userDetails, userDto);


		return returnValue;
	}

	@PutMapping(path="/{userID}",
				consumes = { MediaType.APPLICATION_JSON_VALUE},
				produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String userID, @RequestBody UserDetailsRequestModel userDetails)
	{
		UserRest returnValue = new UserRest();

		if (userDetails.getFirstName().isEmpty() || userDetails.getLastName().isEmpty() || userDetails.getEmail().isEmpty()) throw new RuntimeException("Error on user add check documentation");
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto updateUser = userService.updateUser(userID, userDto);
		BeanUtils.copyProperties(updateUser, returnValue);

		return returnValue;
	}

	@DeleteMapping(path="/{userID}",
			consumes = { MediaType.APPLICATION_JSON_VALUE},
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserRest deleteUser(@PathVariable String userID)
	{
		UserRest returnValue = new UserRest();
		UserDto userDto = userService.getUserByUserID(userID);
		BeanUtils.copyProperties(userDto, returnValue);
		userService.deleteUser(userID);

		return returnValue;
	}
}
