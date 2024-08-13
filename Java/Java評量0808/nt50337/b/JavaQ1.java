package com.cathaybk.practice.nt50337.b;

public class JavaQ1 {

	public static void main(String[] args) {
		// multiplicand：被乘數, multiplier：乘數
		for (int multiplier = 1; multiplier < 10; multiplier++) {
			for (int multiplicand = 2; multiplicand < 10; multiplicand++) {
				System.out.printf("%d*%d=%2d\t", multiplicand, multiplier, multiplicand * multiplier);
			}
			System.out.println();
		}
	}
}