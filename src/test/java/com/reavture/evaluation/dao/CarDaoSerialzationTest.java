package com.reavture.evaluation.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Customer;

public class CarDaoSerialzationTest {
	
	CarDaoSerialization carSerial = new CarDaoSerialization();
	Car newaCar = new Car("make", "model", 2019, 1000.00, "3232422324", null);
	Car lostCar = new Car("make", "model", 2019, 1000.00, null, null);

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
	public void isThisCar() {
		assertEquals("./database/cars/3232422324.dat", carSerial.createCar(newaCar));
		assertEquals("./database/lostcars.dat", carSerial.createCar(lostCar));
	}
	
	@Test
	public void isThisCarException() {
		assertEquals("./database/cars/3232422324.dat", carSerial.createCar(newaCar));
		assertEquals("./database/lostcars.dat", carSerial.createCar(lostCar));
	}

}
