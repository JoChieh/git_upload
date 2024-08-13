package com.cathaybk.practice.nt50337.b;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaQ5New {

	public static void main(String[] args) {
		System.out.print("輸入介於1-12間的整數m:");
		Scanner sc = new Scanner(System.in);
		int myMonth = 0;
		try {
			myMonth = sc.nextInt();
			if (!(myMonth > 0 && myMonth < 13)) {
				throw new InputMismatchException();
			}
		} catch (InputMismatchException ime) {
			System.err.println("並非介於1-12間的整數，請重新再執行一次");
			System.exit(0);
		} finally {
			sc.close();
		}

		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		localDate = localDate.withMonth(myMonth);
		int month = localDate.getMonthValue();

		System.out.printf("%25d年%d月\n", year, month);
		System.out.println("---------------------------------------------------");
		System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "日", "一", "二", "三", "四", "五", "六");
		System.out.println("===================================================");

		// 0?01 is Thursday
		localDate = localDate.withDayOfMonth(1);
		int weekDay = localDate.getDayOfWeek().getValue();
		if(weekDay == 7) {
			weekDay = 0;
		}
		
		// how many days in a month
		int maxDays = localDate.lengthOfMonth();

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
