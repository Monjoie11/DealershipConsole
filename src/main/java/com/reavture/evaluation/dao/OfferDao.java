package com.reavture.evaluation.dao;

import java.util.List;

import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.User;

public interface OfferDao {
	
	public void createOffer(Offer offer);
	
	public Offer getOffer(int offerId);
	
	public List<Offer> getAllOffers();
	
	public void acceptOffer(int offerId);

	public void deleteOffer(int offerId);
	

}
