package com.reavture.evaluation.dao;

import static com.revature.evaluation.utility.LoggerUtil.trace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reavture.evaluation.jdbc.ConnectionFactory;
import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Payment;
import com.reavture.evaluation.pojo.User;

public class PaymentDaoPostgres implements PaymentDao {
	
	Payment payment = new Payment();
	
	private Connection conn = ConnectionFactory.getConnection();

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createPayment(Payment payment) {
		String sql = "insert into payment (username, carvin, amount) values(?, ?, ?)";

		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, payment.getUserName());
			stmt.setString(2, payment.getVin());
			stmt.setString(3, Double.toString(payment.getAmount()));
			stmt.executeUpdate();
			trace("executing insert offer");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(payment.toString());

	}

	@Override
	public List<Payment> viewUserPayments(String userName) {
	
			
			List<Payment> paymentList = new ArrayList<Payment>();
			
			Payment payment = new Payment();
			
			String sql = "select * from car where username = ?";
			 
			PreparedStatement stmt;
			
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, userName);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					payment.setUserName(rs.getString(1));
					payment.setVin(rs.getString(2));
					payment.setAmount(rs.getDouble(3));
					payment.setPaymentId(rs.getInt(4));
					
				
					trace("get payments by user while block");
					paymentList.add(payment);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return paymentList;
		}

}
