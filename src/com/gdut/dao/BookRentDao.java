package com.gdut.dao;

import com.gdut.user.User;

import java.sql.*;
import java.util.ArrayList;

public class BookRentDao {
    //用于存Book
    static ArrayList<User> list = new ArrayList<>();

	public static String TABLE = "bookrentifo";
	public static String ALL_FIELD = "user, sex, grade, book, start, end";

	/**
	 * 查询所有借阅记录
	 * @return ArrayList<User>
	 */
    public static ArrayList<User> queryHistory() {
		String sql = "select " + TABLE
				+ " from " + ALL_FIELD;

        try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					try (ResultSet result = (ResultSet) ps.executeQuery()) {
						while (result.next()) {
							//从数据库获取书籍信息
							String user = result.getString("user");
							String sex = result.getString("sex");
							String grade = result.getString("grade");
							String book = result.getString("book");
							String start = result.getString("start");
							String end = result.getString("end");
							//存入到Book类里面
							User bookrent = new User();
							bookrent.setBook(book);
							bookrent.setStart(start);
							bookrent.setEnd(end);
							bookrent.setGrade(grade);
							bookrent.setUser(user);
							bookrent.setSex(sex);
							list.add(bookrent);
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
        	e.printStackTrace();
		}
        //将list返回，方便jsp界面调用
        return list;
    }

	/**
	 * 删除借阅记录
	 * @param username
	 */
	public static void deleteHistory(String username){
		String sql = "delete "
				+ " from " + TABLE
				+ " where username=? ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					ps.setString(1, username);
					ps.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加借阅记录
	 */
	public static void addHistory(String user,String sex,String grade,String book,String start,String end){
		String sql = "insert into "
				+ TABLE
				+ " values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					//设置数据库的五个参数
					ps.setString(1, user);
					ps.setString(2, sex);
					ps.setString(3, grade);
					ps.setString(4, book);
					ps.setString(5, end);
					ps.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新归还时间
	 */
	public static void updateReturn(String end,String name) {
		String sql = "update "
				+ TABLE
				+ "set end=? where user=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					ps.setString(1, end);
					ps.setString(2, name);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
