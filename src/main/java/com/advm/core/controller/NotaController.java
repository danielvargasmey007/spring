package com.advm.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advm.core.entity.Nota;
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
}
