package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="cat_categoria")
public class Categoria {
	
	@Id
	@Column(name="c_categoria")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo_cat;
	
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max=50)
	@NotEmpty(message="El campo nombre categoría no puede estar vacío")
	@Column(name="s_categoria")
	private String nombre;
	
	public Categoria() {} 
	
/*-------------------GETTERS AND SETTERS----------------------------------*/
	public Integer getCodigo_cat() {
		return codigo_cat;
	}

	public void setCodigo_cat(Integer codigo_cat) {
		this.codigo_cat = codigo_cat;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*-------------------GETTERS AND SETTERS----------------------------------*/
	
	
}
