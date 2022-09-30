package com.rest.transactions.converter;

import org.springframework.stereotype.Component;

import com.rest.transactions.dto.TransactionDto;
import com.rest.transactions.entity.Transaction;

@Component
public class TransactionDtoConverter {
	
	public TransactionDto toDto(Transaction transaction) {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setAmount(transaction.getAmount());
		transactionDto.setType(transaction.getType());
		transactionDto.setParentId(transaction.getParentId());
		return transactionDto;
		
		
	}

}
