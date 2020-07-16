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

import com.epitech.give4free.ws.io.entity.UserEntity;
import com.epitech.give4free.ws.service.UserService;
import com.epitech.give4free.ws.shared.dto.UserDto;
import com.epitech.give4free.ws.ui.model.request.UserDetailsRequestModel;
import com.epitech.give4free.ws.ui.model.response.UserRest;
import com.fasterxml.jackson.databind.node.TextNode;

import java.lang.reflect.Type;
import java.util.ArrayList;
// import java.lang.reflect.TypeVariable;
// import java.util.Map;
import java.util.Iterator;

import com.google.gson.reflect.TypeToken;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ModelMapper modelMapper;

	///paypal?code=C21AAEcrAgqtm0O-9URKRW73k1bQNAXr--cWxn5d4uACjYbYWnBXk8wZMhWswsa7szjEWFUKVmthTmiy5pdv0x1FgK_ExTzDQ&scope=email
	@PostMapping(path="/paypal/{userID}",
	consumes = { MediaType.APPLICATION_JSON_VALUE},
	produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public String setUserPaypalEmail(@PathVariable String userID, @RequestBody TextNode newPaypalEmail) // textnode standard jackson parser, sinon il y a des types spéciaux pour les string en spring boot
	{
		userService.addPaypalEmail(userID, newPaypalEmail.asText()); //Mise à jours du compte "paypal" sans "Api Oauth2" car ceux chargé du front son en retard, "ajout en brute"
		return ("The Paypal account Is well linked to " + userID + " account with new paypal " + newPaypalEmail.asText());
	}

	@GetMapping(path="/",
	consumes = { MediaType.APPLICATION_JSON_VALUE},
	produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public ArrayList<UserRest> getallUsers()
	{
		ArrayList<UserDto> userDto = userService.getAllUsers();
		ArrayList<UserRest> userRest = new ArrayList<UserRest>();

		for (int i = 0; i < userDto.size(); i++) {
			UserRest userResp = new UserRest();
			userResp.setFirstName(userDto.get(i).getFirstName());
			userResp.setEmail(userDto.get(i).getEmail());
			userResp.setUserId(userDto.get(i).getUserId());
			userResp.setLastName(userDto.get(i).getLastName());
			userResp.setAnnonces(userDto.get(i).getAnnonces());
			userRest.add(userResp);
            //System.out.print(userDto.get(i).getEmail() + " zzz");
	    }

		// Type listType = new TypeToken<Iterable<UserDto>>(){}.getType();
		// Iterable<UserEntity> usersRest = modelMapper.map(userDto, listType);

		// Iterator<UserEntity> itrEntity = usersRest.iterator();

		// while (itrEntity.hasNext()) {
		// 	UserEntity current = itrEntity.next();
		// 	System.out.println("gg " + current.getId());
		// }

		return userRest;
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


class UserPaypalCall {
	String userID;
	String paypalEmail;

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPaypalEmail() {
		return paypalEmail;
	}
	public void setPaypalEmail(String PaypalEmail) {
		this.paypalEmail = PaypalEmail;
	}
}