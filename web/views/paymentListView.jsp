<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 09.12.2019
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="by.epam.webpayment.entity.Payment" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<h3>Payment List</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Number</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${paymentList}" var="payment" >
        <tr>
            <td>${payment.getId()}</td>
            <td>${payment.getName()}</td>
            <td>${payment.getNumber()}</td>
            <td>${payment.getAmount()}</td>
            <td>
                <a href="updatePayment?id=${payment.id}">Edit</a>
            </td>
            <td>
                <a href="deletePayment?id=${payment.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="addPayment" >New Payment</a>
</body>
</html>
