package br.com.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.dao.ClienteDao;
import br.com.nac.entity.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao{
	
	public ClienteDaoImpl(EntityManager em) {
		super(em);
	}
	
}
