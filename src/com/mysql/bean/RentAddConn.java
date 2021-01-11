package com.mysql.bean;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class RentAddConn {
	public static void modify(String user,String sex,String grade,String book,String start,String end) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3307/normalinfo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
			String dbUsername="root";
			String dbPassword="123";
			Connection conn=(Connection) DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			String sql="insert into bookrentifo values(?,?,?,?,?,?)";
			//预处理编译sql
	 PreparedStatement  pst=(PreparedStatement) conn.prepareStatement(sql);
	 //设置数据库的五个参数
	pst.setString(1,user);
	pst.setString(2, sex);
	pst.setString(3,grade);
	pst.setString(4, book);
	pst.setString(5, start);
	pst.setString(6, end);
	pst.executeUpdate();
	}catch(ClassNotFoundException e){
	e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	 }
	}
}
