<%--
  Created by IntelliJ IDEA.
  User: nikolaykombarov
  Date: 08.01.17
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Failure</title>
</head>

<c:set var="message" value='${requestScope["errorMessage"]}'/>
<body>
    <p>Ваш запрос не может быть обработан; причина, ошибки: ${message}</p>
</body>
</html>
