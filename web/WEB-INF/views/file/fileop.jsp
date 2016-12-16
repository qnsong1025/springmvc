<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2016/12/14
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件的上传和下载</title>
</head>
<body>
<form name="serForm" action="/file/fileUpload" method="post"  enctype="multipart/form-data">
    <h1>采用流的方式上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>

<form name="Form2" action="/file/fileUpload2" method="post"  enctype="multipart/form-data">
    <h1>采用multipart提供的file.transfer方法上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>

<form name="Form2" action="/file/springUpload" method="post"  enctype="multipart/form-data">
    <h1>使用spring mvc提供的类的方法上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>
</body>
</html>
