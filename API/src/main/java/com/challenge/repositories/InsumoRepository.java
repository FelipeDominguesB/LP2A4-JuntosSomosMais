package com.challenge.repositories;

import com.challenge.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long>{

	
	@Query(value = "SELECT * FROM INSUMO insumo left outer join location L on insumo.location_id = L.id WHERE L.REGION = ?1", countQuery = "select count(*) from Insumo left outer join location l on Insumo.location_id = l.id where l.region = ?1", nativeQuery = true)
	Page<Insumo> findByRegion(String region, Pageable pageable);
	
	@Query(value = "SELECT * FROM INSUMO I WHERE I.type = ?1", countQuery="SELECT count(*) FROM INSUMO I WHERE I.type = ?1" ,nativeQuery = true)
	Page<Insumo> findByType(String type, Pageable pageable);
	
	@Query(value = "SELECT * FROM INSUMO I left outer join location L on I.location_id=L.id WHERE L.REGION = ?1 AND I.TYPE= ?2", countQuery="SELECT count(*) FROM INSUMO I left outer join location L on I.location_id=L.id WHERE L.REGION = ?1 AND I.TYPE= ?2", nativeQuery = true)
	Page<Insumo> findByRegionAndType(String region, String type, Pageable pageable);
}
