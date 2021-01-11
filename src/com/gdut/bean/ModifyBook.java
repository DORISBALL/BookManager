package com.gdut.bean;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class ModifyBook {
	public static void modify(int isbn,int price,String author,String publish,String bookname) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3307/normalinfo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
			String dbUsername="root";
			String dbPassword="123";
			Connection conn=(Connection) DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			String sql="update book set isbn=?,price=?,author=?,publish=? where bookname=? ";
			//预处理编译sql
	 PreparedStatement  pst=(PreparedStatement) conn.prepareStatement(sql);
	 //设置数据库的五个参数
	pst.setInt(1,isbn);
	pst.setInt(2,price);
	pst.setString(3, author);
	pst.setString(4, publish);
	pst.setString(5, bookname);
	pst.executeUpdate();
	}catch(ClassNotFoundException e){
	e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	 }
	}
}
