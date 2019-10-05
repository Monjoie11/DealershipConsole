package com.reavture.evaluation.controller;

import java.io.File;
import java.util.List;
import java.util.Scanner;

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
import com.reavture.evaluation.ui.EmployeeSelectionScreen;
import com.reavture.evaluation.ui.LoginUi;
import com.reavture.evaluation.ui.SecondScreenUi;
import static com.revature.evaluation.utility.LoggerUtil.*;

public class Driver {
	
	

	private static CarDao carDao = new CarDaoSerialization();
	private static UserDao userDao = new UserDaoSerialization();
	private static EmployeeDao employeeDao = new EmployeeDaoSerialization();
	private static CustomerDao customerDao = new CustomerDaoSerialization();
	private static OfferDao offerDao = new OfferDaoSerialization();

	public static void main(String[] args) {
		
		trace("start main method");
	
		Scanner keyboard = new Scanner(System.in);

		boolean isCustomer = false;

		boolean isEmployee = false;
		
		boolean notLogin = true;

		List<File> carList = null;

		String customerSelection = null;

		String employeeSelection = null;

		LoginUi login = new LoginUi();

		Customer customer = null;

		Employee employee = null;

		EmployeeSelectionScreen ess = new EmployeeSelectionScreen();

		SecondScreenUi secondScreen = new SecondScreenUi();

		CustomerCreateScreen custCreate = new CustomerCreateScreen();

		CustomerSelectionScreen css = new CustomerSelectionScreen();

		FindObjectInFolder findObject = new FindObjectInFolder();
		
		
       while(notLogin) {
    	   
       
		User user = login.userLogin();

		String selection = secondScreen.pickType();

		switch (selection) {
		case "create":
			customer = custCreate.createCustomer(user);
		case "customer":
			try {
				customer = findObject.customerFromUser(user);
			} catch (Exception e) {
				System.out.println("it does not appear that you have a customer account");
				secondScreen.pickType();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(
					"Hello " + customer.getFirstName() + " " + customer.getLastName() + " " + "what can i do for you?");
			isCustomer = true;
			notLogin = false;
			break;
			
		case "employee":
			try {
		
				employee = findObject.employeeFromUser(user);
			} catch (Exception e) {
				System.out.println("It does not appear that you have an employee account.");
				System.out.println("Employee accounts must be created by HR or Managment");
				
				e.printStackTrace();
			}
			System.out.println(
					"Hello " + employee.getFirstName() + " " + employee.getLastName() + " " + "what can i do for you?");
			isEmployee = true;
			notLogin = false;
			break;
		default:
			System.out.println("if you're reading this, something has gone terribly wrong here");
		}
       }

		while (isCustomer) {

			customerSelection = css.customerMenu();
			switch (customerSelection) {
			case "viewLot":
				carList = findObject.getAllCars();
				css.viewCarLot(carList);
				break;
			case "makeOffer":
				carList = findObject.getAllCars();
				css.makeAnOffer(carList, customer);
				break;
			case "viewMine":
				css.findMyCars(customer);
				break;
			case "viewPayments":
				css.findMyPayments(customer);
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("if you're reading this, something has gone terribly wrong here");
			}

		}

		while (isEmployee) {

			employeeSelection = ess.employeeMenu();

			switch (employeeSelection) {
			case "addCar": ess.addCarToLot();
				break;
			case "seeOffers": ess.seeOffers();
				break;
			case "acceptOffer": ess.acceptAnOffer();
				break;
			case "finalize": ess.finalizeSale();
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("if you're reading this, something has gone terribly wrong here");
			}
		}

		
		
		
		/*
		Customer customer = customerDao.readCustomer("customerId7");
		
		  Car car = new Car("Make10", "Model10", 2010, 10000.00, "1010", customer);
		  carDao.createCar(car);
		 
		 */

		
		/*
		 * User newUser = new User("userName12", "password12", User.AccessLevel.USER,
		 * "userId12"); userDao.createUser(newUser);
		 */
		 

		
		/*
		 * Employee newEmployee = new Employee("userName3", "password3",
		 * AccessLevel.EMPLOYEE, "userId3", "firstName3", "lastName3", "employeeId3",
		 * Department.SALES, 33.33f, "33"); employeeDao.createEmployee(newEmployee);
		 */
		 

		
		/*
		 * Customer newCustomer = new Customer("userName7", "password7",
		 * AccessLevel.CUSTOMER, "userId6", "firstName7", "lastName7", "customerId7",
		 * "address7", null, null, 0, 0, 00.0f);
		 * customerDao.createCustomer(newCustomer);
		 */
		 

		/*
		 * Car car = new Car("Make", "Mode", 2003, 3000.00, "33", null);
		 * carDao.createCar(car);
		 */
		
		/*

		Customer customer = customerDao.readCustomer("customerId7");
		
		Car car = carDao.readCar("88");
		
		  Offer offer = new Offer(customer, Offer.Status.PENDING, 5000.00, car, "offerId788"); 
		  offerDao.createOffer(offer);
		  
		  */
		 

	
	}
}
