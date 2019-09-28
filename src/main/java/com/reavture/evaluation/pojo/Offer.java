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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (status != other.status)
			return false;
		return true;
	}





	enum Status{
		ACCEPTED, REJECTED, PENDING;
	}
	

}
