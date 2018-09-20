package com.advm.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.advm.core.converter.converter;
import com.advm.core.entity.Nota;
import com.advm.core.model.NotaModel;
import com.advm.core.repository.NotaRepository;

@Service("servicenota")
public class NotaService {

	@Autowired
	@Qualifier("repositorynota")
	private NotaRepository repository;

	@Autowired
	@Qualifier("converternota")
	private converter converter;
	
	public boolean Created(Nota nota){
		try {
			
			repository.save(nota);
			
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}
	public boolean Updated(Nota nota){
		try {
			if(repository.findById(nota.getId()) != null){
			repository.save(nota);}
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}
	public boolean Deleted(int id){
		try {
			Nota nota=repository.findById(id);
			repository.delete(nota);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}
	public List<NotaModel> Gets(){
		
		return converter.ListConverter(repository.findAll());
	}
	public NotaModel GetsByTittleAndId(String titulo, int id){
		
		return new NotaModel(repository.findByTituloAndId(titulo,id));
	}
	public NotaModel GetsByName(String nombre){
		
		return new NotaModel(repository.findByNombre(nombre));
	}
	public NotaModel GetsById(int id){
		
		return new NotaModel(repository.findById(id));
	}
	public NotaModel GetsByTittle(String titulo){
		
		return new NotaModel(repository.findByTitulo(titulo));
	}
	public NotaModel GetsByContent(String contenido){
		
		return new NotaModel(repository.findByContenido(contenido));
	}
}
