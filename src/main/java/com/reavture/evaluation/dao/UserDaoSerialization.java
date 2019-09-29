package com.reavture.evaluation.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.reavture.evaluation.pojo.Car;
import com.reavture.evaluation.pojo.User;

public class UserDaoSerialization implements UserDao{

	//create user logic needs to reflect change in logic that of a user id exists it cannot be rewritten
	
	@Override
	public String createUser(User user) {
		String fileName;	
		
		if (user.getUserId() != null) {
			fileName = "./database/users/" + user.getUserId() + ".dat";
		} else {
			fileName = "./database/newusers.dat";
		}
		
		try (FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(user);
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
	public User readUser(String userId) {
		String fileName = "./database/users/" + userId + ".dat";
		
		User user = null;
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			user = (User) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
}