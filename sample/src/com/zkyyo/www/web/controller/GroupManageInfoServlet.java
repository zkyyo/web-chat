package com.zkyyo.www.web.controller;

import com.zkyyo.www.bean.po.GroupPo;
import com.zkyyo.www.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 该Servlet用于处理获得所有小组信息的请求
 */
@WebServlet(
        name = "GroupManageInfoServlet",
        urlPatterns = {"/group_manage_info.do"}
)
public class GroupManageInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupService groupService = (GroupService) getServletContext().getAttribute("groupService");
        //获取所有小组信息
        List<GroupPo> groups = groupService.queryGroups();
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("group_manage.jsp").forward(request, response);
    }
}
