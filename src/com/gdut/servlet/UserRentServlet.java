package com.gdut.servlet;

import com.gdut.dao.BookRentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author <a href="mailto:yozyyyqls@163.com">Shelly-Qiu</a>
 * @description 用于管理员根据用户名查询已借书用户
 * @create 2021-01-12
 */
@WebServlet("/UserRentServlet")
public class UserRentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userNameRent = request.getParameter("userName");
        HttpSession session = request.getSession();
        if (userNameRent==null) {
            userNameRent = "";
        }
        session.setAttribute("userNameRent", userNameRent);
        response.sendRedirect("User.jsp");
    }
}
