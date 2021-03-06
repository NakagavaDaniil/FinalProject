<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.08.2018
  Time: 12:23
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
    <title><c:out value="${requestScope.userLogin}"></c:out></title>
    <link rel="stylesheet" href="/view/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/view/css/style.css" type="text/css">
</head>
<body>
<header>
    <c:import url="/view/elements/header.jsp"></c:import>
</header>
<div class="row">
    <div class="col-lg-12">
        <c:import url="/view/elements/userMenu.jsp"></c:import>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <c:if test="${requestScope.empList ne null}">
        <c:forEach items="${requestScope.empList}" var="emp">
            <tr>
               <p> <td><fmt:message key="registration.name"></fmt:message> <c:out value="${emp.USER_FIRST_NAME}"></c:out></td></p>
               <p> <td><fmt:message key="registration.surname"></fmt:message> :<c:out value="${emp.USER_LAST_NAME}"></c:out></td></p>
               <p><td><fmt:message key="registtration.birth.date"></fmt:message> :<c:out value="${emp.BIRTH_DATE}"></c:out></td></p>

               <p> <td>Password : <c:out value="${emp.USER_PASSWORD}"></c:out></td></p>
               <p><td>Email :<c:out value="${emp.EMAIL}"></c:out></td></p>
            </tr>
        </c:forEach>
        </c:if>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <c:import url="/view/elements/footer.jsp"></c:import>
    </div>
</div>
</body>
</html>
