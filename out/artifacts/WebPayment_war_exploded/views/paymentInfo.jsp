<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 09.12.2019
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment ${payment.getName()}</title>
</head>
<body>
<div>
    <h2>Name</h2>
    <h1>${payment.getName()}</h1>

    <h2>Number</h2>
    <h1>${payment.getNumber()}</h1>


    <h2>Amount</h2>
    <h1>${payment.getAmount()}</h1>

</div>
</body>
</html>
