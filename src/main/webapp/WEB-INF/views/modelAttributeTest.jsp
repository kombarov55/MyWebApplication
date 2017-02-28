<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 13.02.17
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:useBean id="sessionUser" class="com.vk.kombarov_nikolay.model.user.User" scope="session"/>
<html>
<head>
    <title>Test Model Attributes</title>
</head>
<body>
<h1>Request attributes:</h1>
Username:<c:out value="${SessionUser.username}"/> <br>
Password:<c:out value="${SessionUser.password}"/> <br>
toString:<c:out value="${SessionUser}"/><br>
<h2>And the session bean:</h2>
username:<c:out value="${sessionUser.username}"/><br>
password:<c:out value="${sessionUser.password}"/><br>
toString:<c:out value="${sessionUser}"/><br>

</body>
</html>
