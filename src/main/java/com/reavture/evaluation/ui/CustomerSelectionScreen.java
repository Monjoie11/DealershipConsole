package com.reavture.evaluation.ui;

import java.util.Scanner;

public class CustomerSelectionScreen {
	
	public String customerMenu() {
		String selection = null;
		Scanner keyborad = new Scanner(System.in);
		
		
		System.out.println("we only have one choice at this time. Press any key then hit enter to view the lot");
		
		String choice = keyborad.nextLine();
		switch(choice){
			default: selection = "lot";
		}
		
		
		return selection;
	}
	
	

}
