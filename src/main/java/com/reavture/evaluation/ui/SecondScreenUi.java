package com.reavture.evaluation.ui;

import java.util.Scanner;

public class SecondScreenUi {
	
	public String pickType() {
		
		String selection;
		Scanner keyboard = new Scanner (System.in);
	
	System.out.println("If you have an employee account, press 1 and hit enter. If you have a customer account press 2 and enter. If you would like to register for a customer account press any other key and hit enter.");
	
	switch(keyboard.nextLine()) {
	
	case "1": selection = "employee";
	               break;
	case "2": selection = "customer";
	              break;
	default: selection = "create";              
	}
	
	return selection;
	}

}
