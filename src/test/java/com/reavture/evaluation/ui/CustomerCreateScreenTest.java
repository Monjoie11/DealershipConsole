package com.reavture.evaluation.ui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.User.AccessLevel;

public class CustomerCreateScreenTest {
	
	CustomerCreateScreen custScreen = new CustomerCreateScreen();
	
	 Customer newCustomer = new Customer("userName4", "password4", AccessLevel.CUSTOMER, "userId4", "firstName4",
				"lastName4", "customerId4", "address4", null, null, 0, 0, (float) 0.0);
	 
	 User newUser = new User("userName4", "password4", AccessLevel.USER, "userId4");

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
	public void test() {
		assertEquals(newCustomer, custScreen.createCustomer(newUser));
	}

}
