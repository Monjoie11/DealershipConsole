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

import com.reavture.evaluation.dao.CarDaoPostgres;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Payment;
import com.reavture.evaluation.pojo.User;

public class CustomerSelectionScreen {
	Offer offer = null;
	Car car = null;
	String selection = null;
	Scanner keyborad = new Scanner(System.in);
	String vin = null;
	Double amount = 0.0;
	String offerId = null;
	CarDaoPostgres carPo = new CarDaoPostgres();
	
	public String customerMenu() {

		
		
		System.out.println("Enter 1 to view the lot");
		System.out.println("Enter 3 to make an offer");
		System.out.println("Enter 5 to see all the cars you own");
		System.out.println("Enter 7 to see all your payents");
		System.out.println("Enter 9 to exit the program");
		
		String choice = keyborad.nextLine();
		switch(choice){
		case "1": return "viewLot";
		case "3": return "makeOffer";
		case "5": return "viewMine";
		case "7": return "viewPayments";
		case "9": return "exit";
			default: this.customerMenu();
		}
		
		
		return selection;
	}
	

	
	
	public Offer makeAnOffer(User user, List<Car> carList) {
		
		for(Car c: carList) {
			System.out.println(c.getMake() + " " + c.getModel() + " " + c.getYear() + " " + c.getPrice() + " " + c.getVin());
		}

		
		
		System.out.println("enter the vin of the car you're making an offer on");
		vin = keyborad.nextLine();
		
		
		try {
			car = carPo.getCarByVin(vin);
		} catch (Exception e) {
			System.out.println("we didn't find the car");
			this.makeAnOffer(user, carList);
			e.printStackTrace();
		}
		
		System.out.println("Enter the amount of your offer in dollars");
		
		vin = keyborad.nextLine();
		
		amount = Double.parseDouble(vin);
		
		offer = new Offer(user.getUserName(), Offer.Status.PENDING, amount, vin, 0);
		
		System.out.println("Thank you! We will contact you soon!");
		
		
		return offer;
	}
	

	


}
