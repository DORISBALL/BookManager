package com.gdut.servlet;

import com.gdut.dao.BookRentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ModifyuserServlet
 */
@WebServlet("/ModifyuserServlet")
public class ModifyuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyuserServlet() {
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
		//获取到要添加书籍的信息
		 String name=request.getParameter("name");
		 String end=request.getParameter("end");
		
		BookRentDao bookRentDao = new BookRentDao();
		bookRentDao.updateReturn(end,name);
		
		//解决中文乱码
		 response.setContentType("text/html; charset=utf-8");
	 PrintWriter out=response.getWriter();
	  out.print("<script>alert('已经成功延期')</script>");
	}

}
