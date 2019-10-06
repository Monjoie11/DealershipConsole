package com.reavture.evaluation.pojo;

import java.beans.Transient;
import java.io.Serializable;

public class User implements Serializable{
	
	private String userName;
	
	private String  password;

	private AccessLevel accesslevel;
	
	private int userId;

	
    public User(String userName, String password, AccessLevel accesslevel, int userId) {
		super();
		this.userName = userName;
		this.password = password;
		this.accesslevel = accesslevel;
		this.userId = userId;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public AccessLevel getAccesslevel() {
		return accesslevel;
	}


	public void setAccesslevel(AccessLevel accesslevel) {
		this.accesslevel = accesslevel;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accesslevel == null) ? 0 : accesslevel.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accesslevel != other.accesslevel)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", accesslevel=" + accesslevel + ", userId="
				+ userId + "]";
	}

	
	

	public static enum AccessLevel{
	  EMPLOYEE, USER, CUSTOMER;
	}

	

}
