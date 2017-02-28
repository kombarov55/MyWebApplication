<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 07.01.17
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create dialog</title>
</head>
<body>
<h3>Create dialog:</h3>
<form method="POST" action="/homepage/dialogs/createDialog">
    <c:forEach items='${requestScope["usernames"]}' var="username">
        <button name="username2" value="${username}" type="submit">${username}</button>
        <br>
    </c:forEach>
</form>
</body>
</html>
