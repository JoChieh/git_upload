package com.cathaybk.practice.nt50337.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaQ7New {

	public static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USERNAME = "student";
	public static final String PASSWORD = "student123456";
	public static final String SELECT_SQL = "select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";
	public static final String INSERT_SQL = "insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values(?, ?, ?, ?)";
	public static final String UPDATE_SQL = "update STUDENT.CARS set MIN_PRICE = ?, PRICE = ? where MANUFACTURER = ? and TYPE = ?";
	public static final String DELETE_SQL = "delete from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";

	public static void main(String[] args) {
		System.out.println("請選擇以下指令輸入： select、insert、update、delete");
		Scanner sc = new Scanner(System.in);

		// String input
		String myOrder = sc.nextLine();

		String[] getManufacturerType;
		String minPrice = "";
		String price = "";

		// get the rest of values and do myOrder
		switch (myOrder) {
		case "insert":
			getManufacturerType = getManufacturerTypeInput(sc);
			System.out.print("請輸入底價：");
			minPrice = sc.nextLine();
			System.out.print("請輸入售價：");
			price = sc.nextLine();

			Map<String, String> insertMap = new HashMap<>();
			insertMap.put("MANUFACTURER", getManufacturerType[0]);
			insertMap.put("TYPE", getManufacturerType[1]);
			insertMap.put("MIN_PRICE", minPrice);
			insertMap.put("PRICE", price);

			insert(insertMap);
			break;
		case "update":
			getManufacturerType = getManufacturerTypeInput(sc);
			System.out.print("請輸入底價：");
			minPrice = sc.nextLine();
			System.out.print("請輸入售價：");
			price = sc.nextLine();

			Map<String, String> updateMap = new HashMap<>();
			updateMap.put("MANUFACTURER", getManufacturerType[0]);
			updateMap.put("TYPE", getManufacturerType[1]);
			updateMap.put("MIN_PRICE", minPrice);
			updateMap.put("PRICE", price);
			update(updateMap);
			break;
		case "select":
			getManufacturerType = getManufacturerTypeInput(sc);
			query(getManufacturerType[0], getManufacturerType[1]);
			break;
		case "delete":
			getManufacturerType = getManufacturerTypeInput(sc);
			delete(getManufacturerType[0], getManufacturerType[1]);
			break;
		default:
			System.out.println("輸入錯誤的指令，請重新執行程式");
			break;
		}

		sc.close();

	}

	public static void query(String manufacturer, String type) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SELECT_SQL);) {

			// query
			if ("".equals(manufacturer) || "".equals(type)) {
				throw new Exception("未輸入待查詢的資訊，請重新執行一次");
			} else {
				pstmt.setString(1, manufacturer);
				pstmt.setString(2, type);
			}

			ResultSet rs = pstmt.executeQuery();

			StringBuilder sb = new StringBuilder();
			if (!rs.isBeforeFirst()) {
				throw new Exception("輸入不存在於表格的資訊，請重新執行一次");
			}

			while (rs.next()) {
				sb.append("{ MANUFACTURER： ").append(rs.getString("MANUFACTURER")).append("   TYPE：")
						.append(rs.getString("TYPE")).append("   MIN_PRICE：").append(rs.getString("MIN_PRICE"))
						.append("   PRICE：").append(rs.getString("PRICE")).append(" }");
				System.out.println(sb.toString());
				sb.setLength(0);
			}
			rs.close();
		} catch (Exception e) {
			System.err.println("select失敗：" + e.getMessage());
		}

	}

	public static void insert(Map<String, String> insertMap) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);) {
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);) {

				String manufacturer = insertMap.get("MANUFACTURER");
				String type = insertMap.get("TYPE");
				String minPrice = insertMap.get("MIN_PRICE");
				String price = insertMap.get("PRICE");

				if ("".equals(manufacturer) || "".equals(type) || "".equals(type) || "".equals(type)) {
					throw new Exception("insert值須填滿，請重新執行一次");
				}

				// insert
				conn.setAutoCommit(false);

				try {
					pstmt.setDouble(3, Double.parseDouble(minPrice));
					pstmt.setDouble(4, Double.parseDouble(price));
				} catch (NumberFormatException nfe) {
					throw new NumberFormatException("輸入的售價或底價並非數字，請重新執行一次");
				}

				pstmt.setString(1, insertMap.get("MANUFACTURER"));
				pstmt.setString(2, insertMap.get("TYPE"));
				pstmt.executeUpdate();
				conn.commit();
				System.out.println("Insert成功");
			} catch (Exception e) {
				System.err.println("Insert失敗：" + e.getMessage());

				try {
					conn.setAutoCommit(false);
					conn.rollback();
				} catch (SQLException sqle) {
					System.err.println("Rollback失敗" + sqle.getMessage());
				}
			}
		} catch (Exception e) {
			System.err.println("連線失敗");
		}

	}

	public static void update(Map<String, String> updateMap) {
		
			String manufacturer = updateMap.get("MANUFACTURER");
			String type = updateMap.get("TYPE");
			double minPrice = 0;
			double price = 0;
			boolean minPriceEmpty = false;
			boolean priceEmpty = false;

			// Step 1: check input, wrong then end the method
			try {
				// where empty
				if ("".equals(manufacturer) || "".equals(type)) {
					throw new Exception("未輸入待更新資料的廠商或型號，請重新執行一次");
				}
				String minPriceString = updateMap.get("MIN_PRICE");
				String priceString = updateMap.get("PRICE");
				minPriceEmpty = "".equals(minPriceString);
				priceEmpty = "".equals(priceString);
				// set empty
				if (minPriceEmpty && priceEmpty) {
					throw new Exception("未輸入待更新資料的底價及售價，請重新執行一次");
				}
				// set
				if (!minPriceEmpty) {
					minPrice = Double.parseDouble(minPriceString);
				}
				if (!priceEmpty) {
					price = Double.parseDouble(priceString);
				}
			} catch (NumberFormatException nfe) {
				throw new NumberFormatException("輸入的售價或底價並非數字，請重新執行一次");
			} catch (Exception e) {
				System.err.println("連線失敗：" + e.getMessage());
			}

			// Step 2: Combine UPDATE_SQL
			StringBuilder sb = new StringBuilder();
			sb.append("update STUDENT.CARS set");
			if (!minPriceEmpty && !priceEmpty) {
				sb.append("MIN_PRICE = ?, PRICE = ? ");
			} else if (minPriceEmpty) {
				sb.append("PRICE = ? ");
			} else if (priceEmpty) {
				sb.append("MIN_PRICE = ? ");
			}
			String sqlString = sb.append(" where MANUFACTURER = ? and TYPE = ?").toString();

			// Step 3: Connect DB
			try (Connection conn = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD)) {
				conn.setAutoCommit(false);
				try (PreparedStatement pstmt = conn.prepareStatement(sqlString)) {
					if (!minPriceEmpty && !priceEmpty) {
						pstmt.setDouble(1, minPrice);
						pstmt.setDouble(2, price);
					}
					if (minPriceEmpty) {
						pstmt.setDouble(1, price);
					}
					if (priceEmpty) {
						pstmt.setDouble(2, minPrice);
					}
					pstmt.setString(3, manufacturer);
					pstmt.setString(4, type);

					int row = pstmt.executeUpdate();
					System.err.println("update row: " + row);
					conn.commit();
					if (row == 0) {
						System.err.println("Nothing update");
						return;
					}
					System.out.println("Update成功");
				} catch (SQLException sqle) {
					System.err.println("Update失敗：" + sqle.getMessage());
					conn.rollback();
				}
			} catch (Exception e) {
				System.err.println("連線失敗：" + e.getMessage());
			}
		

	}

	public static void delete(String manufacturer, String type) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);) {
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL);) {
				// delete
				conn.setAutoCommit(false);
				if ("".equals(manufacturer) || "".equals(type)) {

					throw new Exception("未輸入待刪除的資訊，請重新執行一次");
				} else {
					pstmt.setString(1, manufacturer);
					pstmt.setString(2, type);
				}

				if (pstmt.executeUpdate() != 0) {
					pstmt.executeUpdate();
				} else {
					throw new Exception("表格中找不到您輸入的資料，請重新執行一次");
				}
				System.out.println("Update成功");
				conn.commit();

			} catch (Exception e) {
				System.err.println("Delete失敗：" + e.getMessage());

				try {
					conn.rollback();
				} catch (SQLException sqle) {
					System.err.println("Rollback失敗：" + sqle.getMessage());
					sqle.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.err.println("連線失敗：" + e.getMessage());
		}
	}

	public static String[] getManufacturerTypeInput(Scanner sc) {
		String[] getManufacturerType = new String[2];
		System.out.print("請輸入製造商：");
		getManufacturerType[0] = sc.nextLine();
		System.out.print("請輸入類型：");
		getManufacturerType[1] = sc.nextLine();
		return getManufacturerType;
	}
}
