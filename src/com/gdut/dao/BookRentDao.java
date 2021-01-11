package com.gdut.dao;

import com.gdut.user.User;

import java.sql.*;
import java.util.ArrayList;

public class BookRentDao {
    //用于存Book
    static ArrayList<User> list = new ArrayList<>();

	public static String TABLE = "bookrentifo";
	public static String ALL_FIELD = "user, sex, grade, book, start, end";

    public static ArrayList<User> list_return() {
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

}
