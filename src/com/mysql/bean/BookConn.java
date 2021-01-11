package com.mysql.bean;

import com.mysql.book.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookConn {
	 //用于存Book
	static	ArrayList<Book> list=new ArrayList<Book>();
	public static ArrayList<Book>  list_return() {
		
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl="jdbc:mysql://localhost:3307/normalinfo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
		String dbUsername="root";
		String dbPassword="123";
		Connection conn=(Connection) DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
	
		String sql="select * from book ";
		//预处理编译sql
 PreparedStatement  pst=(PreparedStatement) conn.prepareStatement(sql);
ResultSet rs=(ResultSet) pst.executeQuery();
 if(conn!=null)
 {
	// System.out.print("success!");
while(rs.next()) {
	//从数据库获取书籍信息
	int isbn=rs.getInt("isbn");
	int price=rs.getInt("price");
	String publish =rs.getString("publish");
	String author=rs.getString("author");
	String bookname=rs.getString("bookname");
	//存入到Book类里面
	Book book=new Book();
	book.setIsbn(isbn);
	book.setPrice(price);
	book.setAuthor(author);
	book.setBookname(bookname);
	book.setPublish(publish);
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
