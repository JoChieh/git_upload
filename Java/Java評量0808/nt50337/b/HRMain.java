package com.cathaybk.practice.nt50337.b;

import java.util.ArrayList;
import java.util.List;

public class HRMain {

	public static void main(String[] args) {
		List<Employee> employeeList= new ArrayList<>();
		
		//Sales(String name, String dept, int salary, int volumn)
		//Superviser(String name, String dept, int salary)
		employeeList.add(new Sales("張志城", "信用卡部", 35000, 6000));
		employeeList.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employeeList.add(new Superviser("李中白", "資訊部", 65000));
		employeeList.add(new Superviser("林小中", "理財部", 80000));
		for (Employee employee : employeeList) {
			employee.printInfo();
		}
	}

}
