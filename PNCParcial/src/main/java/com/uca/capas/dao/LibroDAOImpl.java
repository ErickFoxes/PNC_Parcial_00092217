package com.uca.capas.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;

@Component
public class LibroDAOImpl implements LibroDAO{
	
	@Autowired
	CategoriaDAO categoriaDAO;
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);

		List<Libro> res = query.getResultList();
		return res;
	}

	@Override
	public Libro findOne(Integer lib) throws DataAccessException {
		Libro libro = entityManager.find(Libro.class, lib);
		return libro;
	}

	@Override
	@Transactional
	public void save(Libro lib) throws DataAccessException {
		LocalDate hoy = LocalDate.now();
		lib.setFingreso(hoy);
		lib.setCategoria(categoriaDAO.findOne(lib.getC_categoria()));
		entityManager.persist(lib);
		
	}

}
