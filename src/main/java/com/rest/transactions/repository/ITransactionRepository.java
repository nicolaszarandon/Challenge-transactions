package com.rest.transactions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rest.transactions.entity.Transaction;

public interface ITransactionRepository extends JpaRepository<Transaction, Long>{
	
		List<Transaction> findByType(String type);
		

}
