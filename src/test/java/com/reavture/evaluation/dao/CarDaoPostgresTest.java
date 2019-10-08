package com.reavture.evaluation.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.reavture.evaluation.jdbc.ConnectionFactory;
import com.reavture.evaluation.pojo.Car;

public class CarDaoPostgresTest {
	
	private CarDaoPostgres carDao;
	
	Car car;
	
	@Mock
	private Connection conn;
	
	                                                 
	@Spy
	private PreparedStatement addStmt = ConnectionFactory.getConnection().prepareStatement("insert into car (vin, make, model, year, price, username) values(?, ?, ?, ?, ?, ?)");

	@Spy
	private PreparedStatement readStmt = ConnectionFactory.getConnection().prepareStatement("select * from car");
	
	@Spy
	private PreparedStatement updateStmt = ConnectionFactory.getConnection().prepareStatement("update car set status where vin = ?");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		carDao = new CarDaoPostgres();
		
		car = new Car();
		car.setMake("honda");
		car.setModel("accord");
		car.setVin("11233");
		car.setYear(2006);
		car.setPrice(2000.00);
		car.setuserName("userName5");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateCar() {
		try {
			when(conn.prepareStatement("insert into car (vin, make, model, year, price, username) values(?, ?, ?, ?, ?, ?)")).thenReturn(addStmt);
			carDao.setConn(conn);
			
			carDao.createCar(car);
			Mockito.verify(addStmt).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCarByVin() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCarSold() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllCarsByUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCar() {
		fail("Not yet implemented");
	}
	
	public CarDaoPostgresTest() throws SQLException {
		super();
	}

}
