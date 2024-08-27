package com.aforo255.mshistorical.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "transaction")
public class TransactionEntity {

	@Id
	private String id ; 
	private double amount ;
	private String type;
	private int accountId;


}
