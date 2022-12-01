package com.challenge.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.MultipartFile;

import com.challenge.helpers.CSVHelper;
import com.challenge.helpers.JSONHelper;
import com.challenge.models.Insumo;
import com.challenge.repositories.InsumoRepository;

@Service
public class InsumoService {

	InsumoRepository repo;
	
	@Autowired
	InsumoService(InsumoRepository repo)
	{
		this.repo = repo;
	}
	
	
	public Optional<Insumo> getInsumoById(Optional<Long> id)
	{
		return this.repo.findById(id.orElse((long) 1));
	}
	
	public Page<Insumo> getInsumosByRegionAndType(int index, int size,  Optional<String> region, Optional<String> type)
	{
		
		String regionValue = region.orElse(null);
		String typeValue = type.orElse(null);
		
		if(regionValue == null && typeValue == null) return this.getInsumos(index, size);
		
		if(typeValue == null) return this.repo.findByRegion(regionValue, (Pageable) PageRequest.of(index, size));
		if(regionValue == null) return this.repo.findByType(typeValue, (Pageable) PageRequest.of(index, size));
		
		return this.repo.findByRegionAndType(regionValue, typeValue, (Pageable) PageRequest.of(index, size));
		
		
	}
	
	public Page<Insumo> getInsumos(int index, int size)
	{
		return this.repo.findAll(PageRequest.of(index, size));
	}
	public List<Insumo> saveInsumos(List<Insumo> insumos)
	{
		return this.repo.saveAll(insumos);
	}
	
	public List<Insumo> readInsumosFromCSV(MultipartFile file)
	{
		try {
			return CSVHelper.csvToInsumo(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Insumo> readInsumosFromJSON(MultipartFile file)
	{
		try {
			return JSONHelper.JSONToInsumo(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
