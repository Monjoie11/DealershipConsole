package com.revature.evaluation.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginUi {
	
	 Scanner scan;
	

		public void login() {
			
		   
		    
			try {
				scan = new Scanner (new File("the\\dir\\myFile.extension"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    Scanner keyboard = new Scanner (System.in);
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
