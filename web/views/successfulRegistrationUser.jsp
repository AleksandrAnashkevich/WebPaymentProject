<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 23.10.2019
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successful Registration</title>
</head>
<body>
    <div>
        <%
            if (request.getAttribute("message") != null) {

                out.println("<p>" + request.getAttribute("message") + "</p>");
            }
        %>
    </div>

    <h1>    Successful Registration, login in system</h1>
    <div>
        <button onclick="location.href='..'">Back to main</button>
    </div>
</body>
</html>
