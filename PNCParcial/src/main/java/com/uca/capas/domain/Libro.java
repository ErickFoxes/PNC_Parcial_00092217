package com.uca.capas.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public",name="cat_libro")
public class Libro {

/*--------------VARIABLES---------------------*/
	
	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo_cat;
	
	@Column(name="s_titulo")
	private String titulo;
	
	@Column(name="s_autor")
	private String autor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer c_categoria;

	@DateTimeFormat(pattern="dd/MMM/YYYY")
	@Column(name="f_ingreso")
	private LocalDate fingreso;
	
	@Column(name="b_estado")
	private Boolean estado;
	
	@Column(name="s_isbn")
	private String isbn;

	
/*--------------VARIABLES---------------------*/	
	
/*--------------SETTERS AND GETTERS---------------------*/
	
	public Integer getCodigo_cat() {
		return codigo_cat;
	}

	public void setCodigo_cat(Integer codigo_cat) {
		this.codigo_cat = codigo_cat;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LocalDate getFingreso() {
		return fingreso;
	}

	public void setFingreso(LocalDate fingreso) {
		this.fingreso = fingreso;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}
	
/*--------------SETTERS AND GETTERS---------------------*/

/*--------------Funciones delegate---------------------*/
	public String getEstadoDelegate() {
		if(this.estado == null) return "";
		else {
			return estado == true ?"Activo":"Inactivo";
		}
	}
/*--------------Funciones delegate---------------------*/
}
