<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table align="center" border="1" cellpadding="10" >
        <tr>
            <th hidden>id</th>
            <th>序号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>兴趣</th>
            <th>按钮</th>
        </tr>

        <%--
           List  lists = ${lists};

           for(User user:lists){

           }
        --%>

        <c:forEach var="user" items="${lists}" varStatus="status">
            <tr>
                <td hidden id="id">${user.id}</td>
                <td>${status.count}</td>
                <td>${user.userName}</td>
                <td>${user.pwd}</td>
                <td>${user.hobby}</td>
                <td>
                    <button onclick="update();" value="修改">修改</button>
                    <button onclick="delete1();" value="删除">删除</button>
                </td>
            </tr>
        </c:forEach>

    </table>
</body>

<script type="text/javascript">
    function update() {
        var id = document.getElementById("id");
        var userId = id.innerText;
        console.log("id=",id)
        //window.document.href = "http://localhost:8081/update?id="+userId;
        window.open("http://localhost:8081/update?id=" + userId, "_self");
    }
</script>
</html>
