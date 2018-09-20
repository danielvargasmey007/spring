package com.advm.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advm.core.entity.Nota;
import com.advm.core.model.NotaModel;
import com.advm.core.service.NotaService;

@RestController
@RequestMapping("/v1")
public class NotaController {

	@Autowired
	@Qualifier("servicenota")
	NotaService nota_service;
	
	@PutMapping("/nota")
	public boolean AddNota(@RequestBody @Valid Nota nota){
	
		return nota_service.Created(nota);
	}
	@PostMapping("/nota")
	public boolean UpdateNota(@RequestBody @Valid Nota nota){
		
		return nota_service.Updated(nota);
	}
	@DeleteMapping("/nota/{id}")
	public boolean DeleteNota(@PathVariable("id") int id){
		
		return nota_service.Deleted(id);
	}
	@GetMapping("/notas")
	public List<NotaModel> GetNota(){
		
		return nota_service.Gets();
	}
	@GetMapping("/notas/{name}")
	public NotaModel GetsByName(@PathVariable("name") String name){
		
		return nota_service.GetsByName(name);
	}
}
