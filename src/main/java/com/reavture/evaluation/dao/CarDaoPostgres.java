package com.reavture.evaluation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static com.revature.evaluation.utility.LoggerUtil.*;
import com.reavture.evaluation.jdbc.ConnectionFactory;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Customer;

public class CarDaoPostgres implements CarDao {

	Car car = new Car("make2", "model2", "vin2", 2006, 2000.00, "customerId2");

	private Connection conn = ConnectionFactory.getConnection();

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createCar(Car car) {
		//TODO create some logic to set null customerid to "lot" 
		String id = null;

		String sql = "insert into car (vin, make, model, year, price, customerid) " + "values(?, ?, ?, ?, ?, ?)";

	
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, car.getVin());
			stmt.setString(2, car.getMake());
			stmt.setString(3, car.getModel());
			stmt.setString(4, Integer.toString(car.getYear()));
			stmt.setString(5, Double.toString(car.getPrice()));
			stmt.setString(6, car.getCustomerId());
			stmt.executeUpdate();
			trace("executing insert car");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Car getCarByVin(String vin) {

		String sql = "select * from car where vin = ?";

		PreparedStatement stmt;

		Car car = new Car();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vin);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				car.setVin(rs.getString(1));
				car.setMake(rs.getString(2));
				car.setMake(rs.getString(3));
				car.setYear(rs.getInt(4));
				car.setPrice(rs.getDouble(5));
				car.setCustomerId(rs.getString(6));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return car;

	}
	
	public void updateCarSold(Car car, Customer customer) {
			
			String sql = "update car set customerid = ? where vin = ?";
			
			
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, customer.getCustomerId());
				stmt.setString(2, car.getVin());
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	

	@Override
	public List<Car> getAllCarsByCustomer(String customerId) {
		//to see all cars search by *; to see cars on lot search by lot
		
		
		String sql = "select * from car where customerid = ?";
		 
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vin);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				car.setVin(rs.getString(1));
				car.setMake(rs.getString(2));
				car.setMake(rs.getString(3));
				car.setYear(rs.getInt(4));
				car.setPrice(rs.getDouble(5));
				car.setCustomerId(rs.getString(6));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
