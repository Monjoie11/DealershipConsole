package com.revature.evaluation.utility;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reavture.evaluation.dao.UserDaoSerialization;

public class LoginUiTest {
	
	 UserDaoSerialization userSerial = new UserDaoSerialization();
	 String userId = "userId2";
	 LoginUi login = new LoginUi();

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
	public void loginTestknown() {
		assertEquals(userSerial.readUser(userId), LoginUi.class);
	}

}
