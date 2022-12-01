package com.challenge.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.challenge.helpers.CSVHelper;
import com.challenge.helpers.JSONHelper;
import com.challenge.models.Insumo;
import com.challenge.models.InsumoPage;
import com.challenge.repositories.InsumoMap;

@RestController
public class InsumoController {
	
	InsumoMap map;
	
	InsumoController()
	{
		map = new InsumoMap();
	}
	
	
	@GetMapping("getInsumos")
	List<Insumo> getInsumos()
	{
		return map.pegarInsumos();
	}
	
	@GetMapping("getInsumosComFiltro/attr")
	List<Insumo> getInsumosComFiltro(@RequestParam String type, @RequestParam String region)
	{
		return map.pegarInsumosFiltrados(type, region);
	}
	
	@GetMapping("getInsumosPaginados/attr")
	InsumoPage getInsumosPaginados(@RequestParam int size, @RequestParam int index)
	{
		return map.pegarInsumosPaginados(map.pegarInsumos(), size, index);
	}
	
	
	@GetMapping("getInsumosPaginadosComFiltro/attr")
	InsumoPage getInsumosPaginadosComFiltro(@RequestParam String type, @RequestParam String region, @RequestParam int size, @RequestParam int index)
	{
		return map.pegarInsumosPaginados(map.pegarInsumosFiltrados(type, region), size, index);
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
			List<Insumo> insumos = JSONHelper.JSONToInsumo(new URL("https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.json").openStream());
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