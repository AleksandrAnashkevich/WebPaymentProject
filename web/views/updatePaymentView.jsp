<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 10.12.2019
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    ${message}
</c:if>

<c:if test="${not empty payment}">
    <form method="post">
        <c:set var="id" scope="session" value="${payment.id}"/>
        <label>Name:
            <input type="text" name="name" value="${payment.name}"><br />
        </label>
        <label>Number:
            <input type="text" name="number" value="${payment.number}"><br />
        </label>
        <label>Amount:
            <input type="text" name="amount" value="${payment.amount}"><br />
        </label>
        <button type="submit" onclick="location.href='/listPayment'">Submit</button>
    </form>
</c:if>

</body>
</html>
