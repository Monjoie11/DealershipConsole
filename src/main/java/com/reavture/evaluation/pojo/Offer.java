package com.reavture.evaluation.pojo;

import java.io.Serializable;

public class Offer implements Serializable{
	
	private Customer customer;
	
	private Status status;
	
	private double amount;
	
	private Car car;
	
	private String offerId; 
	
	
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Offer(Customer customer, Status status, double amount, Car car, String offerId) {
		super();
		this.customer = customer;
		this.status = status;
		this.amount = amount;
		this.car = car;
		this.offerId = offerId;
	}

	

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Car getCar() {
		return car;
	}



	public void setCar(Car car) {
		this.car = car;
	}


	public String getOfferId() {
		return offerId;
	}


	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((offerId == null) ? 0 : offerId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (offerId == null) {
			if (other.offerId != null)
				return false;
		} else if (!offerId.equals(other.offerId))
			return false;
		if (status != other.status)
			return false;
		return true;
	}



	public static enum Status{
		ACCEPTED, REJECTED, PENDING;
	}
	

}
