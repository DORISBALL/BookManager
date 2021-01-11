package com.mysql.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.bean.BookLoseConn;
import com.mysql.bean.BookRentConn;
import com.mysql.bean.LoseAdd;
import com.mysql.bean.ModifyBook;
import com.mysql.bean.RentAddConn;

/**
 * Servlet implementation class AddRentServlet
 */
@WebServlet("/AddRentServlet")
public class AddRentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRentServlet() {
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
				//获取到要添加借阅的信息
				 String bookname=request.getParameter("bookname");
				int number=Integer.parseInt(request.getParameter("number")) ;
				LoseAdd lose=new LoseAdd();
				lose.modify(bookname, number);
				//解决中文乱码
				 response.setContentType("text/html; charset=utf-8");
			 PrintWriter out=response.getWriter();
			  out.print("<script>alert('已成功添加丢失书籍')</script>");
	}

}
