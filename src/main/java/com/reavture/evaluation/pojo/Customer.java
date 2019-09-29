package com.reavture.evaluation.pojo;

import java.io.Serializable;

import com.reavture.evaluation.pojo.Car;

public class Customer extends User implements Serializable {
	
	private String name;
	
	private String address;
	
	private Car purchasedCar;
	
	private float offer;
	
	private int paymentsMade;
	
	private int paymentsRemaining; 
	
	private float paymentAmount;
	
	


	public Customer(String userName, String password, AccessLevel accesslevel, String userId, String name, String address,
			Car purchasedCar, float offer, int paymentsMade, int paymentsRemaining, float paymentAmount) {
		super(userName, password, accesslevel, userId);
		this.name = name;
		this.address = address;
		this.purchasedCar = purchasedCar;
		this.offer = offer;
		this.paymentsMade = paymentsMade;
		this.paymentsRemaining = paymentsRemaining;
		this.paymentAmount = paymentAmount;
	}
	
	


	public Customer() {
		super();
	}




	public Customer(String userName, String password, AccessLevel accesslevel, String userId) {
		super(userName, password, accesslevel, userId);
		// TODO Auto-generated constructor stub
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Car getPurchasedCar() {
		return purchasedCar;
	}


	public void setPurchasedCar(Car purchasedCar) {
		this.purchasedCar = purchasedCar;
	}


	public float getOffer() {
		return offer;
	}


	public void setOffer(float offer) {
		this.offer = offer;
	}


	public int getPaymentsMade() {
		return paymentsMade;
	}


	public void setPaymentsMade(int paymentsMade) {
		this.paymentsMade = paymentsMade;
	}


	public int getPaymentsRemaining() {
		return paymentsRemaining;
	}


	public void setPaymentsRemaining(int paymentsRemaining) {
		this.paymentsRemaining = paymentsRemaining;
	}


	public float getPaymentAmount() {
		return paymentAmount;
	}


	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(offer);
		result = prime * result + Float.floatToIntBits(paymentAmount);
		result = prime * result + paymentsMade;
		result = prime * result + paymentsRemaining;
		result = prime * result + ((purchasedCar == null) ? 0 : purchasedCar.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(offer) != Float.floatToIntBits(other.offer))
			return false;
		if (Float.floatToIntBits(paymentAmount) != Float.floatToIntBits(other.paymentAmount))
			return false;
		if (paymentsMade != other.paymentsMade)
			return false;
		if (paymentsRemaining != other.paymentsRemaining)
			return false;
		if (purchasedCar == null) {
			if (other.purchasedCar != null)
				return false;
		} else if (!purchasedCar.equals(other.purchasedCar))
			return false;
		return true;
	}
	
	

}
