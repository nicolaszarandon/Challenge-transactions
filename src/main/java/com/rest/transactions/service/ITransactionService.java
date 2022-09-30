package com.rest.transactions.service;

import java.util.List;

import com.rest.transactions.dto.SumaDto;
import com.rest.transactions.entity.Transaction;

public interface ITransactionService {
	
	Transaction save(Transaction transaction, long id);
	List<Long> findByType(String type);
	SumaDto parent(Long id);
	
}
