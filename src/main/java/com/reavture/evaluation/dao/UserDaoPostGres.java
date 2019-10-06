package com.reavture.evaluation.dao;

import static com.revature.evaluation.utility.LoggerUtil.trace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.reavture.evaluation.jdbc.ConnectionFactory;
import com.reavture.evaluation.pojo.User;

public class UserDaoPostGres implements UserDao {
	
	

	private static Connection conn = ConnectionFactory.getConnection();


	@Override
	public void createUser(User user) {
		//TODO create some logic to set null userid to "lot" 
		String id = null;

		String sql = "insert into user_table (username, password, accesslevel) " + "values(?, ?, ?)";

	
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getAccesslevel().toString());
			stmt.executeUpdate();
			trace("executing insert user");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User getUserByName(String userName) {
		
		String sql = "select * from user_table where username = ?";
		
		PreparedStatement stmt;
		
		User user = new User();
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setAccesslevel(User.AccessLevel.valueOf(rs.getString(3)));
				user.setUserId(rs.getInt(4));
				trace("get user while block");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUsertoCustomer(String userName) {
		String sql = "update user_table set accesslevel = ? where username = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, User.AccessLevel.CUSTOMER.toString());
			stmt.setString(2, userName);
			stmt.executeUpdate();
			trace("user to customer while block");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	

	@Override
	public void deleteUser(String userName) {
		// TODO Auto-generated method stub
		
	}

}
