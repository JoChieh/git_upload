package com.cathaybk.practice.nt50337.b;

public class Employee implements IWork {

	private String name;
	private String department;
	private int salary;

	@Override
	public void printInfo() {
		System.out.println("薪資單");
		System.out.println("姓名： " + name + " 工作部門： " + department);
		System.out.println("月薪： " + salary);
	}

	// getter&setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
