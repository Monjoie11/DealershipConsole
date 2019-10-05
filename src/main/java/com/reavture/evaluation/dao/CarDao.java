package com.reavture.evaluation.dao;

import com.reavture.evaluation.pojo.Car;
	
public interface CarDao {

		public String createCar(Car c);
		
		public Car readCar(String vin);
		
	}