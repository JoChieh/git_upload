package com.cathaybk.practice.nt50337.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JavaQ6 {

	public static final String INFILE_PATH = "C:/Users/Admin/Desktop/cars.csv";
	public static final String OUTFILE_PATH_STRING = "C:/Users/Admin/Desktop/cars2.csv";

	public static void main(String[] args) {

		File inFile = new File(INFILE_PATH);

		Map<String, String> headMap = new LinkedHashMap<>();
		List<Map<String, String>> tableList = new LinkedList<>();
		// read
		try (FileReader fr = new FileReader(inFile); BufferedReader br = new BufferedReader(fr);) {

			String commaLine = br.readLine();
			String[] lineArr = commaLine.split(",");

			headMap.put("Manufacturer", lineArr[0]);
			headMap.put("Type", lineArr[1]);
			headMap.put("Min.Price", lineArr[2]);
			headMap.put("Price", lineArr[3]);

			while (br.ready()) {
				Map<String, String> lineMap = new LinkedHashMap<>();
				commaLine = br.readLine();
				lineArr = commaLine.split(",");

				lineMap.put("Manufacturer", lineArr[0]);
				lineMap.put("Type", lineArr[1]);
				lineMap.put("Min.Price", lineArr[2]);
				lineMap.put("Price", lineArr[3]);

				tableList.add(lineMap);

				// 實作Comparator介面
				Collections.sort(tableList, new Comparator<Map<String, String>>() {

					@Override
					public int compare(Map<String, String> o1, Map<String, String> o2) {
						return -(o1.get("Price").compareTo(o2.get("Price")));
					}

				});
			}

		} catch (Exception e) {
			System.out.println("讀取失敗");
		}

		// write
		File outFile = new File(OUTFILE_PATH_STRING);
		try (FileOutputStream fos = new FileOutputStream(outFile);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bfw = new BufferedWriter(osw);) {

			// write
			try {
				// add BOM(byte-order mark)
				fos.write(0xef);
				fos.write(0xbb);
				fos.write(0xbf);

				// write table head
				bfw.write(headMap.get("Manufacturer") + ',');
				bfw.write(headMap.get("Type") + ',');
				bfw.write(headMap.get("Min.Price") + ',');
				bfw.write(headMap.get("Price"));
				bfw.newLine();

				// write table data
				for (Map<String, String> lineMap : tableList) {
					bfw.write(lineMap.get("Manufacturer") + ',');
					bfw.write(lineMap.get("Type") + ',');
					bfw.write(lineMap.get("Min.Price") + ',');
					bfw.write(lineMap.get("Price"));
					bfw.newLine();
				}
			} catch (Exception e) {
				System.out.println("寫入緩衝區失敗");
				e.printStackTrace();
			}

			// flush：將緩衝區數據刷新到目的文件中
			try {
				bfw.flush();
			} catch (Exception e) {
				System.out.println("刷新失敗");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("寫手宣告失敗");
			e.printStackTrace();
		}

		// show on screen
		// sort By Manufacturer

		// 實作Comparator介面
		Collections.sort(tableList, new Comparator<Map<String, String>>() {

			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				return o1.get("Manufacturer").compareTo(o2.get("Manufacturer"));
			}

		});

		// print screen

		// print table head
		for (String valueString : headMap.values()) {
			System.out.printf("%-12s\t", valueString);
		}
		System.out.println();

		// default sums;
		BigDecimal bigSumMinPrice = BigDecimal.ZERO;
		BigDecimal bigSumPrice = BigDecimal.ZERO;
		BigDecimal sumMinPrice = BigDecimal.ZERO;
		BigDecimal sumPrice = BigDecimal.ZERO;
		// default data values;
		String thisManufacturer;
		String thisType;
		BigDecimal thisMinPrice = BigDecimal.ZERO;
		BigDecimal thisPrice = BigDecimal.ZERO;
		String nextManufactuer = tableList.get(1).get("Manufacturer");

		// print table data
		for (Map<String, String> lineMap : tableList) {
			// get values
			thisManufacturer = lineMap.get("Manufacturer");
			thisType = lineMap.get("Type");
			thisMinPrice = new BigDecimal(lineMap.get("Min.Price"));
			thisPrice = new BigDecimal(lineMap.get("Price"));
			// add price
			if (nextManufactuer.equals(thisManufacturer)) {
				sumMinPrice = sumMinPrice.add(thisMinPrice);
				sumPrice = sumPrice.add(thisPrice);
			} else {
				System.out.printf("%-12s\t%-12s\t%-12s\t%-12s\t\n", "小計", "", sumMinPrice.toPlainString(), sumPrice.toPlainString());
				bigSumMinPrice = bigSumMinPrice.add(sumMinPrice);
				sumMinPrice = thisMinPrice;
				bigSumPrice = bigSumPrice.add(sumPrice);
				sumPrice = thisPrice;
				nextManufactuer = thisManufacturer;
			}
			//print values
			System.out.printf("%-12s\t%-12s\t%-12s\t%-12s\t\n", thisManufacturer, thisType, thisMinPrice, thisPrice);
		}
		// last else for last manufacturer
		System.out.printf("%-12s\t%-12s\t%-12s\t%-12s\t\n", "小計", "", sumMinPrice.toPlainString(),
				sumPrice.toPlainString());
		bigSumMinPrice = bigSumMinPrice.add(sumMinPrice);
		bigSumPrice = bigSumPrice.add(sumPrice);
		System.out.printf("%-12s\t%-12s\t%-12s\t%-12s\t\n", "合計", "", bigSumMinPrice.toPlainString(),
				bigSumPrice.toPlainString());

	}

}