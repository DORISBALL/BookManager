package com.gdut.servlet;

import com.gdut.dao.AdminDao;
import com.gdut.dao.UserDao;
import com.gdut.model.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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

        //获取session
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

        //获取数据库的用户名和密码
        String userId = userInfo.getUserId();
        String newPassword = request.getParameter("newPassword");

        //修改用户密码
        UserDao.updatePwd(userId,newPassword);

        //解决中文乱码
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<script>alert('密码修改成功!');</script>");


    }

}
