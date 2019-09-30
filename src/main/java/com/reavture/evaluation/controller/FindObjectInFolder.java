package com.reavture.evaluation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.reavture.evaluation.dao.CarDaoSerialization;
import com.reavture.evaluation.dao.CustomerDaoSerialization;
import com.reavture.evaluation.dao.EmployeeDaoSerialization;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.User;

public class FindObjectInFolder {
	
	public Customer customerFromUser(User user) {
		Customer customer = null;
		
		CustomerDaoSerialization customerSerial = new CustomerDaoSerialization();
		
		String userId = user.getUserId();
		String matchedId = null;
		
		List<File> customerList = new ArrayList<File>(); 
		
	
			try {
				customerList = Files.walk(Paths.get("./database/customers"))
				.filter(Files::isRegularFile)
				.map(Path::toFile)
				.collect(Collectors.toList());
			} catch (IOException e) {
				System.out.println("Our path is wrong. We have deviated from the path.");
				e.printStackTrace();
			}
		
			for(File fileName: customerList) {
				
				try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
					customer = (Customer) ois.readObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(customer.getUserId().equals(userId)) {
					break;
				} else {
					System.out.println("checking next file");
					customer = null;
				}
				
				
			}
			
			if(customer.equals(null)) {
				System.out.println("it does not appear you have a customer account");
				//call customer creation screen. omitted here for testing
			}
		
		return customer;
	}
	
	
	
	
	public Employee employeeFromUser(User user) {
		
		Employee employee = null;
		
		EmployeeDaoSerialization employeeSerial = new EmployeeDaoSerialization();
		
		String userId = user.getUserId();
		String matchedId = null;
		
		List<File> employeeList = new ArrayList<File>(); 
		
	
			try {
				employeeList = Files.walk(Paths.get("./database/employees"))
				.filter(Files::isRegularFile)
				.map(Path::toFile)
				.collect(Collectors.toList());
			} catch (IOException e) {
				System.out.println("Our path is wrong. We have deviated from the path.");
				e.printStackTrace();
			}
		
			
			for(File fileName: employeeList) {
				
				try (FileInputStream fis = new FileInputStream(fileName);
						ObjectInputStream ois = new ObjectInputStream(fis);) {
					employee = (Employee) ois.readObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(employee.getUserId().equals(userId)) {
					break;
				} else {
					System.out.println("checking next file");
					employee = null;
				}
				
				
			}
			
			if(employee.equals(null)) {
				System.out.println("it does not appear you have a customer account");
				//call customer creation screen. omitted here for testing
			}
		
		return employee;
	}
	
	
	
	public List<File> getAllCars(){
		
		
		
		List<File> carList = new ArrayList<File>(); 
		
		Car car = null;
		
		CarDaoSerialization serialCar = new CarDaoSerialization();
		
		try {
			carList = Files.walk(Paths.get("./database/cars"))
			.filter(Files::isRegularFile)
			.map(Path::toFile)
			.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Our path is wrong. We have deviated from the path.");
			e.printStackTrace();
		}
		
		
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
		
		
		
		
		return carList;
		
	}
	
	

}


