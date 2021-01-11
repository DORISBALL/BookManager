package com.gdut.dao;

import com.gdut.book.BookLose;

import java.sql.*;
import java.util.ArrayList;


public class BookLoseConn {
	 //用于存BookLose
		static	ArrayList<BookLose> list=new ArrayList<BookLose>();
		public static ArrayList<BookLose>  list_return() {
			
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3307/normalinfo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
			String dbUsername="root";
			String dbPassword="123";
			Connection conn=(Connection) DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		
			String sql="select * from bookloserent ";
			//预处理编译sql
	 PreparedStatement  pst=(PreparedStatement) conn.prepareStatement(sql);
	ResultSet rs=(ResultSet) pst.executeQuery();
	 if(conn!=null)
	 {
		// System.out.print("success!");
	while(rs.next()) {
		//从数据库获取书籍信息
		int number=rs.getInt("number");
		String booklose=rs.getString("booklose");
		//存入到Book类里面
    BookLose book=new BookLose();
    book.setNumber(number);
  book.setBooklose(booklose);
	list.add(book);
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
