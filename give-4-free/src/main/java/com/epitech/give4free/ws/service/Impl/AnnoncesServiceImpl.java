package com.epitech.give4free.ws.service.Impl;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.epitech.give4free.ws.io.entity.AnnoncesEntity;
import com.epitech.give4free.ws.io.entity.UserEntity;
import com.epitech.give4free.ws.io.repositories.AnnoncesRepository;
import com.epitech.give4free.ws.service.AnnoncesService;
import com.epitech.give4free.ws.service.UserService;
import com.epitech.give4free.ws.shared.Utils;
import com.epitech.give4free.ws.shared.dto.AnnoncesDTO;
import com.epitech.give4free.ws.shared.dto.UserDto;
import com.epitech.give4free.ws.ui.model.response.UserRest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.hibernate.annotations.Any;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aj.org.objectweb.asm.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

class Wrapper{
    String title;
}

@Service
public class AnnoncesServiceImpl implements AnnoncesService {

    @Autowired
	AnnoncesRepository annoncesRepository;

    @Autowired
    UserService userService;

	@Autowired
	Utils utils;

	@Override
	public AnnoncesDTO createAnnonces(AnnoncesDTO annonces) {	
        String error = "Error on annonce the users creating this annonce doesn't exist";

        UserEntity entityUser = new UserEntity();
		UserDto userDto = userService.getUserByUserID(annonces.getUserId());
        BeanUtils.copyProperties(userDto, entityUser);

        if (userDto.getUserId() == null) {
            System.out.println("haha 03 == " + userDto.getUserId());
            throw new RuntimeException(error);
        }
        System.out.println("here 03");

		AnnoncesEntity annoncesEntity = new AnnoncesEntity();
		BeanUtils.copyProperties(annonces, annoncesEntity);

		String publicUserId = utils.generateAnnoncesId(35);

        annoncesEntity.setAnnoncesId(publicUserId);
        annoncesEntity.setUserDetails(entityUser);

        System.out.println("here 04+5 + " + annoncesEntity.getId());
		AnnoncesEntity storedAnnonces = annoncesRepository.save(annoncesEntity);

        AnnoncesDTO returnValue = new AnnoncesDTO();
        BeanUtils.copyProperties(storedAnnonces, returnValue);

        returnValue.setUserId(storedAnnonces.getUserDetails().getUserId());
        System.out.println("here 05 + " + returnValue.getDescription());

        /*Gson gson = new Gson();
        String[] arr = gson.fromJson(returnValue.getDescription(), String[].class);
        for (String wrapper : arr) {
            System.out.println(" here val == " + wrapper); //    "description": "[{\"number\": \"3\",\"title\": \"hello_world\"}]", exemple appel postman pour description if no key "[\"hello_world\", \"test\"]",
        }*/

        return returnValue;
    }

	@Override
	public AnnoncesDTO getAnnonces(String annoncesid) {	
        AnnoncesDTO returnvalue = new AnnoncesDTO();
        return returnvalue;
    }

	@Override
	public AnnoncesDTO getAnnoncesByUserID(String userID) {
        AnnoncesDTO returnvalue = new AnnoncesDTO();
        return returnvalue;
    }

	@Override
	public AnnoncesDTO updateAnnonces(String userID, AnnoncesDTO user) {
        AnnoncesDTO returnvalue = new AnnoncesDTO();
        return returnvalue;
    }

	@Override
	public void deleteAnnonces(String annoncesId) {

    }

}