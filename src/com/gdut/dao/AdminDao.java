package com.gdut.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class AdminDao {
	public static String TABLE = "admininfo";
	public static String ALL_FIELD = "adminId, password";

	//判断管理员登录
	public static boolean check(String adminId,String password) throws ClassNotFoundException {
		boolean checkOK = false;
		Class.forName("com.mysql.jdbc.Driver");
		String sql = "select " + ALL_FIELD +
				" from " + TABLE +
				" where adminId=? and password=?";
		try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD);) {
			//预处理编译sql
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				//设置数据库的两个参数
				ps.setString(1, adminId);
				ps.setString(2, password);
				try (ResultSet result = ps.executeQuery()) {
					checkOK = result.next();
				}
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return checkOK;
	}

	//添加管理员
	public static void addAdmin(String adminId, String password) {
		String sql = "insert into "
				+ TABLE
				+ " values(?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					//设置添加管理员信息
					ps.setString(1, adminId);
					ps.setString(2, password);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//更新密码
	public static void updatePwd(String adminId, String password) {
		String sql = "update "
				+ TABLE
				+ " set password=? where adminId=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					ps.setString(1, password);
					ps.setString(2, adminId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String queryAdminName(String userId, String password) {
		String adminName = "";
		String sql = "select adminName from " + TABLE
				+ " where adminId=? and password=?";

		try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, userId);
				ps.setString(2, password);
				try (ResultSet result = ps.executeQuery()){
					if (result.next()) {
						adminName = result.getString("adminName");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminName;
	}
}
