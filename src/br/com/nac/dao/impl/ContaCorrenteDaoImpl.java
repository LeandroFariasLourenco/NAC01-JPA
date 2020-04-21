package br.com.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.dao.ContaCorrenteDao;
import br.com.nac.entity.ContaCorrente;

public class ContaCorrenteDaoImpl extends GenericDaoImpl<ContaCorrente,Integer> implements ContaCorrenteDao{

	public ContaCorrenteDaoImpl(EntityManager em) {
		super(em);
	}

}
