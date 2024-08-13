package com.cathaybk.practice.nt50337.b;

public class diamond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int size = 9;

		//triangle
		for (int line = 1; line <= size; line++) {
			for(int blank = 1; blank <= size-line ; blank++) {
				System.out.print(' ');
			}
			for(int star = 1; star <= line; star++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		//reverse triangle
		for (int line = size - 1; line >= 1; line--) {//4
			for(int blank = 1; blank <= size-line ; blank++) {
				System.out.print(' ');
			}
			for(int star = 1; star <= line; star++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		

	}

}
