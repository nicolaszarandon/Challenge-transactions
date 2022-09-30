package com.rest.transactions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

	private long transactionId;
	
	private double amount;
	
	private String type;
	
	private long parentId;
	
	private double sum;	
	
}
