package com.reavture.evaluation.dao;

import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.User;

public interface EmployeeDao {
	
	public String createEmployee(Employee e);
	
	public User readEmployee(String employeeId);

}
