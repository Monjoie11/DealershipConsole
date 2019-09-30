package com.reavture.evaluation.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.reavture.evaluation.dao.UserDaoSerialization;
import com.reavture.evaluation.pojo.User;

public class LoginUi {
	
	 Scanner scan;
	 
	 String userId;
	 
	 UserDaoSerialization loginSerial = new UserDaoSerialization();
	 
	 User user;


	 //fileName = "./database/users/" + user.getUserId() + ".dat";

		public void login() {
			Scanner keyboard = new Scanner (System.in);
			String fileName;
			
			
			System.out.println("Please enter your case-sensetive userId");
			userId = keyboard.nextLine();
			
			
			user = loginSerial.readUser(userId);
	
		    
		/*
		 * try {
		 * 
		 * scan = new Scanner (new File("./database/users/" + userId + ".dat")); } catch
		 * (FileNotFoundException e) { userId = "newUsers"; try { scan = new Scanner
		 * (new File("./database/users/" + userId + ".dat")); } catch
		 * (FileNotFoundException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } }
		 */
			
		    
		    String user = scan.nextLine();
		    String pass = scan.nextLine(); // looks at selected file in scan

		    String inpUser = keyboard.nextLine();
		    String inpPass = keyboard.nextLine(); // gets input from user

		    if (inpUser.equals(user) && inpPass.equals(pass)) {
		        System.out.print("your login message");
		    } else {
		        System.out.print("your error message");
		    }
		}

}
