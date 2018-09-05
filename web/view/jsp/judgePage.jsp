<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.08.2018
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="data"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
    <title>Judge</title>
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
    <div class="col-lg-4">
<c:if test="${requestScope.empList ne null}">
    <c:forEach items="${requestScope.empList}" var="info">
        <p> <fmt:message key="judge.page.hints"></fmt:message> <c:out value="${info.tottalHintsGivenCount}"></c:out></p>
        <p><fmt:message key="team.page.total.games"></fmt:message> <c:out value="${info.tottalGamesCount}"></c:out></p>
    </c:forEach>
</c:if>


    </div>
    <div class="col-lg-8">
        <c:if test="${requestScope.history ne null}">
            <p>Game History</p>
            <ul class="av nav-pills nav-stacked">

                <c:forEach items="${requestScope.history}" var="entity">
                    <li class="list-group-item"> <fmt:message key="menu.button.judge"></fmt:message> : <c:out value="${entity.judgeLogin}"></c:out>
                        <fmt:message key="loser"></fmt:message>: <c:out value="${entity.loserTeam}"></c:out>
                        <fmt:message key="winner"></fmt:message> <c:out value="${entity.winnerTeam}"></c:out>
                        <c:out value="${entity.dateTimeOfGame}"></c:out></li>
                </c:forEach>
            </ul>

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
