<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>文件上传</h3>
    <%--传统方式--%>
    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br>

        <input type="submit" value="上传">
    </form>
    <%--springmvc方式--%>
    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br>

        <input type="submit" value="上传">
    </form>
    <%--跨服务器方式--%>
    <form action="user/fileupload3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br>

        <input type="submit" value="上传">
    </form>
</body>
</html>
