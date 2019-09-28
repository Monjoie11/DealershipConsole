package com.revature.evaluation.utility;

public interface Sales {
	
	int setPayPeriod(int period);
	//sets the pay period
	
	float setTradeValue();
	//sets trade value
	
	float determinePayment(int period, float purcahsePrice);
	//pay period set by sales team, purchase price determined by offer plus/minus trade-in and interest
	
	float determinePurcahsePrice(float offer, float totalInterest, float tradeValue);
	//determined by sales team
	
	float determineInterest();
	//determines interest

}
