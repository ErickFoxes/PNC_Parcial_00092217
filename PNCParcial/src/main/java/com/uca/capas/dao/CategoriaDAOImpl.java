package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Categoria;

@Component
public class CategoriaDAOImpl implements CategoriaDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);

		List<Categoria> res = query.getResultList();
		return res;
	}

	@Override
	public Categoria findOne(Integer cat) throws DataAccessException {
		Categoria categoria = entityManager.find(Categoria.class, cat);
		return categoria;
	}

	@Override
	@Transactional
	public void save(Categoria cat) throws DataAccessException {
		entityManager.persist(cat);
		
	}

}
