<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 03.01.17
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Home page</title>
    <link type="text/css" rel="stylesheet" href="../stylesheets/homepage.css">
</head>
<body>
<div id="identifier">
    <c:if test="${sessionUser.username == requestedUser.username}">
        (That's you)
    </c:if>

</div>
<div class="container">
    <p>
        Page of
    <div id="username">
        ${requestedUser.username}
    </div>
    </p>
    <div class="options">
            <p><a href="/homepage/modify">modify your personal data</a></p>
            <p><a href="/homepage/dialogs/">go to dialogs</a></p>
    </div>
    <a id="logout" href="/Logout.do">log out</a>
</div>
</body>
</html>
