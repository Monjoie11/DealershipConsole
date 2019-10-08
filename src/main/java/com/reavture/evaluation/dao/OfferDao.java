package com.reavture.evaluation.dao;

import java.util.List;

import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.User;

public interface OfferDao {
	
	public void createOffer(Offer offer);
	
	public Offer getOffer(int offerId);
	
	public List<Offer> getAllOffersPending();
	
	public void acceptOffer(int offerId);

	public void deleteOffer(int offerId);
	

}
