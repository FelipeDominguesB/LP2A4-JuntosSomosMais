package com.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.models.Insumo;

interface InsumoRepository extends JpaRepository<Insumo, Long>{

}
