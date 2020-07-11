package com.epitech.give4free.ws.service.Impl;
// import java.lang.reflect.Array;
// import java.util.ArrayList;

import com.epitech.give4free.ws.io.entity.AnnoncesEntity;
import com.epitech.give4free.ws.io.entity.UserEntity;
import com.epitech.give4free.ws.io.repositories.AnnoncesRepository;
import com.epitech.give4free.ws.io.repositories.UserRepository;
import com.epitech.give4free.ws.service.AnnoncesService;
import com.epitech.give4free.ws.service.UserService;
import com.epitech.give4free.ws.shared.Utils;
import com.epitech.give4free.ws.shared.dto.AnnoncesDTO;
// import com.epitech.give4free.ws.shared.dto.UserDto;
// import com.epitech.give4free.ws.ui.model.response.UserRest;
// import com.google.gson.Gson;
// import com.google.gson.JsonArray;

// import org.hibernate.annotations.Any;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import aj.org.objectweb.asm.Type;
// import javassist.NotFoundException;

// import com.google.gson.JsonElement;
// import com.google.gson.JsonParser;

class Wrapper{
    String title;
}

@Service
public class AnnoncesServiceImpl implements AnnoncesService {

    @Autowired
    AnnoncesRepository annoncesRepository;
    @Autowired
	UserRepository userRepository;


    @Autowired
    UserService userService;

	@Autowired
	Utils utils;

	@Override
	public AnnoncesDTO createAnnonces(AnnoncesDTO annonces) {	
        String error = "Error on annonce the users creating this annonce doesn't exist";

        UserEntity entityUser = userRepository.findByUserId(annonces.getUserId());

        if (entityUser.getUserId() == null) {
            throw new RuntimeException(error);
        }

		AnnoncesEntity annoncesEntity = new AnnoncesEntity();
		BeanUtils.copyProperties(annonces, annoncesEntity);

		String publicUserId = utils.generateAnnoncesId(35);

        annoncesEntity.setAnnoncesId(publicUserId);
        annoncesEntity.setUserDetails(entityUser);
		AnnoncesEntity storedAnnonces = annoncesRepository.save(annoncesEntity);

        AnnoncesDTO returnValue = new AnnoncesDTO();
        BeanUtils.copyProperties(storedAnnonces, returnValue);

        returnValue.setUserId(storedAnnonces.getUserDetails().getUserId());

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
	public AnnoncesDTO getAnnoncesById(String annoncesID) {
        AnnoncesDTO returnvalue = new AnnoncesDTO();
        AnnoncesEntity annoncesEntity = annoncesRepository.findByAnnoncesId(annoncesID);
        if (annoncesEntity == null)
            throw new RuntimeException("The annonce --> " + annoncesID + " Doesn't exist !");

		BeanUtils.copyProperties(annoncesEntity, returnvalue);
		return returnvalue;
    }

	@Override
	public AnnoncesDTO updateAnnonces(String annoncesID, AnnoncesDTO annoncemodel) {
		AnnoncesDTO returnValue = new AnnoncesDTO();
		AnnoncesEntity annonceEntity = annoncesRepository.findByAnnoncesId(annoncesID);

		if (annonceEntity == null)
			throw new RuntimeException("Error The written AnnoncesId is bad " + annoncesID);

        UserEntity userEntity = userRepository.findByUserId(annoncemodel.getUserId());
        if (userEntity == null)
			throw new RuntimeException("Error The User used is bad " + annoncemodel.getUserId());

		annonceEntity.setTitle(annoncemodel.getTitle());
		annonceEntity.setDescription(annoncemodel.getDescription());
		annonceEntity.setDate_debut(annoncemodel.getDate_debut());
		annonceEntity.setDate_fin(annoncemodel.getDate_fin());
		annonceEntity.setImage(annoncemodel.getImage());
		annonceEntity.setUserDetails(userEntity);

		AnnoncesEntity updatedAnnonceDetails = annoncesRepository.save(annonceEntity);

		BeanUtils.copyProperties(updatedAnnonceDetails, returnValue);

		return returnValue;
    }

	@Override
	public void deleteAnnonces(String annoncesId) {
        AnnoncesEntity annoncesEntity = annoncesRepository.findByAnnoncesId(annoncesId);
        if (annoncesEntity == null)
            throw new RuntimeException("The annonce --> " + annoncesId + " Doesn't exist !");
        annoncesRepository.delete(annoncesEntity);
    }
}
