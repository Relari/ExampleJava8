package com.aforo255.mshistorical.dao.impl;

import com.aforo255.mshistorical.model.domain.Transaction;
import com.aforo255.mshistorical.model.entity.TransactionEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionMapper {

    public static TransactionEntity mapTransactionEntity(Transaction transaction) {
        return TransactionEntity.builder()
                .accountId(transaction.getAccountId())
                .amount(transaction.getAmount())
                .id(transaction.getId().toString())
                .type(transaction.getType())
                .build();
    }

    public static Transaction mapTransaction(TransactionEntity transactionEntity) {
        return Transaction.builder()
                .accountId(transactionEntity.getAccountId())
                .amount(transactionEntity.getAmount())
                .id(Integer.valueOf(transactionEntity.getId()))
                .type(transactionEntity.getType())
                .build();
    }

}
