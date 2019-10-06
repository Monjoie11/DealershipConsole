package com.reavture.evaluation.dao;


import java.util.List;


import com.reavture.evaluation.pojo.User;

public interface UserDao {
	
	public void createUser(User user);
	
	public User getUserByName(String userName);

	public List<User> getAllUsers();

	public void updateUser(String userName);

	public void deleteUser(String userName);
	
}


