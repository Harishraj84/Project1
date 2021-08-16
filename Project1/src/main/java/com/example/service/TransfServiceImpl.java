package com.example.service;


import java.util.Date;


import com.example.entity.Txn;
import com.example.entity.TxnType;
import com.example.exceptionhandler.AccountNotFoundException;
import com.example.exceptionhandler.AmountRangeError;
import com.example.repository.AccDaoImpl;
import com.example.repository.AccRepo;
import com.example.repository.TxnRepo;
import com.example.repository.TxnRepoImpl;


public class TransfServiceImpl implements TransfService {
	@Override
	public void txr(String fromAccount, String toAccount, double amount) {

		AccRepo accRepo = new AccDaoImpl();
		TxnRepo txnRepo= new TxnRepoImpl();
		Txn txn = null;
		
		boolean flag;
		int count = 0;
		try {
			flag = accRepo.transfer(fromAccount);
			if(!flag) {
				count=1;
				throw new AccountNotFoundException();
			}
			flag = accRepo.transfer(toAccount);
			if(!flag) {
				throw new AccountNotFoundException();
			}
			if(accRepo.balance(fromAccount)<amount ) {
				throw new AmountRangeError();
			}
			else {
				accRepo.update(fromAccount, accRepo.balance(fromAccount)-amount);
				txn = new Txn(fromAccount, new Date(), amount, TxnType.DEBIT);
				txnRepo.save(txn);
				accRepo.update(toAccount, accRepo.balance(toAccount)+amount);
				txn = new Txn(toAccount, new Date(), amount, TxnType.CREDIT);
				txnRepo.save(txn);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
