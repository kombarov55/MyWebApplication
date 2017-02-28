<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 04.01.17
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dialogs</title>
</head>
<body>
<h3>${requestScope["h"]}</h3>

<form method="get" action="/homepage/dialogs/chosenDialog">
    <c:forEach items="${dialogs}" var="item">
        <a href="/homepage/dialogs/${item.tableName}">${item.tableName}</a>
    </c:forEach>
</form>

<a href="/homepage/dialogs/createDialog">Создать новый диалог</a>
<a href="/homepage/">Вернуться назад</a>
</body>
</html>
