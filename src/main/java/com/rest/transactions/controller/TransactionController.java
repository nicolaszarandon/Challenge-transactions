package com.rest.transactions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.transactions.entity.Transaction;
import com.rest.transactions.service.ITransactionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private final ITransactionService transactionService;
	    
	
	@PutMapping("/{id}")
	public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction, @PathVariable Long id){
		transactionService.save(transaction,id);
		return ResponseEntity.status(HttpStatus.OK).build();	
	}
	
	@GetMapping("/types/{type}")
	public List<Long> type(@PathVariable("type") String type){
		List<Long> listTransaction =transactionService.findByType(type);		
		return listTransaction;
	}
	
	@GetMapping("/sum/{id}")
	public ResponseEntity<?> suma(@PathVariable("id") Long id){
		return ResponseEntity.ok( transactionService.parent(id));
		
		
		
	}
	
	
}
