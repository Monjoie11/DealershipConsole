package com.reavture.evaluation.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.reavture.evaluation.controller.SalesSystem;
import com.reavture.evaluation.pojo.Offer;

@RunWith(MockitoJUnitRunner.class)
public class SalesSystemTest {
	
	SalesSystem test = new SalesSystem();
	
	@Mock
	Offer accepted;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setPayPeriod(){
		assertEquals("shouldreturn an integer value for months payments will be made", 48, test.setPayPeriod(48));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void payPeriodExceptions(){
		test.setPayPeriod(-48);
		test.setPayPeriod(481);
	}
	
	@Test
	public void positiveTtadeValue(){
		assertEquals(4500.00, test.setTradeValue(4500.00), 0.00);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tradeValueExceptions(){
		test.setTradeValue(-4800.00);
	}
	
	@Test
	public void okInterestRate(){
//		when(accepted.getAmount()).thenReturn(10000.00);
//		when(accepted.getStatus()).thenReturn(Offer.Status.ACCEPTED);
		assertEquals(700.00, test.determineInterest(.07), 0.01);
		
	}
	
	
	
	

}
