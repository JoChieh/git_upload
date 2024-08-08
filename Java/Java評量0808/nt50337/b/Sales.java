package com.cathaybk.practice.nt50337.b;

public class Sales extends Employee {

	private int bonus;
	private int payment;

	public Sales(String name, String dept, int salary, int volumn) {
		super.setName(name);
		super.setDepartment(dept);
		super.setSalary(salary);
		
		bonus = (int)(volumn * 0.05);
		this.setPayment(salary + bonus);
	}
	
	

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println("業績獎金： " + bonus);
		System.out.println("總計： " + payment);
	}



	// getter&setter
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

}
