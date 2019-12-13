<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 11.12.2019
  Time: 5:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="by.epam.webpayment.entity.Card" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<h3>Product List</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Number</th>
        <th>Deposit</th>
        <th>Top up</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${cardList}" var="card" >
        <tr>
            <td>${card.getId()}</td>
            <td>${card.getNumber()}</td>
            <td>${card.getDeposit()}</td>
            <td>
                <a href="topUpCard?id=${card.id}">Edit</a>
            </td>
            <td>
                <a href="deleteCard?id=${card.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="addCard" >Add Card</a>

</body>
</html>
