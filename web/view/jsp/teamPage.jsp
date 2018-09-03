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
                Search: <input type="text"  name="search_string">
                <button type="submit">Ok</button>
            </form>
        <form action="/teamInfo">
        <c:if test="${requestScope.empList ne null}">
            <ul class="av nav-pills nav-stacked">

            <c:forEach items="${requestScope.empList}" var="emp">

                <li class="list-group-item" >
                    <input type="hidden" name="action" value = "select">
                   <button type="submit" name="teamName" value="${emp.name}"><c:out value="${emp.name}"></c:out></button>
                </li>

            </c:forEach>
            </ul>
        </c:if>
        </form>
        <form action="/teamInfo">
            <button name="action" type="submit" value="allTeams"><a >All Teams </a></button>
            <button name="action" type="submit" value="myTeams"><a >My Teams</a> </button>
        </form>
            <form action="/teamInfo">
            <p></p>
            <input type="hidden" name="action" value = "create">
            Create Team : <input type="text" name="create_string">
            <button type="submit">Ok</button>
        </form>
    </div>

    <div class="col-lg-8">
     <div>
         <c:if test="${requestScope.teamList ne null}">
        <c:forEach items="${requestScope.teamList}" var="entity">
            <c:out value="${entity.name}"></c:out>
            <c:out value="${entity.tottalWinsCount}"></c:out>
            <c:out value="${entity.tottalGamesCount}"></c:out>
            <%--TODO game history--%>
        </c:forEach>
             <button><a >Join or Leave team</a></button>
         </c:if>
     </div>
    </div>
    <p></p>
    <p></p>
    <p></p>
</div>

<c:import url="/view/elements/footer.jsp"></c:import>

</body>
</html>