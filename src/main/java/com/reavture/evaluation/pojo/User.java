package com.reavture.evaluation.pojo;

import java.beans.Transient;
import java.io.Serializable;

public class User implements Serializable{
	
	private String userName;
	
	private String  password;

	private AccessLevel accesslevel;
	
	private String userId;

	
    public User(String userName, String password, AccessLevel accesslevel, String userId) {
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


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accesslevel == null) ? 0 : accesslevel.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}



	public static enum AccessLevel{
	  EMPLOYEE, USER, SYSTEM, CUSTOMER;
	}



	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", accesslevel=" + accesslevel + ", userId="
				+ userId + "]";
	}

	

	

}
