package com.reavture.evaluation.ui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reavture.evaluation.dao.UserDaoSerialization;

public class LoginUiTest {
	
	UserDaoSerialization userSerial = new UserDaoSerialization();
	
	LoginUi login = new LoginUi();
	
	String userId = "userId2";

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
	public void test() {
		assertEquals(userSerial.readUser(userId), login.userLogin());
	}
	
	//the test below will appear the same but I am using the catch block to construct by hitting enter when prompted for userId

	
	@Test
	public void testnoId() {
		assertEquals(userSerial.readUser(userId), login.userLogin());
	}
}
