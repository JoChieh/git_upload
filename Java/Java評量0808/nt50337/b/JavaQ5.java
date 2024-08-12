package com.cathaybk.practice.nt50337.b;

import java.util.Calendar;
import java.util.Scanner;

public class JavaQ5 {

	public static void main(String[] args) {
		System.out.print("輸入介於1-12間的整數m:");
		Scanner sc = new Scanner(System.in);
		int myMonth = sc.nextInt();
		sc.close();

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		cal.set(Calendar.MONTH, myMonth - 1);// month-1
		int month = cal.get(Calendar.MONTH) + 1;

		System.out.printf("                     %d年%d月\n", year, month);
		System.out.println("---------------------------------------------------");
		System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "日", "一", "二", "三", "四", "五", "六");
		System.out.println("===================================================");

		// 0?01 is Thursday
		cal.set(Calendar.DATE, 1);
		int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;

		// how many days in a month
		int maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// print calendar

		// 空幾格再開始1號
		for (int blank = 0; blank < weekDay; blank++) {
			System.out.printf("%2s\t", "");
		}

		// first line
		for (int day = 1; day <= 7 - weekDay; day++) {
			System.out.printf("%2d\t", day);
		}

		System.out.println();
		// the rest lines
		int nextline = 0;
		for (int day = 8 - weekDay; day <= maxDays; day++) {
			System.out.printf("%2d\t", day);
			nextline++;
			if (nextline == 7) {
				System.out.println();
				nextline = 0;
			}
		}

	}

}
