<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2016/5/23
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<label>在线用户数量:${sesessionCount}</label>

<table>
    <thead>
    <tr>
        <th style="width: 150px;">会话ID</th>
        <th>主机地址</th>
        <th>最后访问时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessions}" var="session">
        <tr>
            <td>${session.id}</td>
            <td>${session.host}</td>
            <td><fmt:formatDate value="${session.lastAccessTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/sessions/forceLogout/${session.id}">强制退出</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script type="application/javascript" src="/js/jquery-2.2.4.min.js"/>
</body>
</html>
