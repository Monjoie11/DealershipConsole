package com.reavture.evaluation.controller;

import com.reavture.evaluation.dao.CarDao;
import com.reavture.evaluation.dao.CarDaoSerialization;
import com.reavture.evaluation.dao.EmployeeDao;
import com.reavture.evaluation.dao.EmployeeDaoSerialization;
import com.reavture.evaluation.dao.UserDao;
import com.reavture.evaluation.dao.UserDaoSerialization;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.Employee.Department;
import com.reavture.evaluation.pojo.User.AccessLevel;

public class Driver {
	
	private static CarDao carDao = new CarDaoSerialization();
	private static UserDao userDao = new UserDaoSerialization();
	private static EmployeeDao employeeDao = new EmployeeDaoSerialization();

	public static void main(String[] args) {

		
		/*
		 * Car car = new Car("Toyota", "Tacoma", 2005, 9000.00, "3344334455", null);
		 * carDao.createCar(car);
		 */
		  
		/*
		 * User newUser = new User("userName9", "password9", User.AccessLevel.USER,
		 * "userId9"); userDao.createUser(newUser);
		 */
		
		Employee newEmployee = new Employee("userName1", "password1", AccessLevel.EMPLOYEE, "userId1", "firstName1",
				"lastName1", "employeeId1", Department.SALES, (float) 11.11, "111111111");
		 employeeDao.createEmployee(newEmployee);
	}

}
