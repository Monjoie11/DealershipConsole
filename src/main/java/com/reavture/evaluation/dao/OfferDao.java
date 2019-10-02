package com.reavture.evaluation.dao;

import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.Offer;

public interface OfferDao {
	
	public String createOffer(Offer o);
	
	public Offer readOffer(String offerId);
	

}
