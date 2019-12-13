<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 10.12.2019
  Time: 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
    <div style="float: left">
        <h1>WebPayment</h1>
    </div>

    <div style="float: right; padding: 10px; text-align: right;">

        Hello <b>${loginedUser.getLogin}</b>
        <br/>
        Language
        <div>
            <button onclick="location.href='/england'">England</button>
            <button onclick="location.href='/russian'">Russian</button>
        </div>

    </div>

</div>
