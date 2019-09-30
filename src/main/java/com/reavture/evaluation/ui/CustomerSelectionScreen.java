package com.reavture.evaluation.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

import com.reavture.evaluation.dao.CarDaoSerialization;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Offer;

public class CustomerSelectionScreen {
	Offer offer = null;
	Car car = null;
	String selection = null;
	Scanner keyborad = new Scanner(System.in);
	CarDaoSerialization serialCar = new CarDaoSerialization();
	String vin = null;
	
	public String customerMenu() {

		
		
		System.out.println("we only have one choice at this time. Press any key then hit enter to view the lot");
		
		String choice = keyborad.nextLine();
		switch(choice){
			default: selection = "lot";
		}
		
		
		return selection;
	}
	
	public Offer makeAnOffer(List<File> carList) {
		
		for(File fileName: carList) {
			
			try (FileInputStream fis = new FileInputStream(fileName);
					ObjectInputStream ois = new ObjectInputStream(fis);) {
				car = (Car) ois.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try {
				System.out.println(car.getMake() + " " + car.getModel() + " " + car.getYear() + " " + car.getPrice() + " " + car.getVin());
			} catch (NullPointerException e) {
				System.out.println("looks like we need to fire the data entr guy");
				e.printStackTrace();
			}
			
		}
		
		
		
		System.out.println("enter the vin (final two digits) of the car you're making an offer on");
		vin = keyborad.nextLine();
		try {
			car = serialCar.readCar(vin);
		} catch (Exception e) {
			System.out.println("we didn't find the car");
			this.makeAnOffer(carList);
			e.printStackTrace();
		}
		
		
		
		return offer;
	}
	
	

}
