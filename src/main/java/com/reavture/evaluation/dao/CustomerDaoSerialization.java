package com.reavture.evaluation.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.reavture.evaluation.pojo.Customer;
import com.reavture.evaluation.pojo.Employee;

public class CustomerDaoSerialization implements CustomerDao {

	@Override
	public String createCustomer(Customer customer) {
		String fileName;

		if (customer.getCustomerId() != null) {
			fileName = "./database/customers/" + customer.getCustomerId() + ".dat";
		} else {
			fileName = "./database/newcustomers.dat";
		}

		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(customer);
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
	public Customer readCustomer(String customerId) {
		String fileName = "./database/customers/" + customerId + ".dat";

		Customer customer = null;

		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			customer = (Customer) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return customer;
	
	}
	

}
