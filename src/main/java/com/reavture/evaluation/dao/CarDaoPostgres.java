package com.reavture.evaluation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.reavture.evaluation.jdbc.ConnectionFactory;
import com.reavture.evaluation.pojo.Car;

public class CarDaoPostgres implements CarDao {
	
	private Connection conn = ConnectionFactory.getConnection();
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createCar(Car car) {
			
			String sql = "insert into car (vin, make, model, year, price, customerid) "
					+ "values(?, ?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1,  car.getVin());
				stmt.setString(2,  car.getMake());
				stmt.setString(3,  car.getModel());
				stmt.setString(4,  Integer.toString(car.getYear()));
				stmt.setString(5,  Double.toString(car.getPrice()));
				stmt.setString(6,  car.getCustomerId());
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	

	@Override
	public Car getCar(String vin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCar(Car cookie, String vin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCar(Car car) {
		// TODO Auto-generated method stub

	}

}
