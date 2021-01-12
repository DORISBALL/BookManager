package com.gdut.dao;

import com.gdut.model.UserInfo;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class UserDao {
	public static String TABLE = "userinfo";
	public static String ALL_FIELD = "userId, password";

	public static boolean check(String userId,String password) throws ClassNotFoundException {
		boolean checkOK = false;
		Class.forName("com.mysql.jdbc.Driver");
		String sql = "select " + ALL_FIELD + " from " + TABLE + " where userId=? and password=?";
		try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
			//预处理编译sql
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				//设置数据库的两个参数
				ps.setString(1, userId);
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

	public static void addUser(String userId, String password) {
		String sql = "insert into "
				+ TABLE
				+ " values(?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					//设置添加用户信息
					ps.setString(1, userId);
					ps.setString(2, password);
					ps.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static UserInfo queryUserInfo(String userId, String password) {
		UserInfo userInfo = new UserInfo();
		String sql = "select * from userinfo where userId=? and password=?";
		try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, userId);
				ps.setString(2, password);
				try (ResultSet result = ps.executeQuery()) {
					if (result.next()) {
						userInfo.setUsername(result.getString("username"));
						userInfo.setUserId(userId);
						userInfo.setAccount(result.getFloat("acount"));
						userInfo.setAge(result.getInt("age"));
						String sex = result.getString("sex");
						//当用户未填写性别时
						if (sex==null) {
							userInfo.setSex("未知");
						} else {
							userInfo.setSex(sex);
						}

					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	public static String queryUserName(String userId, String password) {
		String userName = "";
		String sql = "select username from " + TABLE
				+ " where userId=? and password=?";

		try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, userId);
				ps.setString(2, password);
				try (ResultSet result = ps.executeQuery()){
					if (result.next()) {
						userName = result.getString("username");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userName;
	}

	public static void updatePwd(String userId, String newPassword) {
		String sql = "update " + TABLE
				+ " set " + "password=? "
				+ "where userId=?";

		try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, newPassword);
				ps.setString(2, userId);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
