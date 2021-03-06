package com.zkyyo.www.web.controller;

import com.zkyyo.www.service.RememberService;
import com.zkyyo.www.util.CookieUtil;
import com.zkyyo.www.web.Access;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 该Servlet用于处理用户注销, 取消自动登录的请求
 */
@WebServlet(
        name = "LogoutServlet",
        urlPatterns = {"/logout.do"}
)
public class LogoutServlet extends HttpServlet {
    private String LOGIN_COOKIE_NAME;

    public void init() throws ServletException {
        LOGIN_COOKIE_NAME = (String) getServletContext().getAttribute("loginCookieName");
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //移除Cookie
        Access access = (Access) request.getSession().getAttribute("access");
        if (access != null) {
            RememberService rememberService = (RememberService) getServletContext().getAttribute("rememberService");
            rememberService.delete(access.getUsername());
            CookieUtil.removeCookie(response, LOGIN_COOKIE_NAME);
        }
        //移除Session
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
