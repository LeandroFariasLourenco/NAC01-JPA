package br.com.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.nac.dao.ServicosDao;
import br.com.nac.entity.Servico;

public class ServicosDaoImpl extends GenericDaoImpl<Servico,Integer> implements ServicosDao{

	public ServicosDaoImpl(EntityManager em) {
		super(em);
	}

}
