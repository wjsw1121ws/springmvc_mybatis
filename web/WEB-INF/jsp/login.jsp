<%--
  Created by IntelliJ IDEA.
  User: changchun_wu
  Date: 2018/12/3
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.action" method="post">
    用户名:<input type="text" name="username" value="fsaa"/>
    <input type="submit" value="提交">
</form>
</body>
</html>
