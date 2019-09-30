package com.reavture.evaluation.ui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SecondScreenUiTest {
	
	SecondScreenUi secondScreen = new SecondScreenUi();

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
	public void testEmployee() {
		assertEquals("employee", secondScreen.pickType());
	}
	
	@Test
	public void testCustomer() {
		assertEquals("customer", secondScreen.pickType());
	}
	
	@Test
	public void testNew() {
		assertEquals("create", secondScreen.pickType());
	}

}
