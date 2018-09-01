<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.09.2018
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="data"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<div align="right">
    <c:out value="${language}"></c:out>
    <form>
        <select id="language" name="language" onchange="submit()">
            <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
            <option value="ua" ${language == 'ua' ? 'selected' : ''}>Ukraine</option>
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        </select>
    </form>
</div>
<br><br>

<div align="center">
    <form method="POST" action="/clientController">
        <%--@declare id="password"--%><%--@declare id="login"--%>
        <label for="login"><fmt:message key="login.login"/>:</label>
        <br>
        <input type="text" name="login" value="">
        <br><br>

        <label for="password"><fmt:message key="login.placeholder.password"/></label><br>
        <input type="text" name="password" value=""><br>
        <br>
        <input type="hidden" name="command" value="authorization">
        <fmt:message key="req.exp.login" var="enter"/>
        <input type="submit" value="${enter}">
    </form>
    <form method="post" action="/clientController">
        <input type="hidden" name="command" value="Register page">
        <fmt:message key="req.exp.email" var="registerPath"/>
        <input type="submit" value="${registerPath}">
    </form>
</div>
<br><br><br>
<table border="1">
    <tr>
        <th>Login</th>
        <th>Password</th>
    </tr>
    <tr align="center">
        <td>admin</td>
        <td>admin</td>
    </tr>
    <tr align="center">
        <td>user</td>
        <td>user</td>
    </tr>
</table>
</td>


</body>
</html>