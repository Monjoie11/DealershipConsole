package com.reavture.evaluation.controller;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.reavture.evaluation.dao.CarDao;
import com.reavture.evaluation.dao.CarDaoPostgres;
import com.reavture.evaluation.dao.CustomerDao;
import com.reavture.evaluation.dao.CustomerDaoSerialization;
import com.reavture.evaluation.dao.EmployeeDao;
import com.reavture.evaluation.dao.EmployeeDaoSerialization;
import com.reavture.evaluation.dao.OfferDao;
import com.reavture.evaluation.dao.OfferDaoPostGres;
import com.reavture.evaluation.dao.UserDao;
import com.reavture.evaluation.dao.UserDaoPostGres;
import com.reavture.evaluation.jdbc.ConnectionFactory;
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

	private static EmployeeDao employeeDao = new EmployeeDaoSerialization();
	private static CustomerDao customerDao = new CustomerDaoSerialization();

	private static Connection conn = ConnectionFactory.getConnection();

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public static void main(String[] args) {
		
		 trace("start main method");

		UserDaoPostGres userPo = new UserDaoPostGres();

		OfferDaoPostGres offerPo = new OfferDaoPostGres();

		User user = new User("lot", "password", User.AccessLevel.USER, 0);

		Car car = new Car("make6", "model6", "vin6", 2006, 2000.00, "userId5");

		Offer offer = new Offer(user.getUserName(), Offer.Status.PENDING, 35000.89, car.getVin(), 0);
		
		offerPo.rejectCompetingOffers(offer.getCarVin());

	//	offerPo.acceptOffer(45);
		
		
		}
		
	

	
	
	
	// System.out.println(offer.toString());

	/*
	 * userPo.createUser(user);
	 * 
	 * user = userPo.getUserByName("lot");
	 * 
	 * 
	 * userPo.updateUsertoCustomer("lot");
	 * 
	 * 
	 * 	    
		
		List<Offer> offerList = offerPo.getAllOffersPending();
		
		for(Offer o: offerList) {
			System.out.println(o.toString());
	 * 
	 * 
	
	 */

	/*
	  List<Car> carList = new ArrayList<Car>();
	  
	  
	  
	  CarDaoPostgres carPo = new CarDaoPostgres();
	  
	  //carPo.createCar(car);
	  
	  //car = carPo.getCarByVin("vin2");
	  
	  carList = carPo.getAllCarsByUser("userId5");
	  
	  for(Car c: carList) {
	  
	  System.out.println(c.toString()); }*/
	

	/*
	 * 
	 * Scanner keyboard = new Scanner(System.in);
	 * 
	 * boolean isCustomer = false;
	 * 
	 * boolean isEmployee = false;
	 * 
	 * boolean notLogin = true;
	 * 
	 * List<File> carList = null;
	 * 
	 * String customerSelection = null;
	 * 
	 * String employeeSelection = null;
	 * 
	 * LoginUi login = new LoginUi();
	 * 
	 * Customer customer = null;
	 * 
	 * Employee employee = null;
	 * 
	 * EmployeeSelectionScreen ess = new EmployeeSelectionScreen();
	 * 
	 * SecondScreenUi secondScreen = new SecondScreenUi();
	 * 
	 * CustomerCreateScreen custCreate = new CustomerCreateScreen();
	 * 
	 * CustomerSelectionScreen css = new CustomerSelectionScreen();
	 * 
	 * FindObjectInFolder findObject = new FindObjectInFolder();
	 * 
	 * 
	 * while(notLogin) {
	 * 
	 * 
	 * UUser user = login.userLogin();
	 * 
	 * String selection = secondScreen.pickType();
	 * 
	 * switch (selection) { case "create": customer =
	 * custCreate.createCustomer(user); case "customer": try { customer =
	 * findObject.customerFromUser(user); } catch (Exception e) {
	 * System.out.println("it does not appear that you have a customer account");
	 * secondScreen.pickType(); // TODO Auto-generated catch block
	 * e.printStackTrace(); } System.out.println( "Hello " + customer.getFirstName()
	 * + " " + customer.getLastName() + " " + "what can i do for you?"); isCustomer
	 * = true; notLogin = false; break;
	 * 
	 * case "employee": try {
	 * 
	 * employee = findObject.employeeFromUser(user); } catch (Exception e) {
	 * System.out.println("It does not appear that you have an employee account.");
	 * System.out.println("Employee accounts must be created by HR or Managment");
	 * 
	 * e.printStackTrace(); } System.out.println( "Hello " + employee.getFirstName()
	 * + " " + employee.getLastName() + " " + "what can i do for you?"); isEmployee
	 * = true; notLogin = false; break; default: System.out.
	 * println("if you're reading this, something has gone terribly wrong here"); }
	 * }
	 * 
	 * while (isCustomer) {
	 * 
	 * customerSelection = css.customerMenu(); switch (customerSelection) { case
	 * "viewLot": carList = findObject.getAllCars(); css.viewCarLot(carList); break;
	 * case "makeOffer": carList = findObject.getAllCars(); css.makeAnOffer(carList,
	 * customer); break; case "viewMine": css.findMyCars(customer); break; case
	 * "viewPayments": css.findMyPayments(customer); break; case "exit":
	 * System.exit(0); break; default: System.out.
	 * println("if you're reading this, something has gone terribly wrong here"); }
	 * 
	 * }
	 * 
	 * while (isEmployee) {
	 * 
	 * employeeSelection = ess.employeeMenu();
	 * 
	 * switch (employeeSelection) { case "addCar": ess.addCarToLot(); break; case
	 * "seeOffers": ess.seeOffers(); break; case "acceptOffer": ess.acceptAnOffer();
	 * break; case "finalize": ess.finalizeSale(); break; case "exit":
	 * System.exit(0); break; default: System.out.
	 * println("if you're reading this, something has gone terribly wrong here"); }
	 * }
	 * 
	 */

}
