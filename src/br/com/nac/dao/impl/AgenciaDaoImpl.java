package br.com.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.dao.AgenciaDao;
import br.com.nac.entity.Agencia;

public class AgenciaDaoImpl extends GenericDaoImpl<Agencia,Integer> implements AgenciaDao{

	public AgenciaDaoImpl(EntityManager em) {
		super(em);
	}

}
