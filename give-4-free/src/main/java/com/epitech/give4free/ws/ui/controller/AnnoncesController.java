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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

        AnnoncesDTO createdannonces = annoncesService.createAnnonces(annoncesDto);

        BeanUtils.copyProperties(createdannonces, returnValue);
        // ModelMapper modelMapper = new ModelMapper();
        // modelMapper.map(userDetails, userDto);
        return returnValue;
    }

    @GetMapping(path="/{annoncesID}",
    consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public AnnoncesRest getAnnonce(@PathVariable String annoncesID) {
        AnnoncesRest returnValue = new AnnoncesRest();
		AnnoncesDTO annoncesDto = annoncesService.getAnnoncesById(annoncesID);
		BeanUtils.copyProperties(annoncesDto, returnValue);
		return returnValue;
    }

    @DeleteMapping(path="/{annoncesID}",
        consumes = { MediaType.APPLICATION_JSON_VALUE},
        produces = { MediaType.APPLICATION_JSON_VALUE })
	public String deleteAnnonce(@PathVariable String annoncesID)
	{
		annoncesService.deleteAnnonces(annoncesID);
		return annoncesID + "deleted successfully";
    }

	@PutMapping(path="/{annoncesID}",
    consumes = { MediaType.APPLICATION_JSON_VALUE},
    produces = { MediaType.APPLICATION_JSON_VALUE })
	public AnnoncesRest updateUser(@PathVariable String annoncesID, @RequestBody AnnoncesRequestModel annoncesDetails)
	{
		AnnoncesRest returnValue = new AnnoncesRest();
		//if (annoncesDetails.getTitle().isEmpty() || userDetails.getLastName().isEmpty() || userDetails.getEmail().isEmpty()) throw new RuntimeException("Error on user add check documentation");

        AnnoncesDTO annoncesDto = new AnnoncesDTO();
		BeanUtils.copyProperties(annoncesDetails, annoncesDto);

		AnnoncesDTO updateAnnonce = annoncesService.updateAnnonces(annoncesID, annoncesDto);
		BeanUtils.copyProperties(updateAnnonce, returnValue);

		return returnValue;
	}
}
