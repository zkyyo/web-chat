package com.zkyyo.www.web.controller;

import com.zkyyo.www.bean.po.TopicPo;
import com.zkyyo.www.service.TopicService;
import com.zkyyo.www.web.Access;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * 该Servlet用于处理操作者获取授权讨论区的请求
 */
@WebServlet(
        name = "TopicFindPrivateServlet",
        urlPatterns = {"/topic_find_private.do"}
)
public class TopicFindPrivateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Access access = (Access) request.getSession().getAttribute("access"); //权限对象
        Set<Integer> groups = access.getGroups();

        TopicService topicService = (TopicService) getServletContext().getAttribute("topicService");
        Set<TopicPo> topics = topicService.queryTopicsByGroups(groups);
        request.setAttribute("topics", topics);
        request.getRequestDispatcher("topic_private.jsp").forward(request, response);
    }
}
