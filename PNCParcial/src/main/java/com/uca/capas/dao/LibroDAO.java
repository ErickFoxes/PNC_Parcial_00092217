package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Libro;

public interface LibroDAO {
	public List<Libro> findAll() throws DataAccessException;
	public Libro findOne(Integer c) throws DataAccessException;
	public void save(Libro c) throws DataAccessException;
}
