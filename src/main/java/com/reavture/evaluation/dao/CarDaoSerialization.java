package com.reavture.evaluation.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.reavture.evaluation.pojo.Car;

public class CarDaoSerialization implements CarDao {
	
	String fileName;
//	FileOutputStream fos = null;
//	ObjectOutputStream oos = null;

	@Override
	public String createCar(Car car) {
		String fileName;	
	
		if (car.getVin() != null) {
			fileName = "./database/cars/" + car.getVin() + ".dat";
		} else {
			fileName = "./database/lostcars.dat";
		}
		
		try (FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(car);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileName;
		
	}

	@Override
	public Car readCar(String vin) {
		
		String fileName = vin+".dat";
		
		Car car = null;
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			car = (Car) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return car;
	}
}
