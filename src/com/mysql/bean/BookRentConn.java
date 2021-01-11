package com.mysql.bean;

import com.mysql.user.User;

import java.sql.*;
import java.util.ArrayList;

public class BookRentConn {
	 //用于存Book
		static	ArrayList<User> list=new ArrayList<User>();
		public static ArrayList<User>  list_return() {
			
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3307/normalinfo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
			String dbUsername="root";
			String dbPassword="123";
			Connection conn=(Connection) DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		
			String sql="select * from bookrentifo ";
			//预处理编译sql
	 PreparedStatement  pst=(PreparedStatement) conn.prepareStatement(sql);
	ResultSet rs=(ResultSet) pst.executeQuery();
	 if(conn!=null)
	 {
		// System.out.print("success!");
	while(rs.next()) {
		//从数据库获取书籍信息
		String user=rs.getString("user");
		String sex=rs.getString("sex");
		String grade =rs.getString("grade");
		String book=rs.getString("book");
		String start=rs.getString("start");
		String end=rs.getString("end");
		//存入到Book类里面
		User bookrent=new User();
		bookrent.setBook(book);
		bookrent.setStart(start);
		bookrent.setEnd(end);
		bookrent.setGrade(grade);
		bookrent.setUser(user);
		bookrent.setSex(sex);
		list.add(bookrent);
	
		

		
	}

	 }

		
	 else{
		 System.out.println("数据库连接失败");
	 }
	}catch(ClassNotFoundException e){
	e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	}
		//将list返回，方便jsp界面调用
		return list;
		}

}
