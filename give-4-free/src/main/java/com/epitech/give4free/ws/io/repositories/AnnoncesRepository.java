package com.epitech.give4free.ws.io.repositories;

import com.epitech.give4free.ws.io.entity.AnnoncesEntity;
import com.epitech.give4free.ws.io.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnoncesRepository extends CrudRepository<AnnoncesEntity, Long> {
	Iterable<AnnoncesEntity> findByUserDetails(UserEntity userId);
	AnnoncesEntity  findByAnnoncesId(String annoncesId);
}