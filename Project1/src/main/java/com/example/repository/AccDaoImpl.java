package com.example.repository;

import javax.persistence.EntityManager;

import com.example.entity.Account;
import com.example.persistant.EntityManageFactory;

public class AccDaoImpl implements AccRepo{

	public boolean transfer(String account) {
		
		EntityManager em = EntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		Account acc = em.find(Account.class, account);
		
		em.getTransaction().commit();
		em.close();
		
		if(acc==null) {
			return false;
		}else {
			return true;
		}
	}

	public double balance(String account) {
		
		EntityManager em = EntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		Account acc = em.find(Account.class, account);
		double bal = acc.getAccountBalance();
		
		em.getTransaction().commit();
		em.close();
		
		return bal;
	}

	public void update(String accountNumber, double balance) {
		
		EntityManager em = EntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();

		Account account = em.find(Account.class, accountNumber);
		account.setAccountBalance(balance);

		em.getTransaction().commit();
		em.close();
		
	}
	
	
	
}