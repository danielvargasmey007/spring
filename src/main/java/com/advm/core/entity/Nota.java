package com.advm.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name="NOTA")
@Entity
@XmlRootElement
public class Nota {

	@GeneratedValue
	@Id
	@Column(name= "ID")
	private int id;
	
	@Column(name= "NOMBRE")
	private String nombre;
	
	@Column(name= "TITULO")
	private String titulo;
	
	@Column(name= "CONTENIDO")
	private String contenido;

	public Nota() {
	}

	public Nota(int id, String nombre, String titulo, String contenido) {
		this.id = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
	
}
