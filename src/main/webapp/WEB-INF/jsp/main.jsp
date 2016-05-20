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
<shiro:user>
    欢迎[<shiro:principal/>]登录，<a href="/logout">退出</a>
</shiro:user>

<a href="/main/users">用户列表</a>

<shiro:hasRole name="admin">
    用户[<shiro:principal/>]拥有角色admin<br/>
</shiro:hasRole>

<shiro:hasRole name="general">
    用户[<shiro:principal/>]拥有角色general<br/>
</shiro:hasRole>

</body>
</html>
