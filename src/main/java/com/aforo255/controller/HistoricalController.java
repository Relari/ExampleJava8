package com.aforo255.controller;

import com.aforo255.mshistorical.model.api.TransactionResponse;
import com.aforo255.mshistorical.model.domain.Transaction;
import com.aforo255.mshistorical.service.TransactionService;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/historials")
public class HistoricalController {

	@Autowired
	private TransactionService _transaction ;
	
	@GetMapping
	public Observable<TransactionResponse> listar (){
		return _transaction.findAll()
				.map(this::mapTransactionResponse);
	}

	private TransactionResponse mapTransactionResponse(Transaction transaction) {
		return TransactionResponse.builder()
				.accountId(transaction.getAccountId())
				.amount(transaction.getAmount())
				.id(transaction.getId().toString())
				.type(transaction.getType())
				.build();
	}
	
	@GetMapping ("/transaction/{accountId}")
	public Observable<TransactionResponse> getByAccountId (
			@PathVariable Integer accountId){
		return _transaction.findByAccountId(accountId)
				.map(this::mapTransactionResponse);
	}	
}