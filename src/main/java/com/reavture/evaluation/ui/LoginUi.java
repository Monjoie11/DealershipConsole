package com.reavture.evaluation.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.reavture.evaluation.controller.Driver;
import com.reavture.evaluation.dao.UserDaoPostGres;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.User.AccessLevel;

public class LoginUi {
	
	
	 Scanner scan;
	 
	 int userId;
	 
	 String userName;
	 
	 
	 
	 String  password;
	 
	 AccessLevel accesslevel;
	 
	 User user;
	 
	 User foundUser;
	 
	 String foundUserName;
	 
	 String foundPassword;
	 
	 Scanner keyboard = new Scanner (System.in);
	 
	 UserDaoPostGres userPo = new UserDaoPostGres();

		public User userLogin() {

			
			
			
			
			
			System.out.println("Please enter your case-sensetive userName");
			userName = keyboard.nextLine();
			
		   List<User> userList = userPo.getAllUsers();
		   
		   for(User fu: userList) {
			   if(userName.equals(fu.getUserName())) {
				   user = fu;
				   System.out.println(user.toString());
				return fu;
			   }
		   }
		   
		   
		   System.out.println("userName not found, creating new User. Enter new userName");
		   
			userName = keyboard.nextLine();
			
			System.out.println("Now enter a password. Write it down somewhere because we don't pay tech support very well.");
			
			password = keyboard.nextLine();
			
			System.out.println("Your access level will be set to User until you apply for a customer account, which I see happening in the near future");
			
			accesslevel = AccessLevel.USER;
			
			user = new User(userName, password, accesslevel, userId);
			
			userPo.createUser(user);
			
			user = userPo.getUserByName(userName);
			
			System.out.println("Thank you " + userName + ". Welcome to Greater Tampa motors: a good deal on a great car.");
			
			return user;
		
		 
		   
		}
		
			 
		public User checkPassword(User user) {
			System.out.println("Hey there " + userName + ". Enter your case-sensitive password");
			
			password = keyboard.nextLine();
			
			if(password.equals(user.getPassword())){
			System.out.println("Thank you " + user.getUserName() + ". Welcome back.");
			return user;
			} else {
				System.out.println("password incorrect. restarting system.");
				this.userLogin();
			}
			
	
		  
			
		  
		    return user;
		    
		   
		  
		} 

}
