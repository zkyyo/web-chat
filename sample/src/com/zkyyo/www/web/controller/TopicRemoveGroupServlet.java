package com.zkyyo.www.web.controller;

import com.zkyyo.www.service.GroupService;
import com.zkyyo.www.service.TopicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 该Servlet用于处理从讨论区移除小组的请求
 */
@WebServlet(
        name = "TopicRemoveGroupServlet",
        urlPatterns = {"/topic_remove_group.do"}
)
public class TopicRemoveGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupId = request.getParameter("groupId"); //待移除的小组ID
        String topicId = request.getParameter("topicId"); //讨论区ID

        String url = "admin_index.jsp";
        GroupService groupService = (GroupService) getServletContext().getAttribute("groupService");
        TopicService topicService = (TopicService) getServletContext().getAttribute("topicService");
        //判断小组ID, 讨论区ID是否合法
        if (groupService.isValidId(groupId) && topicService.isValidId(topicId)) {
            int gId = Integer.valueOf(groupId);
            int tId = Integer.valueOf(topicId);
            //判断小组是否存在
            if (groupService.isExisted(gId)) {
                url = "topic_detail.do?topicId=" + topicId;
                //判断讨论区是否存在
                if (topicService.isExisted(tId)) {
                    groupService.removeTopic(gId, tId);
                }
            }
        }
        response.sendRedirect(url);
    }
}
