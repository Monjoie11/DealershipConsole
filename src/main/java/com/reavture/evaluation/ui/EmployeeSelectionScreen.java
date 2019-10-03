package com.reavture.evaluation.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.reavture.evaluation.dao.OfferDaoSerialization;
import com.reavture.evaluation.dao.PaymentDaoSerialization;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Payment;

public class EmployeeSelectionScreen {
	
	OfferDaoSerialization serialOffer = new OfferDaoSerialization();
	
	public List<File> seeOffers(){
		
		Offer offer = null;
		
		List<File> offerList = new ArrayList<File>();
		
		List<File> pendingOffers = new ArrayList<File>(); 
		
		Payment payment = null;
		
		PaymentDaoSerialization serialPayment = new PaymentDaoSerialization();
		
		try {
			offerList = Files.walk(Paths.get("./database/offers"))
			.filter(Files::isRegularFile)
			.map(Path::toFile)
			.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Our path is wrong. We have deviated from the path.");
			e.printStackTrace();
		}
		
		
		for(File fileName: offerList) {
			
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
		
			try {
				if(Offer.Status.PENDING == offer.getStatus()) {
				pendingOffers.add(fileName);	
				System.out.println(offer.getOfferId() + " " + Double.toString(offer.getAmount()) + " " + offer.getCar().getVin() + " " + offer.getCustomer().getCustomerId());
				}
			} catch (NullPointerException e) {
				System.out.println("looks like we need to fire the data entry guy");
				e.printStackTrace();
			}
			
		}
		
		return pendingOffers;
	}
	
	
	public List<File> acceptAnOffer(){
		
		Scanner keyboard = new Scanner(System.in);
		
		Offer offer = null;
		
		String vin = null;
		
		String offerId = null;
		
		List<File> offerList = new ArrayList<File>();
		
		List<File> modifiedOffers = new ArrayList<File>(); 
		
		Payment payment = null;
		
		PaymentDaoSerialization serialPayment = new PaymentDaoSerialization();
		
		offerList = this.seeOffers();
		
		System.out.println("enter the offerId of the offer you'd like to accept. enter help to bail out");
		
		offerId = keyboard.nextLine();
		
		if("help".equals(offerId)) {
		//code to go back
		}
			
		
		for(File fileName: offerList) {
			
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

		    if(offerId.equals(offer.getOfferId())) {
		    	offer.setStatus(Offer.Status.ACCEPTED);
		    	vin = offer.getCar().getVin();
		    	serialOffer.createOffer(offer);
		    } else {
		    	System.out.println("Sorry I can't find the offer you selected");
		    }
		}
		
		for(File fileName: offerList) {
			
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

		    if(offer.getStatus().equals(Offer.Status.PENDING) & vin.equals(offer.getCar().getVin())) {
		    	offer.setStatus(Offer.Status.REJECTED);
		    	serialOffer.createOffer(offer);
		    } else {
		    	System.out.println("Sorry I can't find the offer you selected");
		    }
		}
			
			
			modifiedOffers = this.seeOffers();
		

		
		return modifiedOffers;
	}

}
