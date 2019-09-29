package com.reavture.evaluation.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.Employee.Department;
import com.reavture.evaluation.pojo.User.AccessLevel;

public class EmployeeDaoSerializationTest {
	
	EmployeeDaoSerialization employeeSerial = new EmployeeDaoSerialization();
	Employee newEmployee = new Employee("userName1", "password1", AccessLevel.EMPLOYEE, "userId1", "firstName1",
			"lastName1", "employeeId1", Department.SALES, (float) 11.11, "11111111");
	Employee lostEmployee = new Employee("userName1", "password1", AccessLevel.EMPLOYEE, "userId1", "firstName1",
			"lastName1", null, Department.SALES, (float) 11.11, "11111111");
	


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
	public void isThisUser() {
		assertEquals("./database/employees/employeeId.dat", employeeSerial.createEmployee(newEmployee));
		assertEquals("./database/newemployees.dat", employeeSerial.createEmployee(lostEmployee));
	}

}
