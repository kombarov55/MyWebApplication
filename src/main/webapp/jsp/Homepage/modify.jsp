<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 04.01.17
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Изменить данные</title>
</head>
<body>
<h3>${requestScope.title}</h3>
<form method="post" action="homepage/modify">
    Изменение пароля: <input type="text" name="password"><br>
    <input type="submit">
</form>
<a href="/homepage/">Вернуться назад</a>
</body>
</html>
