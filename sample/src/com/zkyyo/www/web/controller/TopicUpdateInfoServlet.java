package com.zkyyo.www.web.controller;

import com.zkyyo.www.bean.po.TopicPo;
import com.zkyyo.www.service.TopicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 该Servlet用于处理获取讨论区更新前数据的请求
 */
@WebServlet(
        name = "TopicUpdateInfoServlet",
        urlPatterns = {"/topic_update_info.do"}
)
public class TopicUpdateInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String topicId = request.getParameter("topicId"); //讨论区ID

        TopicService topicService = (TopicService) getServletContext().getAttribute("topicService");
        //判断讨论区ID是否合法
        if (topicService.isValidId(topicId)) {
            int tId = Integer.valueOf(topicId);
            //判断讨论区是否存在
            if (topicService.isExisted(tId)) {
                TopicPo topic = topicService.findTopic(tId);
                request.setAttribute("topic", topic);
                request.getRequestDispatcher("topic_update.jsp").forward(request, response);
                return;
            }
        }
        response.sendRedirect("index.jsp");
    }
}
