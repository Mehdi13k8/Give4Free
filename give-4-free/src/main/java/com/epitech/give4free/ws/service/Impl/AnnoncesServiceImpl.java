package com.epitech.give4free.ws.service.Impl;
import com.epitech.give4free.ws.io.repositories.AnnoncesRepository;
import com.epitech.give4free.ws.service.AnnoncesService;
import com.epitech.give4free.ws.shared.Utils;
import com.epitech.give4free.ws.shared.dto.AnnoncesDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnnoncesServiceImpl implements AnnoncesService {

    @Autowired
	AnnoncesRepository annoncesRepository;

	@Autowired
	Utils utils;

	@Override
	public AnnoncesDTO createAnnonces(AnnoncesDTO annonces) {	
        AnnoncesDTO returnvalue = new AnnoncesDTO();
        return returnvalue;
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