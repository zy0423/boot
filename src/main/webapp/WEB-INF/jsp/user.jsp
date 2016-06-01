<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2016/6/1
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/user/update" method="post">
            <input type="hidden" name="id" value="${user.id}"/>
            <input type="text" name="name" value="${user.name}"/>
            <input type="password" name="password" value="${user.password}"/>
            <input type="email" name="email" value="${user.email}"/>

            <button type="submit">保存</button>
        </form>
    </div>
</body>
</html>
