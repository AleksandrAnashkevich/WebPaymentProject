<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 12.12.2019
  Time: 3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choise Card</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Number</th>
        <th>Deposit</th>
        <th>Choice</th>
    </tr>
    <c:forEach items="${cardList}" var="card" >
        <tr>
            <td>${card.getId()}</td>
            <td>${card.getNumber()}</td>
            <td>${card.getDeposit()}</td>
            <td>
                <a href="choiceCard?id=${card.getId()}">Choice Card</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
