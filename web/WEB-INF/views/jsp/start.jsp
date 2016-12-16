<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2016/12/13
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>test 页面</title>
    <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js"></script>
    <script type="text/javascript">
        //ajax自身的解决乱码的问题
//        $.ajaxSetup({
//            contentType: "application/x-www-form-urlencoded; charset=utf-8"
//        });
        $(document).ready(function(){
            $("#btn").click(function(){
                $.post("/welcome/getPerson",{name:$("#name").val(),sex:$("#sex").val()},function(data){
                    alert(data);
                });
            })
        });
    </script>
</head>
<body>
            测试跳转的页面
    <form id="userform" action="/welcome/getUser" method="post">
        姓名：<input id="name" type="text" value="${user.name}"/>
        性别：<select id="sex" path="sex" value="${user.sex}">
                    <option value="男">男</option>
                    <option value="女">女</option>
            </select>
        出生日期：<input id="birth" type="time">
        <input id="submit" type="submit">
    </form>
        <button id="btn">提交</button>
        <button id="formbtn">表单提交</button>
</body>
</html>
