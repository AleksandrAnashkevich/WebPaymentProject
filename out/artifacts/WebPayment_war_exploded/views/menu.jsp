<%--
  Created by IntelliJ IDEA.
  User: qqqq
  Date: 10.12.2019
  Time: 3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>

    <a href="${pageContext.request.contextPath}/">Home</a>
    |
    <a href="${pageContext.request.contextPath}/userInfo">My Account Info</a>
    |
    <c:if test="${empty loginUser}">
        <a href="${pageContext.request.contextPath}/login">Login</a>
        |
        <a href="${pageContext.request.contextPath}/registration">Registration</a>
    </c:if>
    <c:if test="${not empty loginUser}">
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </c:if>

</div>
<div>
    <c:if test="${(not empty loginUser) && (loginUser.roleId==1)}">
        <jsp:include page="adminMenu.jsp"></jsp:include>
    </c:if>

    <c:if test="${(not empty loginUser) && (loginUser.roleId==2)}">
        <jsp:include page="regularMenu.jsp"></jsp:include>
    </c:if>
</div>




