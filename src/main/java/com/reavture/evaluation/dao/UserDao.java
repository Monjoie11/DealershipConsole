package com.reavture.evaluation.dao;


import com.reavture.evaluation.pojo.User;

public interface UserDao {
	
	public String createUser(User u);
	
	public User readUser(String userId);
	
}


