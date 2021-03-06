<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.user.username}的档案</title>
    <style type="text/css">
        body {
            margin: auto;
            text-align: center
        }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/header_admin.jsp" %>

<h1>${requestScope.user.username}的档案</h1>

<h2>个人</h2>
<table border="1" align="center">
    <tr>
        <th>用户名</th>
        <td>${requestScope.user.username}</td>
    </tr>
    <tr>
        <th>性别</th>
        <td>${requestScope.user.sex}</td>
    </tr>
    <tr>
        <th>邮箱</th>
        <td>${requestScope.user.email}</td>
    </tr>
    <tr>
        <th>状态</th>
        <td>${requestScope.user.statusStr}</td>
    </tr>
    <tr>
        <th>注册时间</th>
        <td>${requestScope.user.created}</td>
    </tr>
</table>

<h2>小组</h2>
<c:forEach var="group" items="${requestScope.groups}">
    <table border="1" align="center">
        <tr>
            <th>小组名</th>
            <td>${group.key.name}</td>
        </tr>
        <tr>
            <th>描述</th>
            <td>${group.key.description}</td>
        </tr>
        <tr>
            <th>授权访问</th>
            <td>
                <table border="1" align="center">
                    <tr>
                        <th>title</th>
                        <th>created</th>
                    </tr>
                    <c:forEach var="topic" items="${group.value}">
                        <%--参与讨论区--%>
                        <c:url value="topic_chat_info.do" var="topicUrl">
                            <c:param name="topicId" value="${topic.topicId}"/>
                        </c:url>
                        <tr>
                            <td><a href="${topicUrl}">${topic.title}</a></td>
                            <td>${topic.created}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
    <br/>
</c:forEach>
</body>
</html>
