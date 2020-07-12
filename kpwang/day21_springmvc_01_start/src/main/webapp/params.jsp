<%--
  Created by IntelliJ IDEA.
  User: kpwang
  Date: 2020/7/10
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--请求参数绑定--%>
    <%--<a href="param/testParam?username=hehe&password=123">请求参数绑定</a>--%>
    <%--<form action="param/saveAccount" method="post">
        姓名：<input name="username" type="text">
        密码：<input name="password" type="password">
        金额：<input name="money" type="text">
        用户姓名：<input name="user.uname" type="text">
        用户年龄：<input name="user.age" type="text">
        <input type="submit" value="提交">
    </form>--%>
    <%--<form action="param/saveAccount" method="post">
        姓名：<input name="username" type="text">
        密码：<input name="password" type="password">
        金额：<input name="money" type="text">

        用户姓名：<input name="list[0].uname" type="text">
        用户年龄：<input name="list[0].age" type="text">

        用户姓名：<input name="map['one'].uname" type="text">
        用户年龄：<input name="map['one'].age" type="text">
        <input type="submit" value="提交">
    </form>--%>
    <%--<form action="param/saveUser" method="post">

        用户姓名：<input name="uname" type="text">
        用户年龄：<input name="age" type="text">
        用户生日：<input name="date" type="text">

        <input type="submit" value="提交">
    </form>--%>
    <a href="param/testServlet">servlet原生api</a>
</body>
</html>
