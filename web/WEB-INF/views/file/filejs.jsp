<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2016/12/14
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js"></script>
    <script src="../../js/ajaxfileupload.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#upbtn").click(function(){
                alert('开始上传');
                ajaxFileUpload();
                });
        });
        function ajaxFileUpload() {
            alert('上传中。。。。');
            $.ajaxFileUpload
            ({
                        type: "POST",
                        url: '/file/jsfileUpload', //用于文件上传的服务器端请求地址
                        secureuri: false, //是否需要安全协议，一般设置为false
                        fileElementId: 'file1', //文件上传域的ID
                        dataType: 'json', //返回值类型 一般设置为json
                        async : false,
                        success: function(data){
                            alert('成功');
                            if(data.result=='success'){
                                alert(data.imgurl);
                               // $("#img1").attr("src", "../../up_files/"+data.imgurl); // 可用 $("#img1").attr("src", "../../up_files/"+data.imgurl);
                                $("#img1").attr("src", "../../../u_files/"+data.imgurl);
                                $("#filename").val(data.imgurl);
                                var url="/file/download?fileName="+encodeURI(encodeURI("店当.png"));
                                $("#zwhref").attr("href",url);
                            }else{
                                //coding
                            }
                        },
                        error: function (data, status, e){
                            //coding
                            alert('失败'+':'+e);
                        }
                    }
            );
        }
    </script>
</head>
<body>
        <p><input type="file" id="file1" name="file" /></p>
        <input id="upbtn" type="button" value="上传" />
        <p><img id="img1" alt="上传成功啦" width="480" src="../../../u_files/11111.png" height="385"/></p><!-- ../../up_files/11111.png-->
        <p> <input type="text" id="filename" /></p>

        <a href="" id="zwhref">下载文件_店当</a>
        <a href="/file/download?fileName=11111.png">下载文件_11111</a>

</body>
</html>
