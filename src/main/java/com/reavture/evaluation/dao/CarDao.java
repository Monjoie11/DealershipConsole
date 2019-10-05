package com.reavture.evaluation.dao;

import java.util.List;

import com.reavture.evaluation.pojo.Car;

public interface CarDao {

	public void createCar(Car car);

	public Car getCar(String vin);

	public List<Car> getAllCars();

	public void updateCar(Car cookie, String vin);

	public void deleteCar(Car car);

}

