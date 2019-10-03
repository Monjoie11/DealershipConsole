package com.reavture.evaluation.pojo;

import java.io.Serializable;

import com.reavture.evaluation.pojo.Car;

public class Customer extends User implements Serializable {
	
	private String firstName;
	
	private String lastName;
	
	private String customerId;
	
	private String address;
	
	private Car purchasedCar;
	
	private Offer offer;
	
	private int paymentsMade;
	
	private int paymentsRemaining; 
	
	private float paymentAmount;

	public Customer(String userName, String password, AccessLevel accesslevel, String userId, String firstName,
			String lastName, String customerId, String address, Car purchasedCar, Offer offer, int paymentsMade,
			int paymentsRemaining, float paymentAmount) {
		super(userName, password, accesslevel, userId);
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.address = address;
		this.purchasedCar = purchasedCar;
		this.offer = offer;
		this.paymentsMade = paymentsMade;
		this.paymentsRemaining = paymentsRemaining;
		this.paymentAmount = paymentAmount;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String userName, String password, AccessLevel accesslevel, String userId) {
		super(userName, password, accesslevel, userId);
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
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
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", customerId=" + customerId
				+ ", address=" + address + ", purchasedCar=" + purchasedCar + ", offer=" + offer + ", paymentsMade="
				+ paymentsMade + ", paymentsRemaining=" + paymentsRemaining + ", paymentAmount=" + paymentAmount + "]";
	}

	
	

	

}
