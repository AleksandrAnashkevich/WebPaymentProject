<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 12.12.2019
  Time: 0:55
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

<c:if test="${not empty card}">
    <form method="post">
        <c:set var="id" scope="session" value="${card.id}"/>
        <label>Enter deposit:
            <input type="text" name="deposit" ><br />
        </label>
        <button type="submit" onclick="location.href='/listPayment'">Submit</button>
    </form>
</c:if>


</body>
</html>
