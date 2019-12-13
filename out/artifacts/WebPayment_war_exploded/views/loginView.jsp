
<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 23.10.2019
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<h3>Login Page</h3>
<p style="color: red;">${errorString}</p>

<c:if test="${empty user}">
    ${message}
</c:if>

<form method="POST" action="${pageContext.request.contextPath}/login">
    <table border="0">

        <tr>
            <td>Login</td>
            <td><input type="text" name="login"  /> </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"  /> </td>
        </tr>
        <tr>
            <td>Remember me</td>
            <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
        </tr>
        <tr>
            <td colspan ="2">
                <input type="submit" value= "Submit" />
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
