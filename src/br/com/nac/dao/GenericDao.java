package br.com.nac.dao;

import br.com.nac.exception.CommitException;
import br.com.nac.exception.KeyNotFoundException;

public interface GenericDao {
	void create();
	void read() throws KeyNotFoundException;
	void update();
	void delete();
	void commit() throws CommitException;
}