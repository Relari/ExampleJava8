package com.aforo255.mshistorical.service.impl;

import com.aforo255.mshistorical.dao.TransactionDao;
import com.aforo255.mshistorical.model.domain.Transaction;
import com.aforo255.mshistorical.service.TransactionService;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;
	
	@Override
	public Single<Transaction> save(Transaction transaction) {
		return transactionDao.save(transaction);
	}

	@Override
	public Observable<Transaction> findByAccountId(Integer accountId) {
		return transactionDao.findByAccountId(accountId);
	}

	@Override
	public Observable<Transaction> findAll() {
		return transactionDao.findAll();
	}

}
