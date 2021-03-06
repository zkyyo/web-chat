<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建讨论区</title>
    <style type="text/css">
        body {
            margin: auto;
            text-align: center
        }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/header_admin.jsp" %>

<h1>创建讨论区</h1>

<jsp:include page="WEB-INF/result.jsp">
    <jsp:param name="success" value="讨论区创建成功"/>
    <jsp:param name="faile" value="讨论区创建失败, 原因如下:"/>
</jsp:include>

<form method="post" action="topic_add.do">
    标题: <input type="text" maxlength="60" size="80" name="title" placeholder="请输入标题" value="${requestScope.title}"/><br/>
    描述: <textarea name="description" rows="15" cols="80" maxlength="255"
                  placeholder="(可选)">${requestScope.description}</textarea><br/>
    <input type="radio" name="type" value="public" ${requestScope.type == "public" ? "checked" : ""}>公开
    <input type="radio" name="type" value="private" ${requestScope.type == "private" ? "checked" : ""}>授权
    <br/><br/>
    <input type="submit" value="发布"/>
</form>

</body>
</html>
