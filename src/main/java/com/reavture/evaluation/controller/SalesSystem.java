package com.reavture.evaluation.controller;

import com.revature.evaluation.utility.Sales;

public class SalesSystem implements Sales{
	
	int payPeriod;

	@Override
	public int setPayPeriod(int period) {
		if(period < 0 || period > 480) {
			throw new IllegalArgumentException("payperiod must be bewteen 0 and 480, in months");
		}
		this.payPeriod = period;
		return payPeriod;
	}

	@Override
	public float setTradeValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float determinePayment(int period, float purcahsePrice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float determinePurcahsePrice(float offer, float totalInterest, float tradeValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float determineInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

}
