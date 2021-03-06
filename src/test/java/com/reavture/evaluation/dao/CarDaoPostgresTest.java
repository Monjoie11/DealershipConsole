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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.reavture.evaluation.jdbc.ConnectionFactory;
import com.reavture.evaluation.pojo.Car;

@RunWith(MockitoJUnitRunner.class)
public class CarDaoPostgresTest {
	
	private CarDaoPostgres carDao;
	
	Car car;
	
	@Mock
	private Connection conn;
	
	                                                 
	@Spy
	private PreparedStatement addStmt = ConnectionFactory.getConnection().prepareStatement("insert into car (vin, make, model, year, price, username) values(?, ?, ?, ?, ?, ?)");

	@Spy
	private PreparedStatement readStmt = ConnectionFactory.getConnection().prepareStatement("select * from car where vin = ?");
	
	@Spy
	private PreparedStatement updateStmt = ConnectionFactory.getConnection().prepareStatement("update car set username = ? where vin = ?");
	
	@Spy
	private PreparedStatement getCarsStmt = ConnectionFactory.getConnection().prepareStatement("select * from car where username = ?");
	
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
		car.setVin("112363");
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
		try {
			when(conn.prepareStatement("select * from car where vin = ?")).thenReturn(readStmt);
			carDao.setConn(conn);
			
			carDao.getCarByVin("112363");
			Mockito.verify(readStmt).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testUpdateCarSold() {
		try {
			when(conn.prepareStatement("update car set username = ? where vin = ?")).thenReturn(updateStmt);
			carDao.setConn(conn);
			
			carDao.updateCarSold("vin6", "monjoie11");
			Mockito.verify(updateStmt).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllCarsByUser() {
		try {
			when(conn.prepareStatement("select * from car where username = ?")).thenReturn(getCarsStmt);
			carDao.setConn(conn);
			
			carDao.getAllCarsByUser("monjoie11");
			Mockito.verify(getCarsStmt).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateCar() {
		fail("Not yet implemented");
	}
	
	public CarDaoPostgresTest() throws SQLException {
		super();
	}

}
