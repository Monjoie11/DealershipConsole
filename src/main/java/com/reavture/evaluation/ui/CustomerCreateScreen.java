package com.reavture.evaluation.ui;

import java.util.Scanner;

import com.reavture.evaluation.dao.UserDaoPostGres;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.User.AccessLevel;

public class CustomerCreateScreen {
	
	public User createCustomer(User user) {
		
		Scanner keyboard = new Scanner(System.in);
		
		UserDaoPostGres userPo = new UserDaoPostGres();
		
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

		userPo.updateUsertoCustomer(user.getUserName());
		
		user = userPo.getUserByName(user.getUserName());
	
		
		return user;
	}

}
