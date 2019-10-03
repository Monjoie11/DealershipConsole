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

import com.reavture.evaluation.dao.CarDaoSerialization;
import com.reavture.evaluation.dao.CustomerDaoSerialization;
import com.reavture.evaluation.dao.OfferDaoSerialization;
import com.reavture.evaluation.dao.PaymentDaoSerialization;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Payment;

public class EmployeeSelectionScreen {
	
	Car car = null;
	
	String make = null;
	
	String model = null;
	
	int year;
	
	double price;
	
	Scanner keyboard = new Scanner(System.in);
	
	Offer offer = null;
	
	String vin = null;
	
	String offerId = null;
	
	List<File> offerList = new ArrayList<File>();
	
	List<File> modifiedOffers = new ArrayList<File>(); 
	
	Payment payment = null;
	
	CustomerDaoSerialization serialCustomer = new CustomerDaoSerialization();
	
	CarDaoSerialization serialCar = new CarDaoSerialization();
	
	PaymentDaoSerialization serialPayment = new PaymentDaoSerialization();
	
	OfferDaoSerialization serialOffer = new OfferDaoSerialization();
	
	public String employeeMenu() {
		
		System.out.println("Enter 1 to add a car to the lot");
		System.out.println("Enter 3 to see all pending offers");
		System.out.println("Enter 5 if you'd like to accept an offer (and reject competing offers)");
		System.out.println("Enter 7 to finalize an accepted offer");
		System.out.println("Enter 9 to exit the program");
		
		 String selection = keyboard.nextLine();
		
		switch(selection) {
		case "1": return "addCar";
		case "3": return "seeOffers";
		case "5": return "acceptOffer";
		case "7": return "finalize";		
		case "9": return "exit";
		default : this.employeeMenu();	
		
		return selection;
		}
	}
	
	
	
	
	
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
		    	System.out.println(offer.toString());
		    } else {
		    	System.out.println("Sorry I can't find the offer you selected");
		    	this.acceptAnOffer();
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
		    	System.out.print(offer.toString());
		    } else {
		    	System.out.println("Sorry I can't find the offer you selected");
		    }
		}
			
			
			modifiedOffers = this.seeOffers();
		

		
		return modifiedOffers;
	}
	
	
	public String addCarToLot() {
		
		System.out.println("So you want to add a car to the lot? What's its vin");
		
		vin = keyboard.nextLine();
		
		System.out.println("What's its make?");
		
		make = keyboard.nextLine();
		
		System.out.println("What's the model?");
		
		model = keyboard.nextLine();
		
		System.out.println("What's ts model year?");
		
		year = Integer.parseInt(keyboard.nextLine());
		
		System.out.println("What is our asking price?");
		
		price = Double.parseDouble(keyboard.nextLine());
		
		car = new Car(make, model, year, price, vin, null);
		
		String filePath = serialCar.createCar(car);
		
		System.out.println(car.toString() + filePath);
		
		return filePath;
		
	}
	
	
	public float finalizeSale() {
		
		List<File> acceptedOffers = new ArrayList<File>();
		
		
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
				if(Offer.Status.ACCEPTED == offer.getStatus()) {
				acceptedOffers.add(fileName);	
				System.out.println(offer.getOfferId() + " " + Double.toString(offer.getAmount()) + " " + offer.getCar().getVin() + " " + offer.getCustomer().getCustomerId());
				}
			} catch (NullPointerException e) {
				System.out.println("looks like we need to fire the data entry guy");
				e.printStackTrace();
			}
		
		}
	
		System.out.println("enter the offerId of the accepted offer you'd like to finalize");
		
		offerId = keyboard.nextLine();
		
		offer = serialOffer.readOffer(offerId);
		
		Customer customer = offer.getCustomer();
		
		System.out.println("enter the term of the loan in months. enter 0 if the customer is paying cash (which would make"
				+ "us very sad because our business model depends on getting interest on depreciating assets.");
		
		double months = Double.parseDouble(keyboard.nextLine());
		
		float payment = (float) (offer.getAmount() * 1.25/months);
		
		System.out.println("thank you. You're monthly payment will be: " +
		Double.toString(payment) + " Remember that we know where you live.");
		
		customer.setPaymentAmount(payment);
		
		customer.setPaymentsRemaining((int) months);
		
		serialCustomer.createCustomer(customer);
		
		System.out.println(customer.toString());
		
		car.setCustomer(customer);
		
		serialCar.createCar(car);
		
		System.out.println(car.toString());
		
		return payment;
	}

	
	
}


