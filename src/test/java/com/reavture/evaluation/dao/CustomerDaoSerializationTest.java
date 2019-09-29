package com.reavture.evaluation.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.User.AccessLevel;

public class CustomerDaoSerializationTest {
	
   CustomerDaoSerialization customerSerial = new CustomerDaoSerialization();
   
   Customer newCustomer = new Customer("userName4", "password4", AccessLevel.CUSTOMER, "userId4", "firstName4",
			"lastName4", "customerId4", "address4", null, null, 0, 0, (float) 0.0);
	
   
   Customer lostCustomer = new Customer();
   
   Customer newCustomer5 = new Customer("userName5", "password5", AccessLevel.CUSTOMER, "userId5", "firstName5",
			"lastName5", "customerId5", "address5", null, null, 0, 0, 0.00f);


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isThsCustomer() {
			assertEquals("./database/customers/customerId4.dat", customerSerial.createCustomer(newCustomer));
			assertEquals("./database/newcustomers.dat", customerSerial.createCustomer(lostCustomer));
		}
	
	@Test
	public void readEmployeeTest() {
		assertEquals(newCustomer5, customerSerial.readCustomer("CustomerId5"));
	}
}
