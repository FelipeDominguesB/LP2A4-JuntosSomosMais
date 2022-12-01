package com.challenge.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.challenge.helpers.CSVHelper;
import com.challenge.helpers.JSONHelper;
import com.challenge.models.Insumo;
import com.challenge.repositories.InsumoMap;

@Service
public class InsumoService {

	InsumoMap map;
	
	InsumoService()
	{
		map = new InsumoMap();
	}
	
	public List<Insumo> getInsumoList(Optional<String> type, Optional<String> region)
	{
		List<Insumo> insumos = new ArrayList<Insumo>();
		
		if(type.isEmpty() && region.isEmpty())
		{
			insumos = map.pegarInsumos();
		}
		else 
		{
			insumos = map.pegarInsumosFiltrados(type.orElse("Trabalhoso"), region.orElse("NORTE"));
		}
		
		return insumos;
	}
	
	public List<Insumo> readInsumosFromCSV(MultipartFile file)
	{
		try {
			return CSVHelper.csvToInsumo(file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Insumo> readInsumosFromJSON(MultipartFile file)
	{
		try {
			return JSONHelper.JSONToInsumo(file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
