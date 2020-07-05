package com.epitech.give4free.ws.ui.controller;

import com.epitech.give4free.ws.service.AnnoncesService;
import com.epitech.give4free.ws.shared.dto.AnnoncesDTO;
import com.epitech.give4free.ws.ui.model.request.AnnoncesRequestModel;
import com.epitech.give4free.ws.ui.model.response.AnnoncesRest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("annonces")
public class AnnoncesController {

    @Autowired
    AnnoncesService annoncesService;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public AnnoncesRest createAnnonces(@RequestBody AnnoncesRequestModel annoncesDetails) {
        AnnoncesRest returnValue = new AnnoncesRest();

        if (annoncesDetails.getDescription() == null ||
            annoncesDetails.getTitle().isEmpty() ||
            annoncesDetails.getDate_debut() == null || 
            annoncesDetails.getDate_fin() == null ||
            annoncesDetails.getImage().isEmpty())
                throw new RuntimeException("Error on annonce add check documentation");

        AnnoncesDTO annoncesDto = new AnnoncesDTO();
        BeanUtils.copyProperties(annoncesDetails, annoncesDto);

        System.out.println("here 1");
        AnnoncesDTO createdannonces = annoncesService.createAnnonces(annoncesDto);

        System.out.println("here 2 + ");
        BeanUtils.copyProperties(createdannonces, returnValue);
        System.out.println("here 3");
        // ModelMapper modelMapper = new ModelMapper();
        // modelMapper.map(userDetails, userDto);
        return returnValue;
    }
}