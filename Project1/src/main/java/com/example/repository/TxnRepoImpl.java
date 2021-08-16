package com.example.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.entity.Txn;
import com.example.entity.TxnType;
import com.example.persistant.EntityManageFactory;

public class TxnRepoImpl implements TxnRepo{

	@Override
	public void save(Txn txn) {
		EntityManager em = EntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		em.persist(txn);
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Txn> getTxn() {
		EntityManager em = EntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		List<Txn> trans = em.createQuery("from Txn").getResultList();
		
		em.getTransaction().commit();
		em.close();
		return trans;
	}

	public List<Txn> getTxn(int limit) {
		EntityManager em = EntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		Query query=em.createQuery("from Txn");
		query.setFirstResult(0);
		query.setMaxResults(limit);
		List<Txn> txns=query.getResultList();
		em.getTransaction().commit();
		em.close();
		return txns;
	}
	@Override
	public List<Txn> getTxn(String account,Integer limit1) {
		EntityManager em = EntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		String query = "from Txn where account ="+account+" order by transactionId desc  ";
		List<Txn> trans = em.createQuery(query).setFirstResult(0).setMaxResults(limit1).getResultList();
		
//		Query query=em.createQuery("from Txn where account="+account+"  ");
//		query.setFirstResult(0);
//		query.setMaxResults(limit1);
//		List<Txn> trans=query.getResultList();
		em.getTransaction().commit();
		em.close();
		return trans;
	}

	@Override
	public List<Txn> getTxn(Date fromDate, Date toDate) {
		EntityManager em = EntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		List<Txn> txns = em.createQuery("from Txn where date between "+fromDate+" and "+toDate).getResultList();
		
		em.getTransaction().commit();
		em.close();
		return txns;
	}
	
	@Override
	public List<Txn> findAll() {
		EntityManager em=EntityManageFactory.emf().createEntityManager();
		List<Txn> txns=em.createQuery("from Txn").getResultList();
		em.close();
		return txns;
	}

	@Override
	public List<Txn> findByLimit(int limit) {
		EntityManager em=EntityManageFactory.emf().createEntityManager();
		Query query=em.createQuery("from Txn");
		query.setFirstResult(0);
		query.setMaxResults(limit);
		List<Txn> txns=query.getResultList();
		em.close();
		return txns;
	}

	@Override
	public List<Txn> findTxnType(TxnType txnType) {
		EntityManager em=EntityManageFactory.emf().createEntityManager();
		Query query=em.createQuery("from Txn where type=:txnType");
		query.setParameter("txnType", txnType);
		List<Txn> txns=query.getResultList();
		em.close();
		return txns;
	}


}
