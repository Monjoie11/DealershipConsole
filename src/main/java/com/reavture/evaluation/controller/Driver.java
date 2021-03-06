package com.reavture.evaluation.controller;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.reavture.evaluation.dao.CarDao;
import com.reavture.evaluation.dao.CarDaoPostgres;
import com.reavture.evaluation.dao.OfferDao;
import com.reavture.evaluation.dao.OfferDaoPostGres;
import com.reavture.evaluation.dao.PaymentDaoPostgres;
import com.reavture.evaluation.dao.UserDao;
import com.reavture.evaluation.dao.UserDaoPostGres;
import com.reavture.evaluation.jdbc.ConnectionFactory;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Offer.Status;
import com.reavture.evaluation.pojo.Payment;
import com.reavture.evaluation.pojo.User.AccessLevel;
import com.reavture.evaluation.ui.CustomerCreateScreen;
import com.reavture.evaluation.ui.CustomerSelectionScreen;
import com.reavture.evaluation.ui.EmployeeSelectionScreen;
import com.reavture.evaluation.ui.LoginUi;
import com.reavture.evaluation.ui.SecondScreenUi;
import static com.revature.evaluation.utility.LoggerUtil.*;

public class Driver {

	private static Connection conn = ConnectionFactory.getConnection();

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public static void main(String[] args) {

		trace("start main method");

		UserDaoPostGres userPo = new UserDaoPostGres();

		OfferDaoPostGres offerPo = new OfferDaoPostGres();

		CarDaoPostgres carPo = new CarDaoPostgres();

		// offerPo.rejectCompetingOffers(offer.getCarVin());

		// offerPo.acceptOffer(45);

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
		 * 
		 * List<Offer> offerList = offerPo.getAllOffersPending();
		 * 
		 * for(Offer o: offerList) { System.out.println(o.toString());
		 * 
		 * User user = new User("lot", "password", User.AccessLevel.USER, 0);
		 * 
		 * Car car = new Car("make6", "model6", "vin6", 2006, 2000.00, "userId5");
		 * 
		 * Offer offer = new Offer(user.getUserName(), Offer.Status.PENDING, 35000.89,
		 * car.getVin(), 0);
		 * 
		 * 
		 */

		/*
		 * List<Car> carList = new ArrayList<Car>();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * //carPo.createCar(car);
		 * 
		 * //car = carPo.getCarByVin("vin2");
		 * 
		 * carList = carPo.getAllCarsByUser("userId5");
		 * 
		 * for(Car c: carList) {
		 * 
		 * System.out.println(c.toString()); }
		 */

		Scanner keyboard = new Scanner(System.in);

		boolean isCustomer = false;

		boolean isEmployee = false;

		boolean notLogin = true;
		
		List<Payment> paymentList = null;

		List<Car> carList = null;
		
		PaymentDaoPostgres paymentPo = new PaymentDaoPostgres();

		String customerSelection = null;

		String employeeSelection = null;
		
		String vin = null;
		
		String userName= null;

		LoginUi login = new LoginUi();
		
		User user = null;
		
		int offerId = 0;
		
		Offer offer = null;
		
		Car car = null;

		List<Offer> offerList = null;

		EmployeeSelectionScreen ess = new EmployeeSelectionScreen();

		SecondScreenUi secondScreen = new SecondScreenUi();

		CustomerCreateScreen custCreate = new CustomerCreateScreen();

		CustomerSelectionScreen css = new CustomerSelectionScreen();



		while (notLogin) {

		    user = login.userLogin();
		    
		    login.checkPassword(user);

			String selection = secondScreen.pickType();

			switch (selection) {
			case "create":
				user = custCreate.createCustomer(user);
			case "customer":
				if (user.getAccesslevel().equals(User.AccessLevel.CUSTOMER)) {

					System.out.println("Hello " + user.getUserName() + " " + "what can i do for you?");

					isCustomer = true;
					notLogin = false;
					break;

				} else {

					System.out.println("it does not appear that you have a customer account");
					user = custCreate.createCustomer(user);
					
					trace("customer account else statment");
					isCustomer = true;
					notLogin = false;
					break;
					
				}

			case "employee":
				if (user.getAccesslevel().equals(User.AccessLevel.EMPLOYEE)) {

					System.out.println("Hello " + user.getUserName() + " " + "what can i do for you?");

					isEmployee = true;
					notLogin = false;
					break;
					
				} else {
					System.out.println("It does not appear that you have an employee account.");
					System.out.println("Employee accounts must be created by HR or Managment");
					System.out.println("System access closing.");
				    System.exit(0);
				}
		
			default:
				System.out.println("if you're reading this, something has gone terribly wrong here");
			}
		}

		while (isCustomer) {

			customerSelection = css.customerMenu();
			switch (customerSelection) {
			case "viewLot":
				carList = carPo.getAllCarsByUser("lot");
				for(Car c: carList) {
					System.out.println(c.getMake() + " " + c.getModel() + " " + c.getYear() + " " + c.getPrice() + " " + c.getVin());
				}
				break;
			case "makeOffer":
				carList = carPo.getAllCarsByUser("lot");
				offer = css.makeAnOffer(user, carList);
				offerPo.createOffer(offer);
				break;
			case "viewMine":
				carList = carPo.getAllCarsByUser(user.getUserName());
				for(Car c: carList) {
					System.out.println(c.getMake() + " " + c.getModel() + " " + c.getYear() + " " + c.getPrice() + " " + c.getVin());
				}
				break;
			case "viewPayments":
				paymentList = paymentPo.viewUserPayments(userName);
				for(Payment p: paymentList) {
					System.out.println(p.toString());
				}
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
			case "addCar":
				car = ess.addCarToLot();
				carPo.createCar(car);
				break;
			case "seeOffers":
				offerList = offerPo.getAllOffersPending();
				for(Offer o: offerList) {
					System.out.println(o.toString());
				}
				break;
			case "acceptOffer":
				offerList = offerPo.getAllOffersPending();
				for(Offer o: offerList) {
					System.out.println(o.toString());
				}
				offerId = ess.acceptAnOffer();
				offerPo.acceptOffer(offerId);
				offer = offerPo.getOffer(offerId);
				offerPo.rejectCompetingOffers(offer.getCarVin());
				break;
			case "finalize":
				offerList = offerPo.getAllOffersAccepted();
				for(Offer o: offerList) {
					System.out.println(o.toString());
				}
				offerId = ess.finalizeAnOffer();
				offer = offerPo.getOffer(offerId);
				vin = offer.getCarVin();
				userName = offer.getUserName();
				ess.finalizeSale(offer);
				carPo.updateCarSold(vin, userName);
				car = carPo.getCarByVin(vin);
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("if you're reading this, something has gone terribly wrong here");
			}
		}

	}
}
