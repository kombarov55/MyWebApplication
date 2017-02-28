<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 01.01.17
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Вход</title>
    <link href="../stylesheets/login.css" rel="stylesheet" type="text/css">
    <%--<c:set var="title" value='${requestScope["title"]}'/>--%>
</head>
<body>

<div class="container">

    <div class="warning">
        <c:choose>
            <c:when test="${empty requestScope.title}">
                <c:set var="title" value="Введите ваши данные ниже"/>
            </c:when>
            <c:otherwise>
                <c:set var="title" value="${requestScope.title}"/>
            </c:otherwise>
        </c:choose>
        <h3>${title}</h3>
    </div>

    <div class="forms">
        <sf:form method="post" commandName="user">
            <div class="form-input">
                <sf:input path="username"/><br>
            </div>

            <div class="form-input">
                <sf:input path="password"/><br>
            </div>
            <input type="submit" value="Вход">
        </sf:form>
    </div>

    <div class="link">
        <a href="/register">Зарегистрироваться</a><br>
    </div>
    <div class="link">
        <a href="/Welcome.do">Вернуться назад</a>
    </div>
</div>
</body>
</html>
