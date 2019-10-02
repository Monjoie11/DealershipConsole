package com.reavture.evaluation.dao;

import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Payment;

public interface PaymentDao {

	public String createPayment(Payment payment);
	
	public Offer readPayment(String paymentId);
	

}
