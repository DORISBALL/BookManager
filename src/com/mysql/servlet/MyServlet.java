package com.mysql.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.bean.Conn;
import com.mysql.bean.Conn1;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
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
			 Conn con=new Conn();
			boolean flag= con.check(username, password);
			//System.out.println("flag为"+flag);
			 if(flag) {
		       response.sendRedirect("NormalUser.jsp");}else {
		    	   //解决中文乱码
					 response.setContentType("text/html; charset=utf-8");
		    	 PrintWriter out=response.getWriter();
		    	  out.print("<script>alert('密码或账号错误!'); window.location.href='Login.jsp'</script>");
		       }
			
		       
		   } else if ("2".equals(usertype)) {
			   //管理员页面
			   System.out.print(username+"  "+password);
			   Conn1 con=new Conn1();
			   boolean flag1=Conn1.check(username, password);
				System.out.println("flag为"+flag1);
				 if(flag1) {
					 HttpSession session=request.getSession();
						session.setAttribute("username", username);
					 response.sendRedirect("Admini_Main.jsp");
					 //在管理界面上显示管理员用户名
					
					 }else {
						 //解决中文乱码
						 response.setContentType("text/html; charset=utf-8");
			    	 PrintWriter out=response.getWriter();
			    	  out.print("<script>alert('密码或账号错误!'); window.location.href='Login.jsp'</script>");
			       }
		       
		
	}else {
		//解决中文乱码
		 response.setContentType("text/html; charset=utf-8");
	 PrintWriter out=response.getWriter();
	  out.print("<script>alert('请选择用户类型'); window.location.href='Login.jsp'</script>");
	}

}
}
