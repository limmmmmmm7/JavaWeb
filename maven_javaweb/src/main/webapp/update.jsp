<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/17
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update" name="updateForm" id="loginForm" method="post">
    <table align="center">
        <!-- jsp页面 -->
        <tr align="center">
            <td><span style="color: red;">用户登录</span></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td>
                <input id="name" type="text" name="username" onblur="validate();" value="${user.userName}"/>
                <span id="name_id" style="color: red;"></span>
                <!-- 用户id -->
                <input id="id" value="${user.id}" hidden>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input id="pwd" type="text" name="pwd" value="${user.pwd}"></td>
        </tr>
        <tr>
            <td>兴趣：</td>
            <td><input id="hobby" type="text" name="bobby" value="${user.hobby}"></td>
        </tr>
        <tr>
            <%--<td><input type="submit" value="登录"></td>--%>
            <td><button id="login">修改</button></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</body>
</html>
