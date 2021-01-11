package com.mysql.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.bean.ModifyPwd;

/**
 * Servlet implementation class ModifyPwdServlet
 */
@WebServlet("/ModifyPwdServlet")
public class ModifyPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPwdServlet() {
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
		 //获取数据库的用户名和密码
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 ModifyPwd modify=new ModifyPwd();
		 modify.update(username, password);
		//解决中文乱码
		 response.setContentType("text/html; charset=utf-8");
	 PrintWriter out=response.getWriter();
	  out.print("<script>alert('管理员密码修改成功!'); window.location.href='Admini_Main.jsp'</script>");
		 
		 
	}

}
