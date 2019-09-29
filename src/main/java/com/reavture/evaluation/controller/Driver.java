package com.reavture.evaluation.controller;

import com.reavture.evaluation.dao.CarDao;
import com.reavture.evaluation.dao.CarDaoSerialization;
import com.reavture.evaluation.pojo.Car;

public class Driver {
	
	private static CarDao carDao = new CarDaoSerialization();

	public static void main(String[] args) {

		
		  Car car = new Car("Toyota", "Tacoma", 2005, 9000.00, "3344334455", null);
		  carDao.createCar(car);
		  
		 
	}

}
