<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/14
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" isELIgnored="false" %>
<%--<%@ include file="index.jsp"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
        <%-- 用户注册 --%>
    <%!
        String name = "用户注册";
    %>
</head>
<body>
    <form action="/register" name="dataForm" id="dataForm" method="post">
        <table align="center">
        <!-- jsp页面 -->
        <tr align="center">
            <td><span style="color: red;"><%=name%></span></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input id="name" type="text" name="username" value="${aa}"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input id="pwd" type="text" name="pwd" value=""></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
    </form>
</body>
</html>
