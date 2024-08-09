package com.cathaybk.practice.nt50337.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JavaQ6 {

	public static void main(String[] args) {

		String filePatch = "C:/Users/Admin/Desktop/cars.csv";
		File file = new File(filePatch);

		List<Map<String, String>> tableList = new LinkedList<>();
		// read
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {

			while (br.ready()) {
				Map<String, String> lineMap = new LinkedHashMap<>();
				String commaLine = br.readLine();
				String[] lineArr = commaLine.split(",");

				lineMap.put("Manufacturer", lineArr[0]);
				lineMap.put("Type", lineArr[1]);
				lineMap.put("Min.Price", lineArr[2]);
				lineMap.put("Price", lineArr[3]);

				tableList.add(lineMap);
			}
			System.out.println("讀取成功");

			try {
				// 實作Comparator介面
				Collections.sort(tableList, new Comparator<Map<String, String>>() {

					@Override
					public int compare(Map<String, String> o1, Map<String, String> o2) {
						return -(o1.get("Price").compareTo(o2.get("Price")));
					}

				});
				System.out.println("排序成功");

			} catch (Exception e) {
				System.out.println("排序失敗");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("讀取失敗");

		}

		// write
		String file2Patch = "C:/Users/Admin/Desktop/cars2.csv";
		File file2 = new File(file2Patch);
		try (FileOutputStream fos = new FileOutputStream(file2);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bfw = new BufferedWriter(osw);) {

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

			// write
			try {
				for (Map<String, String> lineMap : tableList) {
					bfw.write(lineMap.get("Manufacturer") + ',');
					bfw.write(lineMap.get("Type") + ',');
					bfw.write(lineMap.get("Min.Price") + ',');
					bfw.write(lineMap.get("Price"));
					bfw.newLine();
				}
				System.out.println("寫入緩衝區成功");
			} catch (Exception e) {
				System.out.println("寫入緩衝區失敗");
				e.printStackTrace();
			}

			// flush：將緩衝區數據刷新到目的文件中
			try {
				bfw.flush();
				System.out.println("刷新成功");
			} catch (Exception e) {
				System.out.println("刷新失敗");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("寫手宣告失敗");
			e.printStackTrace();
		}
	}

}