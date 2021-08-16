package com.example.repository;

import java.util.Date;
import java.util.List;

import com.example.entity.*;

public interface TxnRepo {

	void save(Txn txn);
	
	List<Txn> getTxn();
	
	List<Txn> getTxn(String account,Integer limit1);

	List<Txn> getTxn(Date fromDate, Date toDate);

	List<Txn> getTxn(int i);

	List<Txn> findByLimit(int limit);

	List<Txn> findTxnType(TxnType txnType);

	List<Txn> findAll();
	
}