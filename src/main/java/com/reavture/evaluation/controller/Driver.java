package com.reavture.evaluation.controller;

import com.reavture.evaluation.dao.CarDao;
import com.reavture.evaluation.dao.CarDaoSerialization;
import com.reavture.evaluation.dao.CustomerDao;
import com.reavture.evaluation.dao.CustomerDaoSerialization;
import com.reavture.evaluation.dao.EmployeeDao;
import com.reavture.evaluation.dao.EmployeeDaoSerialization;
import com.reavture.evaluation.dao.UserDao;
import com.reavture.evaluation.dao.UserDaoSerialization;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.Employee.Department;
import com.reavture.evaluation.pojo.Offer.Status;
import com.reavture.evaluation.pojo.User.AccessLevel;
import com.reavture.evaluation.ui.CustomerCreateScreen;
import com.reavture.evaluation.ui.LoginUi;
import com.reavture.evaluation.ui.SecondScreenUi;

public class Driver {
	
	private static CarDao carDao = new CarDaoSerialization();
	private static UserDao userDao = new UserDaoSerialization();
	private static EmployeeDao employeeDao = new EmployeeDaoSerialization();
	private static CustomerDao customerDao = new CustomerDaoSerialization();

	public static void main(String[] args) {
 
		
		LoginUi login = new LoginUi();
		
		User user = login.userLogin();
		
		Customer customer = null;
		
		Employee employee = null;
		
		SecondScreenUi secondScreen = new SecondScreenUi();
		
		CustomerCreateScreen custCreate = new CustomerCreateScreen();
		
		FindObjectInFolder findObject = new FindObjectInFolder();
		
		String selection = secondScreen.pickType();
		
		switch(selection) {
		case "create": customer = custCreate.createCustomer(user);
		System.out.println("Hello " + customer.getFirstName() + " " + customer.getLastName() + " " +  
			    "what can i do for you?");
			break;
		case "customer": customer = findObject.customerFromUser(user);
		System.out.println("Hello " + customer.getFirstName() + " " + customer.getLastName() + " " +  
		    "what can i do for you?");
			break;
		case "emloyee": employee = findObject.employeeFromUser(user);
		System.out.println("Hello " + employee.getFirstName() + " " + employee.getLastName() + " " +  
			    "what can i do for you?");
			break;
		default: System.out.println("if you're reading this, something has gone terribly wrong here");
		}
		
		
		
		/*
		 * Car car = new Car("Toyota", "Tacoma", 2005, 9000.00, "3344334455", null);
		 * carDao.createCar(car);
		 */
		  
		
		/*
		 * User newUser = new User("userName9", "password9", User.AccessLevel.USER,
		 * "userId9"); userDao.createUser(newUser);
		 */
		 
		
		/*
		 * Employee newEmployee = new Employee("userName3", "password3",
		 * AccessLevel.EMPLOYEE, "userId3", "firstName3", "lastName3", "employeeId3",
		 * Department.SALES, 33.33f, "333333333");
		 * employeeDao.createEmployee(newEmployee);
		 */
	
		
		
		/*
		 * Customer newCustomer = new Customer("userName4", "password4",
		 * AccessLevel.CUSTOMER, "userId4", "firstName4", "lastName4", "customerId4",
		 * "address4", null, null, 0, 0, 00.0f);
		 * customerDao.createCustomer(newCustomer);
		 */
		 
		
	}
}
