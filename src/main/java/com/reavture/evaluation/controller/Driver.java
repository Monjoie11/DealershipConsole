package com.reavture.evaluation.controller;

import java.io.File;
import java.util.List;

import com.reavture.evaluation.dao.CarDao;
import com.reavture.evaluation.dao.CarDaoSerialization;
import com.reavture.evaluation.dao.CustomerDao;
import com.reavture.evaluation.dao.CustomerDaoSerialization;
import com.reavture.evaluation.dao.EmployeeDao;
import com.reavture.evaluation.dao.EmployeeDaoSerialization;
import com.reavture.evaluation.dao.OfferDao;
import com.reavture.evaluation.dao.OfferDaoSerialization;
import com.reavture.evaluation.dao.UserDao;
import com.reavture.evaluation.dao.UserDaoSerialization;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.Employee.Department;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Offer.Status;
import com.reavture.evaluation.pojo.User.AccessLevel;
import com.reavture.evaluation.ui.CustomerCreateScreen;
import com.reavture.evaluation.ui.CustomerSelectionScreen;
import com.reavture.evaluation.ui.LoginUi;
import com.reavture.evaluation.ui.SecondScreenUi;

public class Driver {
	
	private static CarDao carDao = new CarDaoSerialization();
	private static UserDao userDao = new UserDaoSerialization();
	private static EmployeeDao employeeDao = new EmployeeDaoSerialization();
	private static CustomerDao customerDao = new CustomerDaoSerialization();
    private static OfferDao    offerDao    = new OfferDaoSerialization();

	public static void main(String[] args) {
 
		
		
		/*
		List<File> carList = null;
		
		String customerSelection = null;
		
		String employeeSelection= null;
		
		LoginUi login = new LoginUi();
		
		User user = login.userLogin();
		
		Customer customer = null;
		
		Employee employee = null;
		
		SecondScreenUi secondScreen = new SecondScreenUi();
		
		CustomerCreateScreen custCreate = new CustomerCreateScreen();
		
		CustomerSelectionScreen css = new CustomerSelectionScreen();
		
		FindObjectInFolder findObject = new FindObjectInFolder();
		
		String selection = secondScreen.pickType();
		
		
		switch(selection) {
		case "create": customer = custCreate.createCustomer(user);
		case "customer": try {
				customer = findObject.customerFromUser(user);
			} catch (Exception e) {
				System.out.println("it does not appear that you have a customer account");
				secondScreen.pickType();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Hello " + customer.getFirstName() + " " + customer.getLastName() + " " +  
		    "what can i do for you?");
		customerSelection = css.customerMenu();
			break;
		case "employee": try {
			System.out.println("it does not appear that you have a customer account");
			secondScreen.pickType();
				employee = findObject.employeeFromUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Hello " + employee.getFirstName() + " " + employee.getLastName() + " " +  
			    "what can i do for you?");
			break;
		default: System.out.println("if you're reading this, something has gone terribly wrong here");
		}
		
		customerSelection = css.customerMenu();
		switch(customerSelection) {
		case "seelot": carList = findObject.getAllCars();
		css.viewCarLot(carList);
		css.customerMenu();
			break;
		case "makeOffer": carList = findObject.getAllCars();
			css.makeAnOffer(carList, customer);
			css.customerMenu();
		case "viewMine": findObject.findMyCars(customer);
		   css.customerMenu();
		default: System.out.println("if you're reading this, something has gone terribly wrong here");
		}
		
		*/
		
		
		/*
		 * Car car = new Car("Make6", "Model6", 6006, 6000.00, "66", null);
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
		 * Customer newCustomer = new Customer("userName5", "password5",
		 * AccessLevel.CUSTOMER, "userId5", "firstName5", "lastName5", "customerId5",
		 * "address5", null, null, 0, 0, 00.0f);
		 * customerDao.createCustomer(newCustomer);
		 */
		 
		/*
		 * Car car = new Car("Make", "Mode", 2003, 3000.00, "33", null);
		 * carDao.createCar(car);
		 */
		 
		 
		 
		/*
		 * Offer offer = new Offer(newCustomer, Offer.Status.PENDING, 999.99, car,
		 * "offerId3"); offerDao.createOffer(offer);
		 */
		
		
		try {
		  Car car = carDao.readCar("44");
		  System.out.println(car.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
		 
	}
}
