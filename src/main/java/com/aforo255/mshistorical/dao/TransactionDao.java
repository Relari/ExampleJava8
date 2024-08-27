package com.aforo255.mshistorical.dao;

import com.aforo255.mshistorical.model.domain.Transaction;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface TransactionDao {

    Single<Transaction> save (Transaction transactionEntity);
    Observable<Transaction> findByAccountId (Integer accountId);
    Observable<Transaction> findAll();
}
