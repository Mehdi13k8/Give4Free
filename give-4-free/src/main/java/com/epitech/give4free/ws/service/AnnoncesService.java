package com.epitech.give4free.ws.service;

import com.epitech.give4free.ws.shared.dto.AnnoncesDTO;

public interface AnnoncesService {
    AnnoncesDTO	createAnnonces(AnnoncesDTO annonces);
	AnnoncesDTO getAnnonces(String annoncesID);
	AnnoncesDTO getAnnoncesByUserID(String useridID);
	AnnoncesDTO updateAnnonces(String id, AnnoncesDTO annonces);
	void deleteAnnonces(String userId);
}
