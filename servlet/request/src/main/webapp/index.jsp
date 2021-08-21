<html>
<head>
    <title>Login</title>
</head>

<body>

    <div style="text-align: center">
        <h1>Login</h1>

        <%-- 以 post 的方式提交表单，提交到 login 请求 --%>
        <form action="${pageContext.request.contextPath}/login" method="post">
            username: <input type="text" name="username"> <br>
            password: <input type="password" name="password"> <br>
            <input type="submit">
        </form>
    </div>

</body>
</html>
