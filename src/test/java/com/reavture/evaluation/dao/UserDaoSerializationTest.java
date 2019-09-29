package com.reavture.evaluation.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reavture.evaluation.pojo.User;
import com.reavture.evaluation.pojo.User.AccessLevel;

public class UserDaoSerializationTest {

	UserDaoSerialization userSerial = new UserDaoSerialization();
	User newUser = new User("userName", "password", User.AccessLevel.USER, "userId");
	User newUser1 = new User("userName4", "password4", User.AccessLevel.USER, "userId4");
	User lostUser = new User("userName", "password", User.AccessLevel.USER, null);

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
	public void isThisUser() {
		assertEquals("./database/users/userId.dat", userSerial.createUser(newUser));
		assertEquals("./database/newusers.dat", userSerial.createUser(lostUser));
	}
	
	
	public void readUserTest() {
		assertEquals(newUser1, userSerial.readUser("3344334455"));
	}
	

}
