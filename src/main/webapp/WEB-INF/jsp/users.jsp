<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2016/5/13
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach items="${roles}" var="name">
        <li>${name}</li>
    </c:forEach>
</ul>
</body>
</html>
