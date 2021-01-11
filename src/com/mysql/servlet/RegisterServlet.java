package com.mysql.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.bean.RegisterConn;
import com.mysql.bean.RegisterConn2;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置数据编码，防止插入到mysql乱码
				request.setCharacterEncoding("utf-8");
		
		String usertype= request.getParameter("usertype");//获取checkbox为管理员还是普通用户
		 //获取数据库的用户名和密码
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 
		 
		 
			//普通用户页面
			 if ("1".equals(usertype)) { 
				 System.out.print(username+"  "+password);
				 RegisterConn con=new RegisterConn();
				 con.exec(username, password);
				 //解决中文乱码
				 response.setContentType("text/html; charset=utf-8");
	    	 PrintWriter out=response.getWriter();
	    	  out.print("<script>alert('用户注册成功!'); window.location.href='Login.jsp'</script>");
				
			       
			   } else if ("2".equals(usertype)) {
				   //管理员页面
				   System.out.print(username+"  "+password);
					 RegisterConn2 con=new RegisterConn2();
					 con.exec(username, password);
					 //解决中文乱码
					 response.setContentType("text/html; charset=utf-8");
		    	 PrintWriter out=response.getWriter();
		    	  out.print("<script>alert('管理员用户注册成功!'); window.location.href='Login.jsp'</script>");
			       
			
		}

		 
	}

}
