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

            <form method = get action="/teamInfo" >
                    <input type="hidden" name="action" value = "search">
               <fmt:message key="team.page.search"></fmt:message> <input type="text"  name="search_string">
                <button type="submit">Ok</button>
            </form>
                <form method = get action="/teamInfo" >
            <button name="action" type="submit" value="allTeams"><a ><fmt:message key="team.page.button.all.teams"></fmt:message> </a></button>
            <button name="action" type="submit" value="myTeams"><a ><fmt:message key="team.page.button.my.teams"></fmt:message> </a> </button>
        </form>
        <form action="/teamInfo">
            <ul class="av nav-pills nav-stacked" style="width: 360px; height: 400px; overflow: auto" >
        <c:if test="${requestScope.empList ne null}">
            <c:forEach items="${requestScope.empList}" var="emp">
                <button type="submit" name="teamName" value="${emp.name}" style="width: 300px;">
                <li class="list-group-item" >
                    <input type="hidden" name="action" value = "select">
                 <c:out value="${emp.name}"></c:out>
                </li>
                </button>
            </c:forEach>

        </c:if>
            </ul>
        </form>

            <form action="/teamInfo">
            <p></p>
            <input type="hidden" name="action" value = "create">
          <fmt:message key="team.page.button.create"></fmt:message> <input type="text" name="create_string">
            <button type="submit">Ok</button>
        </form>
    </div>

    <div class="col-lg-4">
     <div>
         <c:if test="${requestScope.teamList ne null}">

        <c:forEach items="${requestScope.teamList}" var="entity">
         <p>  <c:out value="${entity.name}"></c:out></p>
            <p> <fmt:message key="team,page.wins"></fmt:message>  <c:out value="${entity.tottalWinsCount}"></c:out></p>
            <p> <fmt:message key="team.page.total.games"></fmt:message> <c:out value="${entity.tottalGamesCount}"></c:out></p>
            <form action="/teamInfo">
                <input type="hidden" name="action" value="join">
            <button name="join_teamId" value="${entity.id}"><fmt:message key="team.page.button.join.team"></fmt:message> </button>
            </form>

        </c:forEach>

             <c:if test="${requestScope.teamPlayers ne null}">
                 <p>T<fmt:message key="team.page.members"></fmt:message> </p>
             <ul class="av nav-pills nav-stacked">
             <c:forEach items="${requestScope.teamPlayers}" var="player">
               <li class="list-group-item">  <c:out value="${player}"></c:out></li>
             </c:forEach>
             </ul>
         </c:if>
         </c:if>
     </div>
    </div>
    <div class="col-lg-4">
        <div>
            <c:if test="${requestScope.history ne null}">
                <p><fmt:message key="team.page.history"></fmt:message> </p>
                    <ul class="av nav-pills nav-stacked">

                <c:forEach items="${requestScope.history}" var="entity">
                    <li class="list-group-item"> <fmt:message key="menu.button.judge"></fmt:message> <c:out value="${entity.judgeLogin}"></c:out>
                        <fmt:message key="loser"></fmt:message> <c:out value="${entity.loserTeam}"></c:out>
                        <fmt:message key="winner"></fmt:message> <c:out value="${entity.winnerTeam}"></c:out>
                         <c:out value="${entity.dateTimeOfGame}"></c:out></li>
                </c:forEach>
                </ul>
            </c:if>
            <c:if test="${requestScope.history eq null}">
                <p>No games yet</p>
            </c:if>
        </div>
    </div>

</div>
<div class="row">
    <div class="col-lg-12">
        <p></p>
        <br>

    </div>
</div>
<c:import url="/view/elements/footer.jsp"></c:import>

</body>
</html>