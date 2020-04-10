package br.com.nac.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.nac.dao.GenericDao;
import br.com.nac.exception.CommitException;
import br.com.nac.exception.KeyNotFoundException;

public abstract class GenericDaoImpl<T, K> implements GenericDao<T, K> {
	EntityManager em;
	private Class<T> clazz;

	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType)
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public void create(T object) {
		em.persist(object);
	}

	@Override
	public T read(K key){
		T object = em.find(clazz, key);
		return object;
	}

	@Override
	public void update(T object) {
		em.merge(object);
	}

	@Override
	public void delete(K key) throws KeyNotFoundException {
		T object = read(key);
		if(object == null) {
			throw new KeyNotFoundException();
		}
		em.remove(object);
		
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}

}
