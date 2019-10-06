package com.reavture.evaluation.pojo;

import java.io.Serializable;

public class Offer implements Serializable{
	
	private String userName;
	
	private Status status;
	
	private double amount;
	
	private String carVin;
	
	private int offerId; 
	
	
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Offer(String userName, Status status, double amount, String carVin, int offerId) {
		super();
		this.userName = userName;
		this.status = status;
		this.amount = amount;
		this.carVin = carVin;
		this.offerId = offerId;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getCarVin() {
		return carVin;
	}

	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((carVin == null) ? 0 : carVin.hashCode());
		result = prime * result + offerId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (carVin == null) {
			if (other.carVin != null)
				return false;
		} else if (!carVin.equals(other.carVin))
			return false;
		if (offerId != other.offerId)
			return false;
		if (status != other.status)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}







	@Override
	public String toString() {
		return "Offer [userName=" + userName + ", status=" + status + ", amount=" + amount + ", carVin=" + carVin
				+ ", offerId=" + offerId + "]";
	}







	public static enum Status{
		ACCEPTED, REJECTED, PENDING;
	}
	

}
