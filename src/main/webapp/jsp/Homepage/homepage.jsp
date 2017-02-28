<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 03.01.17
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>

<c:set var="username" value='${requestScope["pageUsername"]}'/>
<c:set var="clientUsername" value='${requestScope["clientUsername"]}'/>
<html>
<head>
    <title>Home page</title>
    <link type="text/css" rel="stylesheet" href="../stylesheets/homepage.css">
</head>
<body>
<div id="identifier">
    <c:if test="${username == clientUsername}">
        (That's you)
    </c:if>

</div>
<div class="container">
    <p>
        Page of
    <div id="username">
        ${username}
    </div>
    </p>
    <div class="options">
        <c:if test="${username == clientUsername}">
            <p><a href="/homepage/modify">modify your personal data</a></p>
            <p><a href="/homepage/dialogs/">go to dialogs</a></p>
        </c:if>
    </div>
    <a id="logout" href="/Logout.do">log out</a>
</div>

</body>
</html>
