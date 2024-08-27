package com.aforo255.mshistorical.dao.impl;

import com.aforo255.mshistorical.dao.TransactionDao;
import com.aforo255.mshistorical.dao.repository.TransactionRepository;
import com.aforo255.mshistorical.model.domain.Transaction;
import com.aforo255.mshistorical.model.entity.TransactionEntity;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Single<Transaction> save(Transaction transaction) {
        return Mono.fromCallable(() -> TransactionMapper.mapTransactionEntity(transaction))
                .flatMap(transactionRepository::save)
                .subscribeOn(Schedulers.immediate())
                .as(RxJava2Adapter::monoToSingle)
                .map(TransactionMapper::mapTransaction);
    }

    @Override
    public Observable<Transaction> findByAccountId(Integer accountId) {
        return transactionRepository.findByAccountId(accountId)
                .subscribeOn(Schedulers.immediate())
                .as(RxJava2Adapter::fluxToObservable)
                .map(TransactionMapper::mapTransaction);
    }

    @Override
    public Observable<Transaction> findAll() {
        return transactionRepository.findAll()
                .subscribeOn(Schedulers.immediate())
                .as(RxJava2Adapter::fluxToObservable)
                .map(TransactionMapper::mapTransaction);
    }
}
