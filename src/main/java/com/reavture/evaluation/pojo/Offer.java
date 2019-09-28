package com.reavture.evaluation.pojo;

public class Offer {
	
	private Customer customer;
	
	private Status status;
	
	private float amount;
	
	
	
	
	public Offer() {
		super();
	}

	public Offer(Customer customer, Status status, float amount) {
		super();
		this.customer = customer;
		this.status = status;
		this.amount = amount;
	}
	
	
	




	enum Status{
		ACCEPTED, REJECTED, PENDING;
	}
	

}
