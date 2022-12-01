package com.challenge.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.challenge.helpers.CSVHelper;
import com.challenge.helpers.JSONHelper;
import com.challenge.models.Insumo;
import com.challenge.models.InsumoPage;
import com.challenge.repositories.InsumoMap;

@RestController
@RequestMapping("/api/insumos")
public class InsumoController {
	
	InsumoMap map;
	
	InsumoController()
	{
		map = new InsumoMap();
	}
	
	
	@GetMapping()
	InsumoPage get(@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "1") int index, @RequestParam() Optional<String> type, @RequestParam Optional<String> region)
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
		return map.pegarInsumosPaginados(insumos, size, index);
	}
	
	
	@PostMapping("csv")
	List<Insumo> sendCSV(MultipartFile file)
	{
		try {
			List<Insumo> insumos = CSVHelper.csvToInsumo(file.getInputStream());
			for(Insumo insumo : insumos)
			{
				map.InsereInsumo(insumo);
			}
			
			return map.pegarInsumos();
		} catch (IOException e) {
			return null;
		}
	}
	
	@PostMapping("json")
	List<Insumo> sendJson(MultipartFile file)
	{
		try {
			List<Insumo> insumos = JSONHelper.JSONToInsumo(file.getInputStream());
			for(Insumo insumo : insumos)
			{
				map.InsereInsumo(insumo);
			}
			
			return map.pegarInsumos();
		} catch (IOException e) {
			return null;
		}
	}
}