<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.08.2018
  Time: 15:22
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
       <title>Team</title>
    <link rel="stylesheet" href="/view/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/view/css/style.css" type="text/css">
    <link rel="stylesheet" href="/view/css/teamMenu.css" type="text/css">

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
    <div class="col-lg-4">
        <div class="input-group">
           <buton></buton>
            <input type="text" name="SearchDualList" class="form-control" placeholder="search" />
        </div>
        <c:if test="${requestScope.empList ne null}">
            <ul class="av nav-pills nav-stacked">

            <c:forEach items="${requestScope.empList}" var="emp">

                <li class="list-group-item"><a href=""><span class="glyphicon glyphicon-chevron-right"></span><c:out value="${emp.name}"></c:out></a></li>

            </c:forEach>
            </ul>
        </c:if>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
       <%--TODO resource bundle--%>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <c:import url="/view/elements/footer.jsp"></c:import>
    </div>
</div>
</body>
</html>