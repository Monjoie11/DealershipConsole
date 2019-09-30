package com.reavture.evaluation.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.reavture.evaluation.controller.Driver;
import com.reavture.evaluation.dao.UserDaoSerialization;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.User.AccessLevel;

public class LoginUi {
	
	
	 Scanner scan;
	 
	 String userId;
	 
	 String userName;
	 
	 String  password;
	 
	 AccessLevel accesslevel;
	 
	 UserDaoSerialization loginSerial = new UserDaoSerialization();
	 
	 User user;

		public User userLogin() {

			
			Scanner keyboard = new Scanner (System.in);
			String fileName;
			
			
			System.out.println("Please enter your case-sensetive userId");
			userId = keyboard.nextLine();
			
			fileName = "./database/users/" + userId + ".dat";
		 
		  
		  try {
			scan = new Scanner (new File(fileName));
			user = loginSerial.readUser(userId);
			System.out.println("Hey there " + userId + ". Enter your case-sensitive password");
			password = keyboard.nextLine();
			if(password.equals(user.getPassword())){
			System.out.println("Thank you " + userId + ". Welcome back.");
			return user;
			} else {
				System.out.println("password incorrect. restarting system.");
				this.userLogin();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("userId not found, creating new User. Enter new userName");
			userName = keyboard.nextLine();
			System.out.println("Now enter a userId. This will be auto-generated when Jeff gets some skill");
			userId = keyboard.nextLine();
			System.out.println("Now enter a password. Write it down somewhere because we don't pay tech support very well.");
			password = keyboard.nextLine();
			System.out.println("Your access level will be set to User until you apply for a customer account, which I see happening in the near future");
			accesslevel = AccessLevel.USER;
			user = new User(userName, password, accesslevel, userId);
			loginSerial.createUser(user);
			System.out.println("Thank you " + userId + ". Welcome to Greater Tampa motors: a good deal on a great car.");
			return user;
		} 
		  
			
		  
		    return null;
		    
		   
		  
		} 

}
