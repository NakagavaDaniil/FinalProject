<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.08.2018
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
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
               <p> <td>Name : <c:out value="${emp.USER_FIRST_NAME}"></c:out></td></p>
               <p> <td>Last name :<c:out value="${emp.USER_LAST_NAME}"></c:out></td></p>
               <p><td>Birth date :<c:out value="${emp.BIRTH_DATE}"></c:out></td></p>

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
