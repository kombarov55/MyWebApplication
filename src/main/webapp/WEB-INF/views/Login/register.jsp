<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 01.01.17
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<html>
<head>
    <title>Register</title>
    <link href="../stylesheets/register.css" type="text/css" rel="stylesheet">
</head>
<body>
<c:set var="title" value='${requestScope.title}'/>
<div class="container">
    <div class="warning">
        <h3>${title}</h3>
    </div>
    <sf:form method="post" commandName="user">
        <div class="forms">
            <div class="formInput">
                <sf:input  path="username"/><br>
            </div>
            <div class="formInput">
                <sf:input  path="password"/><br>
            </div>
        </div>
        <div class="formInput">
            <input type="submit" value="Зарегистрироваться">
        </div>
    </sf:form>
    <div class="link">
        <a href="/login/">Вернуться на страницу входа</a>
    </div>
    <div class="link">
        <a href="/">Вернуться назад</a>
    </div>
</div>
</body>
</html>
