package br.com.nac.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.nac.dao.ClienteDao;
import br.com.nac.dao.impl.ClienteDaoImpl;
import br.com.nac.entity.Cliente;
import br.com.nac.enums.Genero;
import br.com.nac.exception.CommitException;

public class ClienteView {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = factory.createEntityManager();
		
		Cliente cliente = new Cliente();
		ClienteDao dao = new ClienteDaoImpl(em);
		
		cliente.setCpf("48357713890");
		cliente.setDataNascimento(Calendar.getInstance());
		cliente.setEmail("leandro.farias01@outlook.com");
		cliente.setEndereco("Rua Torquato");
		cliente.setGenero(Genero.MASCULINO);
		cliente.setNome("Leandro");
		
		dao.create(cliente);
		try {
			dao.commit();
		} catch (CommitException e) {
			System.out.println("Erro...");
		}
		
		em.close();
		factory.close();
	}
	
}
