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

import com.reavture.evaluation.dao.OfferDaoPostGres;
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
	
	int offerId = 0;
	
	List<Offer> offerList = new ArrayList<Offer>();
	
	List<File> modifiedOffers = new ArrayList<File>(); 
	
	Payment payment = null;
	
	OfferDaoPostGres offerPo = new OfferDaoPostGres();

	

	
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
	
	
	
	
	
	public int acceptAnOffer(){

		
		System.out.println("enter the offerId of the offer you'd like to accept");
		
		offerId = Integer.parseInt(keyboard.nextLine());
		
		
		return offerId;
	}
	
	public int finalizeAnOffer(){

		
		System.out.println("enter the offerId of the offer you'd like to finalize.");
		
		offerId = Integer.parseInt(keyboard.nextLine());
		
	
		
		return offerId;
	}
	
	
	public Car addCarToLot() {
		
		System.out.println("So you want to add a car to the lot? What's its vin");
		
		vin = keyboard.nextLine();
		
		System.out.println("What's its make?");
		
		make = keyboard.nextLine();
		
		System.out.println("Which model?");
		
		model = keyboard.nextLine();
		
		System.out.println("model year?");
		
		year = Integer.parseInt(keyboard.nextLine());
		
		System.out.println("What is our asking price?");
		
		price = Double.parseDouble(keyboard.nextLine());
		
		car = new Car(vin, make, model, year, price, "lot");
		
		return car;
		
	}
	
	
	public float finalizeSale(Offer offer) {
		
		
		System.out.println("enter the term of the loan in months. enter 0 if the customer is paying cash (which would make"
				+ "us very sad because our business model depends on getting interest on depreciating assets.");
		
		double months = Double.parseDouble(keyboard.nextLine());
		
		float payment = (float) (offer.getAmount() * 1.25/months);
		
		System.out.println("thank you. You're monthly payment will be: " +
		Double.toString(payment) + " Remember that we know where you live.");
		
		
		return payment;
	}

	
	
}


