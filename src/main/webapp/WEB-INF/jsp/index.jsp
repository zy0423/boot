<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2016/5/13
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/login" method="post">
        <input type="text" name="name"/>
        <input type="password" name="password"/>
        <input type="radio" name="rememberMe" value="1">
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>
