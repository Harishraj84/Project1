package com.example.persistant;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManageFactory {

	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("persis");
	}

	public static EntityManagerFactory emf() {
		return emf;
	}
	
}
