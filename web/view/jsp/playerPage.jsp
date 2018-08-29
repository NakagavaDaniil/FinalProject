<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.08.2018
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><c:out value="${sessionScope.userLogin}"></c:out></title>
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
                    <p> <td>total game : <c:out value="${emp.tottalGamesCount}"></c:out></td></p>
                    <p> <td>total wins :<c:out value="${emp.tottalWinsCount}"></c:out></td></p>
                    <p><td>total points :<c:out value="${emp.tottalPointsCount}"></c:out></td></p>

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