package com.rest.transactions.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.transactions.dto.SumaDto;
import com.rest.transactions.entity.Transaction;
import com.rest.transactions.repository.ITransactionRepository;
import com.rest.transactions.service.ITransactionService;

@Service
public class TransactionServiceImpl implements ITransactionService{
	
	@Autowired
	private ITransactionRepository transactionRepository;
	
	@Autowired
    private  SumaDto sumaDto;
	
	@Override
	public Transaction save(Transaction transaction, long id) {
				
		Transaction nuevo = new Transaction();
		nuevo.setTransactionId(id);
		nuevo.setAmount(transaction.getAmount());
		nuevo.setType(transaction.getType());
		nuevo.setParentId(transaction.getParentId());
		transactionRepository.save(nuevo);
		
		return nuevo;		
	}

	@Override
	public List<Long> findByType(String type) {
		List<Transaction> transactions 	=	transactionRepository.findByType(type);
		
		return transactions.stream().map(p->p.getTransactionId()).collect(Collectors.toList());
	}

	@Override
	public SumaDto parent(Long id) {
		Transaction parent = transactionRepository.findById(id).orElse(null);
		double sum =parent.getAmount();
		
		List<Transaction> all = transactionRepository.findAll();
		for(Transaction paren:all) {
			if(parent.getTransactionId()==paren.getParentId()) {
				sum = paren.getAmount()+sum;
			}
			
		}
		
		sumaDto.setSum(sum);
		return sumaDto;
	}
	
	}
	
	


