<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 22.10.2019
  Time: 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="by.epam.webpayment.entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<h3>User List</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Login</th>
        <th>Email</th>
    </tr>
    <c:forEach items="${userList}" var="user" >
    <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.secondName}</td>
        <td>${user.login}</td>
        <td>${user.email}</td>

    </tr>
</c:forEach>
</html>
