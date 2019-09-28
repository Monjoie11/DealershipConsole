package com.revature.evaluation.utility;

public interface Sales {
	
	int setPayPeriod(int period);
	//sets the pay period
	
	double setTradeValue(double trade);
	//sets trade value
	
	double determinePayment(int period, double purcahsePrice);
	//pay period set by sales team, purchase price determined by offer plus/minus trade-in and interest
	
	double determinePurcahsePrice(double offer, double totalInterest, double tradeValue);
	//determined by sales team
	
	double determineInterest(double rate);
	//determines interest

}
