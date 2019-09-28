package com.reavture.evaluation.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reavture.evaluation.controller.SalesSystem;

public class SalesSystemTest {
	
	SalesSystem test = new SalesSystem();

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

}
