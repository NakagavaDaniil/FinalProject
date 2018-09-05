<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.08.2018
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="data"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
    <title><c:out value="${sessionScope.userLogin}"></c:out></title>
    <link rel="stylesheet" href="/view/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/view/css/style.css" type="text/css">
    <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
                       url = "jdbc:mysql://localhost:3306/projectdb?characterEncoding=utf-8"
                       user = "root"  password = "password"/>

    <sql:query dataSource = "${snapshot}" var = "result">
        SELECT team_name FROM teamname LEFT JOIN team_player tp on teamname.id = tp.team_id  WHERE player_id ='${sessionScope.userId}';
    </sql:query>
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
    <div class="col-lg-6">
        <c:if test="${requestScope.empList ne null}">

            <c:forEach items="${requestScope.empList}" var="emp">
                <tr>
                    <p> <td><fmt:message key="team.page.total.games"></fmt:message> : <c:out value="${emp.tottalGamesCount}"></c:out></td></p>
                    <p> <td><fmt:message key="team,page.wins"></fmt:message> :<c:out value="${emp.tottalWinsCount}"></c:out></td></p>
                    <p><td><fmt:message key="total.points"></fmt:message> :<c:out value="${emp.tottalPointsCount}"></c:out></td></p>

                </tr>
            </c:forEach>
        </c:if>
    </div>
    <div class="col-lg-6">
        <ul class="av nav-pills nav-stacked" style="width: 360px; height: 400px; overflow: auto" >
<c:if test="${result ne null}">
    <bh>Your teams</bh>
        <c:forEach var = "row" items = "${result.rows}">

            <li class="list-group-item" ><c:out value="${row.team_name}"></c:out> </li>

        </c:forEach>
</c:if>
        </ul>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <c:import url="/view/elements/footer.jsp"></c:import>
    </div>
</div>
</body>
</html>