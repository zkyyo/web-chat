package com.zkyyo.www.web.controller;

import com.zkyyo.www.bean.po.UserPo;
import com.zkyyo.www.service.UserService;
import com.zkyyo.www.web.Access;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 该Servlet用于处理获取用户更新前信息的请求
 */
@WebServlet(
        name = "UserUpdateInfoServlet",
        urlPatterns = {"/user_update_info.do"}
)
public class UserUpdateInfoServlet extends HttpServlet {
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Access access = (Access) request.getSession().getAttribute("access"); //操作者权限对象
        int userId = access.getUserId();

        UserService userService = (UserService) getServletContext().getAttribute("userService");
        //获取用户信息
        UserPo user = userService.findUser(userId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("user_update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
