package com.cathaybk.practice.nt50337.b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class JavaQ4 {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Sales("張志城", "信用卡部", 35000, 6000));
		employeeList.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employeeList.add(new Superviser("李中白", "資訊部", 65000));
		employeeList.add(new Superviser("林小中", "理財部", 80000));

		String filePatch = "C:/Users/Admin/Desktop/output.csv";
		File file = new File(filePatch);

		// BufferedWriter：緩衝區，先寫在緩衝區再刷新(flush)FileOutputStream進file中
		try (FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
				BufferedWriter bufW = new BufferedWriter(osw);) {

			System.out.println("寫手宣告成功");
			// add BOM(byte-order mark)
			try {
				fos.write(0xef);
				fos.write(0xbb);
				fos.write(0xbf);
				System.out.println("BOM新增成功");
			} catch (Exception e) {
				System.out.println("BOM新增失敗");
				e.printStackTrace();
			}

			int payment;// when to choose memory vs readable
			for (Employee employee : employeeList) {

				// judge the instance of employees
				if (employee instanceof Sales) {
					payment = ((Sales) employee).getPayment();
				} else {
					payment = ((Superviser) employee).getPayment();
				}

				// write
				try {
					bufW.write(employee.getName() + ',' + payment);
					bufW.newLine();
					System.out.printf(employee.getName() + ',');
					System.out.println("寫入緩衝區成功");
				} catch (Exception e) {
					System.out.println("寫入緩衝區失敗");
					e.printStackTrace();
				}
			}

			// flush：將緩衝區數據刷新到目的文件中
			try {
				bufW.flush();
				System.out.println("刷新成功");
			} catch (Exception e) {
				System.out.println("刷新失敗");
				e.printStackTrace();
			}

			// don't need to close since bufW declared by try-with-resource
		} catch (Exception e) {
			System.out.println("寫手宣告失敗");
			e.printStackTrace();
		}

	}
}
