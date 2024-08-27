package com.aforo255.mshistorical.dao.repository;

import com.aforo255.mshistorical.model.entity.TransactionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<TransactionEntity, String> {

	Flux<TransactionEntity> findByAccountId(Integer accountId);

}
