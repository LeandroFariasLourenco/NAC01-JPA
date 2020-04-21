package br.com.nac.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.nac.dao.ContaCorrenteDao;
import br.com.nac.dao.impl.ContaCorrenteDaoImpl;
import br.com.nac.entity.Agencia;
import br.com.nac.entity.Cliente;
import br.com.nac.entity.ContaCorrente;
import br.com.nac.entity.Servico;
import br.com.nac.enums.Genero;
import br.com.nac.exception.CommitException;

public class ServicoView {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = factory.createEntityManager();
		
		Cliente cliente1 = new Cliente("Lucas",Calendar.getInstance(),Genero.MASCULINO,"1234567890","l@h.com","Poá");
		
		ContaCorrente conta1 = new ContaCorrente(2122,050201);
		conta1.setCliente(cliente1);
		
		Servico servico1 = new Servico("Seguro",(float)15.40);
		Servico servico2 = new Servico("Crédito",(float)1.00);
		List<Servico> servicos = new ArrayList<Servico>();
		servicos.add(servico1);
		servicos.add(servico2);
		
		conta1.setServicos(servicos);
		
		Agencia agencia = new Agencia(6543,"Av Paulista");
		conta1.setAgencia(agencia);
		
		ContaCorrenteDao dao = new ContaCorrenteDaoImpl(em);
		dao.create(conta1);
		try {
			dao.commit();
		} catch (CommitException e) {
			System.out.println("Erro...");
		}
		em.close();
		factory.close();
	}
}
