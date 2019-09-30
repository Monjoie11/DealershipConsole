package com.reavture.evaluation.controller;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.User.AccessLevel;

public class FindObjectInFolderTest {
	FindObjectInFolder findCustomer = new FindObjectInFolder();
	
	 Customer newCustomer = new Customer("userName4", "password4", AccessLevel.CUSTOMER, "userId4", "firstName4",
				"lastName4", "customerId4", "address4", null, null, 0, 0, (float) 0.0);
	 
	 User newUser = new User("userName4", "password4", User.AccessLevel.USER, "userId4");
	 
	 Employee newEmployee = new Employee("userName1", "password1", AccessLevel.EMPLOYEE, "userId1", "firstName1",
				"lastName1", "employeeId1", Employee.Department.SALES, (float) 11.11, "111111111");
	 
	 User newUser1 = new User("userName1", "password1", User.AccessLevel.USER, "userId1");
	 
	 List<File> cars = findCustomer.getAllCars();

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
	public void testCustomer() {
		assertEquals(newCustomer, findCustomer.customerFromUser(newUser));
	}
	
	
	@Test
	public void testEmployee() {
		assertEquals(newEmployee, findCustomer.employeeFromUser(newUser1));
	}
	
	
	@Test
	public void testCarList() {
		assertEquals(cars, findCustomer.getAllCars());
	}
	

}
