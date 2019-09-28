package com.reavture.evaluation.controller;

import com.reavture.evaluation.exception.InvalidOfferException;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Offer.Status;
import com.revature.evaluation.utility.Sales;

public class SalesSystem implements Sales {

	private int payPeriod;

	private double tradeValue;

	private double totalInterest;

	Offer accepted = new Offer(null , Offer.Status.ACCEPTED, 10000.00);
	
	

	@Override
	public int setPayPeriod(int period) {
		if (period < 0 || period > 480) {
			throw new IllegalArgumentException("payperiod must be bewteen 0 and 480, in months");
		}
		this.payPeriod = period;
		return payPeriod;
	}

	@Override
	public double setTradeValue(double trade) {
		if (trade < 0) {
			throw new IllegalArgumentException("trade value must be a positive number");
		}
		this.tradeValue = trade;
		return tradeValue;
	}

	@Override
	public double determinePayment(int period, double purcahsePrice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double determinePurcahsePrice(double offer, double totalInterest, double tradeValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double determineInterest(double rate) {
		if (rate < 0.03 || .26 < rate) {
			throw new IllegalArgumentException("interest rate should be negotiated ");
		}
		

		/*
		 * if (accepted.getStatus() == Offer.Status.ACCEPTED) { totalInterest = rate *
		 * accepted.getAmount(); } else { throw new InvalidOfferException(); }
		 */
		System.out.print(accepted.getAmount());
		totalInterest = rate * accepted.getAmount();
		
		return totalInterest;
	}

}
