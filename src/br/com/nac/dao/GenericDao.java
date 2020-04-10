package br.com.nac.dao;

import br.com.nac.exception.CommitException;
import br.com.nac.exception.KeyNotFoundException;

public interface GenericDao<T , K> {
	void create(T object);
	T read(K key);
	void update(T object);
	void delete(K key) throws KeyNotFoundException;
	void commit() throws CommitException;
}