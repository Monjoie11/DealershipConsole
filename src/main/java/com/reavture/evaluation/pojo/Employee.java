package com.reavture.evaluation.pojo;

public class Employee extends User {
	
	private String name;
	
	private Department department;
	
	private float compensation;
	
	private transient String socialSecurity;
	
	

	public Employee(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(String userName, String password, String name, Department department, float compensation,
			String socialSecurity) {
		super(userName, password);
		this.name = name;
		this.department = department;
		this.compensation = compensation;
		this.socialSecurity = socialSecurity;
	}
	
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}




	enum Department{
		SALES, SERVICE, FINANCE, SUPPORT, MANAGMENT
	}


}
