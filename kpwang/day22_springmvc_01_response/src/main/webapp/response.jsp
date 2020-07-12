<%--
  Created by IntelliJ IDEA.
  User: kpwang
  Date: 2020/7/10
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载，绑定单击事件
        $(function () {
           $("#btn").click(function () {
               //alert("hello");
               $.ajax({
                   //编写json格式，设置属性和值
                   type:"post",
                   url:"user/testAjax",
                   contentType:"application/json;charset=UTF-8",
                   data:'{"username":"李沁","password":"123","age":30}',
                   dataType:"json",
                   success:function (data) {//data服务器端响应的json数据，进行解析
                       alert(data);
                       alert(data.username);
                       alert(data.password);
                       alert(data.age);
                   }
               });
           });
        });

    </script>
</head>
<body>
    <a href="user/testString">testString</a>
    <br>
    <a href="user/testVoid">testString</a>
    <br>
    <a href="user/testModelAndView">testModelAndView</a>
    <br>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
    <br>

    <button id="btn">发送ajax请求</button>
    <br>


</body>
</html>
