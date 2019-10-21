<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" name="loginForm" id="loginForm" method="post">
    <table align="center">
        <!-- jsp页面 -->
        <tr align="center">
            <td><span style="color: red;">用户登录</span></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input id="name" type="text" name="username" onblur="validate();"><span id="name_id" style="color: red;"></span></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input id="pwd" type="text" name="pwd" value=""></td>
        </tr>
        <tr>
            <%--<td><input type="submit" value="登录"></td>--%>
            <td><button id="login">登录</button></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>

<script type="text/javascript">
        //页面用户名输入框的校验
        function validate(){
            var name = document.getElementById("name");
            var value = name.value;
            console.log("value=",value);
            if(!value){
                var span = document.getElementById("name_id");
                span.innerText = "请输入用户名";
            }
        }

        function dataform(){
            var name = document.getElementById("name").value;
            var pwd = document.getElementById("pwd").value;
            alert(name)
        }
</script>
</html>
