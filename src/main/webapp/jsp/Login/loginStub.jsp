<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 19.01.17
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="warning">
    <h3>Введите данные</h3>
</div>
<form method="post" action="j_security_check">
    <div class="form-input">
        <input type=text name="j_username" placeholder="Введите имя..."><br>
    </div>

    <div class="form-input">
        <input type="password" name="j_password" placeholder="Введите пароль..."><br>
    </div>
    <input type="submit" value="Вход">
</form>
<div class="link">
    <a href="/login/register">Зарегистрироваться</a><br>
</div>
<div class="link">
    <a href="/Welcome.do">Вернуться назад</a>
</div>
</body>
</html>
