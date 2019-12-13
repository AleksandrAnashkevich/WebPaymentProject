<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 22.10.2019
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<c:if test="${not empty message}">
    ${message}
</c:if>
<div>

    <form method="post">
        FirstName
        <label>
            <input type="text" name="firstName"><br />
        </label>
        SecondName
        <label>
            <input type="text" name="secondName"><br />
        </label>
        <label>login:
            <input type="text" name="login"><br />
        </label>
        <label>email:
            <input type="text" name="email"><br />
        </label>
        <label>Password:
            <input type="password" name="password"><br />
        </label>
        <label>RepeatPassword:
            <input type="password" name="passwordRepeat"><br />
        </label>
        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
