package com.revature.evaluation.utility;

public interface Financial {
	
	

	
	float aggregateIncome(float...outStanding);
	//total outstanding payments
	
	float aggregateNonLiquid(float...inventory);
	//total cars on lot
	
	float totalAsset(float nonLiquid, float Income);
	//total value of Dealership's assets
	
	float totalReceipt();
	//total all payments made
	
	
	
	
	
	
	
	

}
