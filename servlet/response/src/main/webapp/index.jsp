<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/21
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>hello world</h1>
  </body>
  <%--这里提交的路径需要找到项目的路径--%>
  <%--${pageContext.request.contextPath}代表当前的项目--%>
  <form action="${pageContext.request.contextPath}/login" method="get">
    username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    <input type="submit">
  </form>
</html>
