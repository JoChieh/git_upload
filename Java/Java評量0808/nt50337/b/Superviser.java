package com.cathaybk.practice.nt50337.b;

public class Superviser extends Employee {

	private int payment;

	public Superviser(String name, String dept, int salary) {
		super(name, dept, salary);
		this.payment = salary;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("總計： " + payment);
	}

	// getter&setter
	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
}
