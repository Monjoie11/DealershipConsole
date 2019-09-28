package com.reavture.evaluation.dao;

import com.reavture.evaluation.pojo.Car;
	
public interface Cardao {

		public void createCar(Car c);
		
		public Car readCar(String vin);
		
	}