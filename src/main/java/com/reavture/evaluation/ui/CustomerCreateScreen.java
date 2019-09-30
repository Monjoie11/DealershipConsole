package com.reavture.evaluation.ui;

import java.util.Scanner;

import com.reavture.evaluation.dao.CustomerDaoSerialization;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.User.AccessLevel;

public class CustomerCreateScreen {
	
	public Customer createCustomer(User user) {
		Customer customer = null;
		
		Scanner keyboard = new Scanner(System.in);
		
		CustomerDaoSerialization serialCustomer = new CustomerDaoSerialization();
		
		System.out.println("We are excited you are joining our happy family");
		System.out.println("Please enter your First name");
		String firstName = keyboard.nextLine();
		System.out.println("Thank you. Please enter your Last name");
		String lastName = keyboard.nextLine();
		System.out.println("Thank you. Please enter your address.");
		String address = keyboard.nextLine();
		System.out.println("Thank you. We promise to call first if  we are ever coming to visit");
		System.out.println("Thank you. Now enter a customerId by typing customerId followed by any two numbers");
		String customerId = keyboard.nextLine();
		System.out.println("Thank you. Creating customer account.");
		
		customer = new Customer(user.getUserName(), user.getPassword(), User.AccessLevel.CUSTOMER, user.getUserId(), 
				firstName, lastName, customerId, address, null, null, 0, 0, 0.0f);
		serialCustomer.createCustomer(customer);
		
		/*
		 * (String userName, String password, AccessLevel accesslevel, String userId,
		 * String firstName, String lastName, String customerId, String address, Car
		 * purchasedCar, Offer offer, int paymentsMade, int paymentsRemaining, float
		 * paymentAmount)
		 */
		
		return customer;
	}

}
