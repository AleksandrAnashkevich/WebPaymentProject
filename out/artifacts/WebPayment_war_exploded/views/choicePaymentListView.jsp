<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 12.12.2019
  Time: 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choice Payment</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Name</th>
        <th>Number</th>
        <th>Price</th>
        <th>Choice</th>
    </tr>
    <c:forEach items="${paymentList}" var="payment" >
        <tr>
            <td>${payment.getName()}</td>
            <td>${payment.getNumber()}</td>
            <td>${payment.getAmount()}</td>
            <td>
                <a href="choicePayment?id=${payment.getId()}">Choice Payment</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
