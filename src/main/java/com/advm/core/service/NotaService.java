package com.advm.core.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	private static final Log log = LogFactory.getLog(NotaService.class) ;
	public boolean Created(Nota nota){
		try {
			log.info("CREATING NOTA");
			repository.save(nota);
			
			return true;
		} catch (Exception e) {
			log.info("CREATING NOTA FAILED");
			return false;
		}
		
	}
	public boolean Updated(Nota nota){
		try {
			log.info("UPDAATING NOTA");
			if(repository.findById(nota.getId()) != null){
			repository.save(nota);}
			return true;
		} catch (Exception e) {
			log.info("UPDAATING NOTA FAILED");
			return false;
		}
		
	}
	public boolean Deleted(int id){
		try {
			log.info("DELEATING NOTA");
			Nota nota=repository.findById(id);
			repository.delete(nota);
			return true;
		} catch (Exception e) {
			
			log.info("DELEATING NOTA FAILED");
			return false;
		}
		
	}
	public List<NotaModel> Gets(){
		
		log.info("QUERY NOTAS");
		return converter.ListConverter(repository.findAll());
	}
	public NotaModel GetsByTittleAndId(String titulo, int id){
		log.info("QUERY NOTAS BY ID AND TITLE");
		return new NotaModel(repository.findByTituloAndId(titulo,id));
	}
	public NotaModel GetsByName(String nombre){
		log.info("QUERY NOTAS BY NAME");
		return new NotaModel(repository.findByNombre(nombre));
	}
	public NotaModel GetsById(int id){
		log.info("QUERY NOTAS BY ID");
		return new NotaModel(repository.findById(id));
	}
	public NotaModel GetsByTittle(String titulo){
		log.info("QUERY NOTAS BY TITLE");
		return new NotaModel(repository.findByTitulo(titulo));
	}
	public NotaModel GetsByContent(String contenido){
		log.info("QUERY NOTAS BY CONTENT");
		return new NotaModel(repository.findByContenido(contenido));
	}

}
