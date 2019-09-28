package com.reavture.evaluation.pojo;

import java.beans.Transient;

public class User {
	
	private String userName;
	
	private transient String  password;

	private AccessLevel accesslevel;

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.accesslevel = accesslevel;
	}
	
    enum AccessLevel{
	  EMPLOYEE, USER, SYSTEM;
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

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accesslevel == null) ? 0 : accesslevel.hashCode());
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
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	public void applyForAccess() {
		
	}

	

}
