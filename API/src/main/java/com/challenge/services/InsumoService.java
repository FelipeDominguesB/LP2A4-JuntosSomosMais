package com.challenge.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	public Optional<Insumo> getInsumoById()
	{
		return this.repo.findById((long) 1);
	}
	public List<Insumo> getInsumos()
	{
		return this.repo.findAll();
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
