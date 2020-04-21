package br.com.nac.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.nac.dao.ContaCorrenteDao;
import br.com.nac.dao.impl.ContaCorrenteDaoImpl;
import br.com.nac.entity.Agencia;
import br.com.nac.entity.Cliente;
import br.com.nac.entity.ContaCorrente;
import br.com.nac.enums.Genero;
import br.com.nac.exception.CommitException;

public class ContaCorrenteView {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = factory.createEntityManager();
		
		Cliente cliente = new Cliente();
		ContaCorrenteDao dao = new ContaCorrenteDaoImpl(em);
		
		cliente.setCpf("48357713890");
		cliente.setDataNascimento(Calendar.getInstance());
		cliente.setEmail("leandro.farias01@outlook.com");
		cliente.setEndereco("Rua Torquato");
		cliente.setGenero(Genero.MASCULINO);
		cliente.setNome("Leandro");
		
		ContaCorrente conta1 = new ContaCorrente(6140,050201);
		conta1.setCliente(cliente);
		
		Agencia agencia = new Agencia(123,"Av lins");

		conta1.setAgencia(agencia);
		
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
