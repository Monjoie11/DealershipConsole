package com.reavture.evaluation.pojo;

import java.io.Serializable;

public class Employee extends User implements Serializable{
	
	private String firstName;
	
	private String lastName;
	
	private String employeeId;
	
	private Department department;
	
	private float compensation;
	
	private transient String socialSecurity;
	
	

  

	public Employee(String userName, String password, AccessLevel accesslevel, String userId, String firstName,
			String lastName, String employeeId, Department department, float compensation, String socialSecurity) {
		super(userName, password, accesslevel, userId);
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.department = department;
		this.compensation = compensation;
		this.socialSecurity = socialSecurity;
	}
	
	
	public Employee(String userName, String password, AccessLevel accesslevel, String userId) {
		super(userName, password, accesslevel, userId);
		// TODO Auto-generated constructor stub
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public float getCompensation() {
		return compensation;
	}


	public void setCompensation(float compensation) {
		this.compensation = compensation;
	}


	public String getSocialSecurity() {
		return socialSecurity;
	}


	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(compensation);
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Float.floatToIntBits(compensation) != Float.floatToIntBits(other.compensation))
			return false;
		if (department != other.department)
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", employeeId=" + employeeId
				+ ", department=" + department + ", compensation=" + compensation + "]";
	}





	public static enum Department{
		SALES, SERVICE, FINANCE, SUPPORT, MANAGMENT
	}


}
