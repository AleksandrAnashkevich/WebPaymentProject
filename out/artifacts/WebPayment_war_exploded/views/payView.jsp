<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 12.12.2019
  Time: 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pay</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<div>

    <a href="${pageContext.request.contextPath}/choicePaymentList">Choice Payment <a/>

    <c:if test="${(not empty choicePayment)}">
        <div>Name:${choicePayment.getName()}</div>
        <div>Price:${choicePayment.getAmount()}</div>
        </c:if>
</div>

<div>

    <a href="${pageContext.request.contextPath}/choiceCardList">Choice Card<a/>


    <c:if test="${(not empty choiceCard)}">
        <div>Number:${choiceCard.getNumber()}</div>
        <div>Deposit:${choiceCard.getDeposit()}</div>


        </c:if>
</div>
    <c:if test="${(not empty message)}">
        ${message}
    </c:if>

    <c:if test="${(not empty choiceCard)&&(not empty choicePayment)}">
        <a href="${pageContext.request.contextPath}/makePayment">Make a Payment <a/>
    </c:if>
<div>

</div>
</body>
</html>
