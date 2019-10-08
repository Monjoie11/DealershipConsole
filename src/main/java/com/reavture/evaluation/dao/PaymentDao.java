package com.reavture.evaluation.dao;

import java.util.List;

import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Payment;

public interface PaymentDao {

	public void createPayment(Payment payment);
	
	public List<Payment> viewUserPayments(String userName);
	

}
