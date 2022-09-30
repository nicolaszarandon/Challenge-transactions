package com.rest.transactions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	@Id
	@Column(name = "transaction_id")
	private long transactionId;
	@Column(name="amount")
	private double amount;
	@Column(name="type")
	private String type;
	@Column(name="parent_id")
	@Nullable
	private long parentId;
	
	}