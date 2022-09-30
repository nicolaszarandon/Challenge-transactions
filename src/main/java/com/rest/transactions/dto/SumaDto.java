package com.rest.transactions.dto;

import org.springframework.stereotype.Component;

@Component
public class SumaDto {
	
	private double sum;

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public SumaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SumaDto(double sum) {
		super();
		this.sum = sum;
	}
	
	

}
