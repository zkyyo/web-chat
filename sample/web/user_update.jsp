<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改个人信息</title>
    <style type="text/css">
        body {
            margin: auto;
            text-align: center
        }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/header_user.jsp" %>

<h1>修改个人信息</h1>

<jsp:include page="WEB-INF/result.jsp">
    <jsp:param name="success" value="信息更新成功"/>
    <jsp:param name="faile" value="信息更新失败, 原因如下:"/>
</jsp:include>

<form method="post" action="user_update.do">
    密码: <input type="password" maxlength="16" name="password"/><br/>
    重复密码: <input type="password" maxlength="16" name="confirmedPsw"/><br/>
    性别: <input type="radio" name="sex" value="male" ${requestScope.user.sex == "male" ? "checked" : ""}/>male
    <input type="radio" name="sex" value="female" ${requestScope.user.sex == "female" ? "checked" : ""}/>female
    <input type="radio" name="sex" value="secret" ${requestScope.user.sex == "secret" ? "checked" : ""}/>secret<br/>
    邮箱: <input type="text" maxlength="255" name="email"
                  value="${requestScope.user.email != null ? requestScope.user.email : ""}"/><br/><br/>
    <input type="submit" value="submit"/>
</form>

</body>
</html>
