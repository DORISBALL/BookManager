package com.mysql.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookAddConn {
	public static void modify(int isbn,int price,String author,String publish,String bookname) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3307/normalinfo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
			String dbUsername="root";
			String dbPassword="123";
			Connection conn=(Connection) DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			String sql="insert into book values(?,?,?,?,?)";
			//预处理编译sql
	 PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
	 //设置数据库的五个参数
	pst.setInt(1,isbn);
	pst.setString(2, bookname);
	pst.setInt(3,price);
	pst.setString(4, author);
	pst.setString(5, publish);
	pst.executeUpdate();
	
	}catch(ClassNotFoundException e){
	e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	 }
	}
}
