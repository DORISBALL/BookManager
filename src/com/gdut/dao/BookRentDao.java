package com.gdut.dao;

import com.gdut.model.User;

import java.sql.*;
import java.util.ArrayList;

public class BookRentDao {
    //用于存Book
    static ArrayList<User> list = new ArrayList<>();

	public static String TABLE1 = "bookrentinfo";
	public static String TABLE2 = "userinfo";
	public static String ALL_FIELD = "userinfo.userId, sex, username, bookId, start, end";

	/**
	 * 查询所有借阅记录
	 * @return ArrayList<User>
	 */
    public static ArrayList<User> queryHistory() {
		String sql = "select " + ALL_FIELD
				+ " from " + TABLE1 + " join " + TABLE2
				+ " on " + TABLE1+".userId=" + TABLE2+".userId";

        try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					try (ResultSet result = ps.executeQuery()) {
						while (result.next()) {
							//从数据库获取书籍信息
							String userId = result.getString("userId");
							String sex = (String) result.getObject("sex");
							String userName = result.getString("username");
							int bookId = result.getInt("bookId");
							String start = result.getString("start");
							String end = result.getString("end");
							//存入到Book类里面
							User bookrent = new User();
							bookrent.setBookId(bookId);
							bookrent.setStart(start);
							bookrent.setEnd(end);
							bookrent.setUserName(userName);
							bookrent.setUserId(userId);
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
	 * 根据用户ID查找
	 * @param userId
	 * @return
	 */
	public static ArrayList<User> queryHistory(String userId) {
		String sql = "select distinct " + ALL_FIELD
				+ " from " + TABLE1 + " join " + TABLE2
				+ " on " + TABLE1+".userId=" + TABLE2+".userId"
				+ " where userinfo.userId=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					ps.setString(1, userId);
					try (ResultSet result = ps.executeQuery()) {
						while (result.next()) {
							//从数据库获取书籍信息
							String sex = (String) result.getObject("sex");
							String userName = result.getString("username");
							int bookId = result.getInt("bookId");
							String start = result.getString("start");
							String end = result.getString("end");
							//存入到Book类里面
							User bookrent = new User();
							bookrent.setBookId(bookId);
							bookrent.setStart(start);
							bookrent.setEnd(end);
							bookrent.setUserName(userName);
							bookrent.setUserId(userId);
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
	 * @param userId
	 */
	public static void deleteHistory(String userId){
		String sql = "delete "
				+ " from " + TABLE1
				+ " where userId=? ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					ps.setString(1, userId);
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
				+ TABLE1
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
	public static void updateReturn(String end,String userId) {
		String sql = "update "
				+ TABLE1
				+ " set end=? where userId=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
				try (PreparedStatement ps = conn.prepareStatement(sql)) {
					ps.setString(1, end);
					ps.setString(2, userId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
