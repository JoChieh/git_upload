package com.cathaybk.practice.nt50337.b;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class dateFormat {

//	輸入字串，運用Java的SimpleDateFormat或DateTimeFormatter等類別先檢核輸入值是否符合yyyy/MM/dd之日期格式，若符合，則印出該日為星期x。
	public static void main(String[] args) {
		System.out.print("請以yyyy/MM/dd輸入日期：");
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		sc.close();
		String[] stringArr = inputString.split("/");
		int[] intArr = new int[3];
		for (int i = 0; i < stringArr.length; i++) {
			intArr[i] = Integer.valueOf(stringArr[i]);
		}

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, intArr[0]);
		cal.set(Calendar.MONTH, intArr[1] - 1);
		cal.set(Calendar.DATE, intArr[2]);
		Date date = cal.getTime();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

		if (!inputString.equals(df.format(date))) {
			System.err.println("Not the right format.");
			System.exit(0);
		}

		int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekDay) {
		case 0: {
			System.out.println(inputString + " is Sunday.");
			break;
		}
		case 1: {
			System.out.println(inputString + " is Monday.");
			break;
		}
		case 2: {
			System.out.println(inputString + " is Tuesday.");
			break;
		}
		case 3: {
			System.out.println(inputString + " is Wednesday.");
			break;
		}
		case 4: {
			System.out.println(inputString + " is Thursday.");
			break;
		}
		case 5: {
			System.out.println(inputString + " is Friday.");
			break;
		}
		case 6: {
			System.out.println(inputString + " is Saturday.");
			break;
		}
		default:
			System.err.println("Unexpected value: " + weekDay);
			break;
		}

	}

}
