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
		
		SecondScreenUi secondScreen = new SecondScreenUi();
		
		CustomerCreateScreen custCreate = new CustomerCreateScreen();
		
		String selection = secondScreen.pickType();
		
		switch(selection) {
		case "create": custCreate.createCustomer(user);
			break;
		case "customer": //customer menu screen
			break;
		case "emloyee": //employee menu screen
			break;
		default: //something has gone terribly wrong here
		}
		
		
		/*
		 * Car car = new Car("Toyota", "Tacoma", 2005, 9000.00, "3344334455", null);
		 * carDao.createCar(car);
		 */
		  
		
		/*
		 * User newUser = new User("userName9", "password9", User.AccessLevel.USER,
		 * "userId9"); userDao.createUser(newUser);
		 */
		 
		
	/*	Employee newEmployee = new Employee("userName1", "password1", AccessLevel.EMPLOYEE, "userId1", "firstName1",
				"lastName1", "employeeId1", Department.SALES, (float) 11.11, "111111111");
		 employeeDao.createEmployee(newEmployee);
	*/
		
		/*
		 * Customer newCustomer = new Customer("userName6", "password6",
		 * AccessLevel.CUSTOMER, "userId6", "firstName6", "lastName6", "customerId6",
		 * "address6", car, null, 1, 8, 1000.00f);
		 * customerDao.createCustomer(newCustomer);
		 */
		
	}
}
