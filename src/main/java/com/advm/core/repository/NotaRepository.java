package com.advm.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advm.core.entity.Nota;

@Repository("repositorynota")
public interface NotaRepository extends JpaRepository<Nota, Serializable>{

	public abstract Nota findByNombre(String nombre);
	public abstract Nota findById(int id);
	public abstract Nota findByTitulo(String titulo);
	public abstract Nota findByContenido(String contenido);
	public abstract Nota findByTituloAndId(String titulo, int id);
	
}
