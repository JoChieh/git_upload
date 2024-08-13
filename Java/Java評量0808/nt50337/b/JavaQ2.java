package com.cathaybk.practice.nt50337.b;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class JavaQ2 {

	public static void main(String[] args) {

		List<Integer> lottoList = new LinkedList<>();

		Random rand = new Random();
		while (lottoList.size() < 6) {

			Integer num = rand.nextInt(49) + 1;

			if (!lottoList.contains(num)) {
				lottoList.add(num);
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append("排序前：");
		printLotto(sb, lottoList);
		sb.setLength(0);

		Collections.sort(lottoList);

		sb.append("排序後：");
		printLotto(sb, lottoList);
	}

	private static void printLotto(StringBuilder sb, List<Integer> lottoList) {
		for (int num : lottoList) {
			sb.append(num).append(' ');
			if (num < 10) {
				sb.append(' ');// for tidiness
			}
		}
		System.out.println(sb.toString());
	}
}
