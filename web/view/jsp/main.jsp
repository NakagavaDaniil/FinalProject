<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 15.08.2018
  Time: 20:37
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
    <title>UserPage</title>

    <link rel="stylesheet" href="/view/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/view/css/style.css" type="text/css">
</head>
<body>

<header>
    <c:import url="/view/elements/header.jsp"></c:import>
</header>

<c:if test="${sessionScope.userLogin ne null}">
    <div class="row">
        <div class="col-lg-12">
            <c:import url="/view/elements/userMenu.jsp"></c:import>
        </div>
    </div>
</c:if>
<div class="row">
    <div class="col-lg-12">
       Main info
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <c:import url="/view/elements/footer.jsp"></c:import>
    </div>
</div>
</body>
</html>
