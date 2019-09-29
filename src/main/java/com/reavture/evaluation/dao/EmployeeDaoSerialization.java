package com.reavture.evaluation.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.reavture.evaluation.pojo.Employee;
import com.reavture.evaluation.pojo.User;

public class EmployeeDaoSerialization implements EmployeeDao{
	
//Create a method to read in a user and autopopulate the first fields of the employee constructor

	@Override
	public String createEmployee(Employee employee) {
		String fileName;	
		
		if (employee.getEmployeeId() != null) {
			fileName = "./database/employees/" + employee.getEmployeeId() + ".dat";
		} else {
			fileName = "./database/newemployees.dat";
		}
		
		try (FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(employee);
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
	public Employee readEmployee(String employeeId) {
		String fileName = "./database/employees/" + employeeId + ".dat";
		
		Employee employee = null;
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			employee = (Employee) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}

}
