package com.gdut.bean;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class Conn1 {
	
	public static  boolean  check(String username,String password) {
		boolean checkOK = false;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl="jdbc:mysql://localhost:3307/normalinfo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
		String dbUsername="root";
		String dbPassword="123";
		Connection conn=(Connection) DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
	
		String sql="select * from admininfo where username=? and password=?";
		//预处理编译sql
 PreparedStatement  pst=(PreparedStatement) conn.prepareStatement(sql);
 //设置数据库的两个参数
pst.setString(1, username);
pst.setString(2, password);
ResultSet rs=(ResultSet) pst.executeQuery();
 if(conn!=null)
 {
	// System.out.print("success!");
if(rs.next()){
	//查询到就true
	checkOK=true;
	
	 conn.close();
}
 else{
	   
	   checkOK=false;
	   
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
return checkOK;
	}
}
