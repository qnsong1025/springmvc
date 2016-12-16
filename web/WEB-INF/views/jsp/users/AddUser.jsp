<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2016/12/13
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
    <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#btn").click(function(){
                //序列化表单元素，返回json数据
                var params = $("#userForm").serializeArray();
                $.ajax({
                    type:"POST",
                    url:"${pageContext.request.contextPath}/user/addUser",
                    data:params,
                    success:function(data){
//                        alert(data);
                        alert("成功");
                    },
                    error:function(e) {
                        alert("出错："+e);
                    }
                });
            });
        });
    </script>
</head>
<body>
<form id="userForm">
    <table>
        <tr>
            <td>账号</td>
            <td>
                <input type="text" id="username" name="username">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <select id="sex" name="sex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
        </tr>
        <tr>
            <td> </td>
            <td>
                <input type="button" id="btn" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
