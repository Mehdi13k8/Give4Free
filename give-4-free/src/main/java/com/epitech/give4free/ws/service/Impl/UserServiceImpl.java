package com.epitech.give4free.ws.service.Impl;

import java.util.ArrayList;
// import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.epitech.give4free.ws.io.entity.UserEntity;
import com.epitech.give4free.ws.io.repositories.UserRepository;
import com.epitech.give4free.ws.service.UserService;
import com.epitech.give4free.ws.shared.Utils;
import com.epitech.give4free.ws.shared.dto.UserDto;

import java.lang.reflect.Type;
// import java.lang.reflect.TypeVariable;
import com.google.gson.reflect.TypeToken;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	Utils utils;

	@Autowired
	BCryptPasswordEncoder BCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto user) {

		// Check si le compte existe déjà
		String error = "Error user exist";

		if (userRepository.findByEmail(user.getEmail()) != null)
			throw new RuntimeException(error);

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		String publicUserId = utils.generateUserId(30);

		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword(BCryptPasswordEncoder.encode(user.getPassword()));

		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}

	@Override
	public void addPaypalEmail(String userID, String paypalEmail) {
		UserEntity userEntity = userRepository.findByUserId(userID);
		if (userEntity == null)
			throw new UsernameNotFoundException(userID);

			userEntity.setPaypalEmail(paypalEmail);
			userRepository.save(userEntity);
	}

	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null)
			throw new UsernameNotFoundException(email);
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}

	@Override
	public UserDto getUserByUserID(String userID) {
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userID);
		if (userEntity == null)
			throw new UsernameNotFoundException(userID);

		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

	@Override
	public UserDto updateUser(String userID, UserDto user) {
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userID);

		if (userEntity == null)
			throw new UsernameNotFoundException(userID);

		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setEncryptedPassword(BCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setEmail(user.getEmail()); //reverifier l'email avec un token

		UserEntity updatedUserDetails = userRepository.save(userEntity);
		
		BeanUtils.copyProperties(updatedUserDetails, returnValue);

		return returnValue;
	}

	@Override
	public void deleteUser(String userId) {
		UserEntity userEntity = userRepository.findByUserId(userId);
		if (userEntity == null)
			throw new UsernameNotFoundException(userId);
		userRepository.delete(userEntity);
	}

	@Override
	public Iterable<UserDto> getAllUsers() {
		Iterable<UserEntity> users = userRepository.findAll();

		Type listType = new TypeToken<Iterable<UserDto>>(){}.getType();
		Iterable<UserDto> usersDto = modelMapper.map(users, listType);

		// marche pas car je n'ai pas de constructeur pour l'iterable
		//BeanUtils.copyProperties(users, usersDto); //Solution de gros flemmard ;) mais ça marche et c simple

		// exemple de base comment "instancier directement d'un type à un autre, par ex via les fk annonces -> users ou inverse"
		// List<Post> post = postRepository.findAll();
		// Type listType = new TypeToken<List<PostDTO>>(){}.getType();
		// List<PostDTO> postDTOList = modelMapper.map(post, listType);
		return usersDto;
	}
}
