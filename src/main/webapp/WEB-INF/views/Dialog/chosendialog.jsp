<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 07.01.17
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="../../stylesheets/chosendialog.css">
</head>
<body>
<div class="section">
    <c:if test="${not empty requestScope.errorMessage}">
        <h3>Произошла ошибка; сообщение: ${requestScope.errorMessage}</h3>
    </c:if>
    <div class="container">
        <ul>
            <c:if test="${sessionScope.messages.size() == 0}">
                <li>No messages</li>
            </c:if>
            <c:forEach items='${chosenDialog.messages}' var="message">
                <li>${message.date} : ${message.content}</li>
            </c:forEach>
        </ul>

        <form method="post" action="/homepage/dialogs/sendMessage.do">
            <textarea rows="5" cols="45" name="text"></textarea><br>
            <input type="submit" value="отправить">
        </form>

    </div>
</div>
</body>
</html>





