<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎</title>
    <meta name="viewport"
          content="width=device-width,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0, initial-scale=1.0">
</head>

<frameset rows="25%,*" >

    <frame name="top" src="${pageContext.request.contextPath}/top">
    <frame name="main" src="${pageContext.request.contextPath}/user/1">
</frameset>
</html>
