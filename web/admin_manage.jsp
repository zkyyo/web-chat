<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin manage</title>
</head>
<body>

<%@ include file="/WEB-INF/header_admin.jsp" %>

<div style="text-align: right">
    <a href="admin_find.jsp">加冕管理员</a>
</div>

<h1>admin manage</h1>

<c:if test="${requestScope.users == null}">
    <c:redirect url="admin_manage_info.do"/>
</c:if>

<table border="1">
    <tr>
        <th>username</th>
        <th>sex</th>
        <th>status</th>
    </tr>
    <c:forEach var="user" items="${requestScope.users}">
        <c:url value="admin_delete.do" var="deleteAdminUrl">
            <c:param name="userId" value="${user.userId}"/>
        </c:url>
        <tr>
            <td>${user.username}</td>
            <td>${user.sex}</td>
            <td>${user.statusStr}</td>
            <c:if test="${sessionScope.access.userId != user.userId}">
                <td><a href="${deleteAdminUrl}">撤销管理员</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>


</body>
</html>
