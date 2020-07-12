<%--
  Created by IntelliJ IDEA.
  User: kpwang
  Date: 2020/7/10
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--常用注解--%>
    <a href="anno/testRequestParam?name=哈哈">常用的注解</a><br>

    <form action="anno/testRequestBody" method="post">

        用户姓名：<input name="username" type="text">
        用户年龄：<input name="age" type="text">
        用户生日：<input name="date" type="text">

        <input type="submit" value="提交">
    </form>
    <a href="anno/testPathVariable/99">testPathVariable</a><br>
    <a href="anno/testCookieValue">testCookieValue</a><br>

    <form action="anno/testModelAttribute" method="post">

        用户姓名：<input name="uname" type="text">
        用户年龄：<input name="age" type="text">

        <input type="submit" value="提交">
    </form>
    <a href="anno/testSessionAttributes">testSessionAttributes</a><br>
    <a href="anno/getSessionAttributes">getSessionAttributes</a><br>
</body>
</html>
