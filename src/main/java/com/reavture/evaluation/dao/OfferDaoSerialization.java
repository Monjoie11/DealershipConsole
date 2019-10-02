package com.reavture.evaluation.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.Offer;

public class OfferDaoSerialization implements OfferDao{

	@Override
	public String createOffer(Offer offer) {

			String fileName;	
			
			if (offer.getOfferId() != null) {
				fileName = "./database/offers/" + offer.getOfferId() + ".dat";
			} else {
				fileName = "./database/newoffers.dat";
			}
			
			try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
				oos.writeObject(offer);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return fileName;
			
		}

	@Override
	public Offer readOffer(String offerId) {
String fileName = "./database/offers/" + offerId + ".dat";
		
		Offer offer = null;
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			offer = (Offer) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return offer;
	}
	
	

}
