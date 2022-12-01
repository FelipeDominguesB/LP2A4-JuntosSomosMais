package com.challenge.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@GetMapping("id")
	ResponseEntity<Optional<Insumo>> getById()
	{	
		try {
			Optional<Insumo> insumos = this.insumoService.getInsumoById();
			 
			if(insumos == null) throw new Exception("Sem registros");
			return new ResponseEntity<Optional<Insumo>>(insumos, HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Optional<Insumo>>(HttpStatus.NO_CONTENT);
		}
		//return map.pegarInsumosPaginados(this.insumoService.getInsumoList(type, region), size, index);
	}
	
	@GetMapping()
	ResponseEntity<List<Insumo>> get(@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "1") int index, @RequestParam() Optional<String> type, @RequestParam Optional<String> region)
	{	
		try {
			List<Insumo> insumos = this.insumoService.getInsumos();
			 
			if(insumos == null) throw new Exception("Sem registros");
			return new ResponseEntity<List<Insumo>>(insumos, HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<List<Insumo>>(HttpStatus.NO_CONTENT);
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