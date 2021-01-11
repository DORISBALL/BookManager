package com.gdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gdut.dao.UserDao;
import com.gdut.dao.AdminDao;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置数据编码，防止插入到mysql乱码
        request.setCharacterEncoding("utf-8");

        String usertype = request.getParameter("usertype");//获取checkbox为管理员还是普通用户
        //获取数据库的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean userFlag = false;
        boolean adminFlag = false;

        if ("1".equals(usertype)) {
            //普通用户页面
            try {
                userFlag = UserDao.check(username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }//System.out.println("flag为"+flag);
            if (userFlag) {
                response.sendRedirect("NormalUser.jsp");
            } else {
                //解决中文乱码
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>alert('密码或账号错误!'); window.location.href='Login.jsp'</script>");
            }
        } else if ("2".equals(usertype)) {
            //管理员页面
            try {
                adminFlag = AdminDao.check(username, password);
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (adminFlag) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("Admini_Main.jsp");
                //在管理界面上显示管理员用户名
            } else {
                //解决中文乱码
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>alert('密码或账号错误!'); window.location.href='Login.jsp'</script>");
            }

        } else {
            //解决中文乱码
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('请选择用户类型'); window.location.href='Login.jsp'</script>");
        }
    }
}
