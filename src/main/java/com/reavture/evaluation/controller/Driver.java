package com.reavture.evaluation.controller;

import com.reavture.evaluation.dao.CarDao;
import com.reavture.evaluation.dao.CarDaoSerialization;
import com.reavture.evaluation.dao.UserDao;
import com.reavture.evaluation.dao.UserDaoSerialization;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.User;

public class Driver {
	
	private static CarDao carDao = new CarDaoSerialization();
	private static UserDao userDao = new UserDaoSerialization();

	public static void main(String[] args) {

		
		/*
		 * Car car = new Car("Toyota", "Tacoma", 2005, 9000.00, "3344334455", null);
		 * carDao.createCar(car);
		 */
		  
		  User newUser = new User("userName5", "password4", User.AccessLevel.USER, "userId4");
		  userDao.createUser(newUser);
		 
	}

}
