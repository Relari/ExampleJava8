package com.aforo255.mshistorical.model.api;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

	private String id ;
	private double amount ;
	private String type;
	private int accountId;


}
