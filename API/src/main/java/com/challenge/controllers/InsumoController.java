package com.challenge.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.challenge.models.Insumo;
import com.challenge.services.InsumoService;

@RestController
@RequestMapping("/api/insumos")
public class InsumoController {
	
	InsumoService insumoService;
	@Autowired
	InsumoController(InsumoService insumoService)
	{
		this.insumoService = insumoService;
	}
	
	
	@GetMapping("byId")
	ResponseEntity<Optional<Insumo>> getById(Optional<Long> id)
	{	
		try {
			Optional<Insumo> insumo = this.insumoService.getInsumoById(id);
			 
			if(insumo.isEmpty()) throw new Exception("Sem registros");
			return new ResponseEntity<Optional<Insumo>>(insumo, HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping()
	ResponseEntity<Map<String, Object>> get(@RequestParam(defaultValue = "0") int index, @RequestParam(defaultValue = "5") int size, @RequestParam() Optional<String> type, @RequestParam Optional<String> region)
	{	
		Map<String, Object> response = new HashMap<>();
		try {

			
			Page<Insumo> insumoPage = this.insumoService.getInsumosByRegionAndType(index, size, region, type);
			List<Insumo> insumos = insumoPage.toList();
			
			
			if(insumos.size() == 0) throw new Exception("Sem registros");
			
			
			response.put("results", insumos);
			response.put("pageSize", insumoPage.getSize());
			response.put("pageNumber", insumoPage.getNumber());
			response.put("totalPages", insumoPage.getTotalPages());
			response.put("totalSize", insumoPage.getTotalElements());
			return new ResponseEntity<>(response, HttpStatus.OK);	
		} catch (Exception e) {
			
			response.clear();
			response.put("Error message:", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("csv")
	ResponseEntity<List<Insumo>> sendCSV(MultipartFile file)
	{
		try {
			List<Insumo> insumos = this.insumoService.readInsumosFromCSV(file);
			 
			if(insumos == null) throw new Exception("Erro ao ler CSV");
			return new ResponseEntity<List<Insumo>>(this.insumoService.saveInsumos(insumos), HttpStatus.CREATED);	
		} catch (Exception e) {
			return new ResponseEntity<List<Insumo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("json")
	ResponseEntity<List<Insumo>> sendJson(MultipartFile file)
	{
		try {
			List<Insumo> insumos = this.insumoService.readInsumosFromJSON(file);
			if(insumos == null) throw new Exception("Erro ao ler CSV");
			return new ResponseEntity<List<Insumo>>(this.insumoService.saveInsumos(insumos), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<List<Insumo>>(HttpStatus.BAD_REQUEST);
		}
	}
}