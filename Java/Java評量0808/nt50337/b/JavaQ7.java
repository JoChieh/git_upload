package com.cathaybk.practice.nt50337.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaQ7 {

	public static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String SELECT_SQL = "select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";
	public static final String INSERT_SQL = "insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values(?, ?, ?, ?)";
	public static final String UPDATE_SQL = "update STUDENT.CARS set MIN_PRICE = ?, PRICE = ? where MANUFACTURER = ? and TYPE = ?";
	public static final String DELETE_SQL = "delete from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";

	public static void main(String[] args) {
		System.out.println("請選擇以下指令輸入： select、insert、update、delete");
		Scanner sc = new Scanner(System.in);

		// String input
		String myOrder = sc.nextLine();

		// declare as ""
		String manufacturer = "";
		String type = "";
		String minPrice = "";
		String price = "";

		// get input manufacturer and type
		System.out.print("請輸入製造商：");
		manufacturer = sc.nextLine();
		System.out.print("請輸入類型：");
		type = sc.nextLine();

		// get the rest of values and do myOrder
		switch (myOrder) {
		case "select":
			query(manufacturer, type);
			break;
		case "delete":
			delete(manufacturer, type);
			break;
		case "insert":
			System.out.print("請輸入底價：");
			minPrice = sc.nextLine();
			System.out.print("請輸入售價：");
			price = sc.nextLine();

			Map<String, String> insertMap = new HashMap<>();
			insertMap.put("MANUFACTURER", manufacturer);
			insertMap.put("TYPE", type);
			insertMap.put("MIN_PRICE", minPrice);
			insertMap.put("PRICE", price);

			insert(insertMap);
			break;
		case "update":
			System.out.println("請輸入底價：");
			minPrice = sc.nextLine();
			System.out.println("請輸入售價：");
			price = sc.nextLine();

			Map<String, String> updateMap = new HashMap<String, String>();
			updateMap.put("MANUFACTURER", manufacturer);
			updateMap.put("TYPE", type);
			updateMap.put("MIN_PRICE", minPrice);
			updateMap.put("PRICE", price);
			update(updateMap);
			break;
		}
		
		sc.close();
		
	}

	public static void query(String manufacturer, String type) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");
				PreparedStatement pstmt = conn.prepareStatement(SELECT_SQL);) {
			System.out.println("連線成功");

			// query
			if (!"".equals(manufacturer)) {
				pstmt.setString(1, manufacturer);
			}
			if (!"".equals(type)) {
				pstmt.setString(2, type);
			}
			ResultSet rs = pstmt.executeQuery();

			StringBuilder sb = new StringBuilder();

			while (rs.next()) {
				sb.append("{ MANUFACTURER： ").append(rs.getString(1)).append("   TYPE：").append(rs.getString(2))
						.append("   MIN_PRICE：").append(rs.getString(3)).append("   PRICE：").append(rs.getString(4))
						.append(" }");
				System.out.println(sb.toString());
				sb.setLength(0);
			}

			System.out.println("Select成功");
		} catch (Exception e) {
			System.out.println("Select失敗");
			e.printStackTrace();
		}

	}

	public static void insert(Map<String, String> insertMap) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");) {
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);) {
				System.out.println("連線成功");

				// check if any value is empty
				for (String value : insertMap.values()) {
					if ("".equals(value)) {
						throw new Exception("insert值須填滿");
					}
				}

				// insert
				conn.setAutoCommit(false);
				pstmt.setString(1, insertMap.get("MANUFACTURER"));
				pstmt.setString(2, insertMap.get("TYPE"));
				pstmt.setDouble(3, Double.valueOf(insertMap.get("MIN_PRICE")));
				pstmt.setInt(4, Integer.valueOf(insertMap.get("PRICE")));
				pstmt.executeUpdate();
				conn.commit();

				System.out.println("Insert成功");

			} catch (Exception e) {
				System.out.println("Insert失敗");

				// rollback
				try {
					conn.rollback();
					System.out.println("Rollback成功");
				} catch (SQLException sqle) {
					System.out.println("Rollback失敗");
					sqle.printStackTrace();
				}

				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("連線失敗");
			e.printStackTrace();
		}

	}

	public static void update(Map<String, String> updateMap) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");) {
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL);) {
				System.out.println("連線成功");

				// update
				conn.setAutoCommit(false);
				// set
				if(!"".equals(updateMap.get("MIN_PRICE"))) {
					pstmt.setDouble(1, Double.valueOf(updateMap.get("MIN_PRICE")));
				}
				if(!"".equals(updateMap.get("PRICE"))) {
					pstmt.setInt(2, Integer.valueOf(updateMap.get("PRICE")));
				}
				// where
				pstmt.setString(3, updateMap.get("MANUFACTURER"));
				pstmt.setString(4, updateMap.get("TYPE"));

				pstmt.executeUpdate();
				conn.commit();

				System.out.println("Update成功");
			} catch (Exception e) {
				System.out.println("Update失敗");

				// rollback
				try {
					conn.rollback();
					System.out.println("Rollback成功");
				} catch (SQLException sqle) {
					System.out.println("Rollback失敗");
					sqle.printStackTrace();
				}

				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("連線失敗");
			e.printStackTrace();
		}
	}

	public static void delete(String manufacturer, String type) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");) {
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL);) {
				System.out.println("連線成功");
				// delete
				conn.setAutoCommit(false);
				if (!"".equals(manufacturer)) {
					pstmt.setString(1, manufacturer);
				}
				if (!"".equals(type)) {
					pstmt.setString(2, type);
				}
				pstmt.executeUpdate();
				conn.commit();

				System.out.println("Delete成功");

			} catch (Exception e) {
				System.out.println("Delete失敗");

				// rollback
				try {
					conn.rollback();
					System.out.println("Rollback成功");
				} catch (SQLException sqle) {
					System.out.println("Rollback失敗");
					sqle.printStackTrace();
				}
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("連線失敗");
			e.printStackTrace();
		}
	}
}
