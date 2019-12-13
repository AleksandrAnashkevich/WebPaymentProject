<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 23.10.2019
  Time: 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="by.epam.webpayment.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div>
    <div>
        <div>
            <h2>User</h2>
        </div>
        <div>
            <h2>First Name</h2>
            <b>${loginUser.firstName}</b>
        </div>
        <div>
            <h2>Second Name</h2>
            <b>${loginUser.secondName}</b>
        </div>
        <div>
            <h2>Login</h2>
            <b>${loginUser.login}</b>
        </div>
        <div>
            <h2>email</h2>
            <b>${loginUser.email}</b>
        </div>
    </div>
</div>

<div>
    <button onclick="location.href='..'">Back to main</button>
</div>
</body>
</html>
