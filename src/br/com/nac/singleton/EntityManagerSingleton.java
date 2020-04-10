package br.com.nac.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
	private static EntityManagerFactory factory;
	
	private EntityManagerSingleton() {
		
	}
	
	public static EntityManagerFactory getInstace() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("oracle");
		}
		return factory;
	}
}
