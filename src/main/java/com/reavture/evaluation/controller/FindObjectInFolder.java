package com.reavture.evaluation.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.reavture.evaluation.dao.CustomerDaoSerialization;
import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.User;

public class FindObjectInFolder {
	
	public Customer customerFromUser(User user) {
		Customer customer = null;
		
		CustomerDaoSerialization customerSerial = new CustomerDaoSerialization();
		
		String userId = user.getUserId();
		
	
			try {
				List<File> filesInFolder = Files.walk(Paths.get("./databse/customers"))
				.filter(Files::isRegularFile)
				.map(Path::toFile)
				.collect(Collectors.toList());
			} catch (IOException e) {
				System.out.println("it does not appear you have a customer account");
				e.printStackTrace();
			}
		
		
		return customer;
	}

}


