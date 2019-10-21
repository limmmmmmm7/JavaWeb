<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/14
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        //post请求乱码的解决方式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String userName = request.getParameter("username");
        //get请求解决乱码的方式
        userName = new String(userName.getBytes("ISO-8859-1"),"UTF-8");
        out.print("密码：<br />");
        out.print("<span style='color:red;'>"+request.getParameter("pwd")+"</span><br />");
    %>
</head>
<body>
    用户名称：<%=userName%>
</body>
</html>
