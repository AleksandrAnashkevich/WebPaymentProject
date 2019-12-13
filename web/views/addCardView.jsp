<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 12.12.2019
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Card</title>
</head>
<body>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<c:if test="${not empty message}">
    ${message}
</c:if>
<div>

    <form method="post">
        <label>Number:
            <input type="text" name="number"><br />
        </label>
        <label>CVV:
            <input type="text" name="cvv"><br />
        </label>
        <button type="submit" onclick="location.href='/cardList'">Submit</button>
    </form>
</div>
</body>
</body>
</html>
