package com.reavture.evaluation.dao;

import com.reavture.evaluation.pojo.Customer;

public interface CustomerDao {
	
	public String createCustomer(Customer c);
	
	public Customer readCustomer(String customerId);

}
