<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello World!</title>
    <meta name="viewport"
          content="width=device-width,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0, initial-scale=1.0">
</head>
<body>

<table>
    <tr>
        <td>用户ID</td>
        <td>用户名</td>
        <td>性别</td>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.u_id}</td>
            <td>${user.username}</td>
            <td>${user.sex}</td>
        </tr>
    </c:forEach>
</table>

<c:forEach begin="1" end="${pages}" var="p">
    <a href="${pageContext.request.contextPath}/user/${p}">${p}</a>
</c:forEach>
</body>
</html>
