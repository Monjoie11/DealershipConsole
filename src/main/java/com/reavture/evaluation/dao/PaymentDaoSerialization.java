package com.reavture.evaluation.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.reavture.evaluation.pojo.Offer;
import com.reavture.evaluation.pojo.Payment;

public class PaymentDaoSerialization implements PaymentDao {

	@Override
	public String createPayment(Payment payment) {

		String fileName;	
		
		if (payment.getPaymentId() != null) {
			fileName = "./database/payments/" + payment.getPaymentId() + ".dat";
		} else {
			fileName = "./database/newPayments.dat";
		}
		
		try (FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(payment);
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
	public Offer readPayment(String paymentId) {
String fileName = "./database/payments/" + paymentId + ".dat";
		
		Offer offer = null;
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			offer = (Offer) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return offer;
	}
	
}
