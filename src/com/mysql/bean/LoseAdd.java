package com.mysql.bean;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class LoseAdd {
	public static void modify(String bookname,int number) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3307/normalinfo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
			String dbUsername="root";
			String dbPassword="123";
			Connection conn=(Connection) DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			String sql="insert into bookloserent values(?,?)";
			//预处理编译sql
	 PreparedStatement  pst=(PreparedStatement) conn.prepareStatement(sql);
	 //设置数据库的五个参数
	pst.setString(1, bookname);
	pst.setInt(2, number);
	pst.executeUpdate();
	
	}catch(ClassNotFoundException e){
	e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	 }
	}
}
