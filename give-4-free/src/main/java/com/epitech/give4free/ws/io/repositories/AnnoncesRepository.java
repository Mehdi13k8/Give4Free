package com.epitech.give4free.ws.io.repositories;

import com.epitech.give4free.ws.io.entity.AnnoncesEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnoncesRepository extends CrudRepository<AnnoncesEntity, Long> {
	AnnoncesEntity	findByUserDetails(String userId);
	AnnoncesEntity  findByAnnoncesId(String annoncesId);
}