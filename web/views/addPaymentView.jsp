<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 09.12.2019
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Payment</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<c:if test="${not empty message}">
    ${message}
</c:if>
<div>

    <form method="post">
        <label>Name:
            <input type="text" name="name"><br />
        </label>
        <label>Number:
            <input type="text" name="number"><br />
        </label>
        <label>Amount:
            <input type="text" name="amount"><br />
        </label>
        <button type="submit" onclick="location.href='/listPayment'">Submit</button>
    </form>
</div>
</body>
</html>
