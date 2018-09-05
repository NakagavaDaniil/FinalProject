<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.08.2018
  Time: 15:21
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
    <title><fmt:message key="menu.button.questions"></fmt:message> </title>
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
        <form action="/questionInfo">
            <button type="submit" name="action" value="allQuest"><fmt:message key="question.page.button.all"></fmt:message></button>
            <button type="submit" name="action" value="myQuest"><fmt:message key="question.page.button.my"></fmt:message></button>

        </form>
        <c:if test="${requestScope.empList ne null}">
            <ul class="av nav-pills nav-stacked">
            <c:forEach items="${requestScope.empList}" var="emp">
                <li class="list-group-item">  <c:out value="${emp.question}"></c:out></li>
            </c:forEach>
            </ul>
        </c:if>
    </div>
    <div class="col-lg-8">
        <form action="/questionInfo">

            <input type="hidden" name="action" value="add">
        <p><fmt:message key="question.page.button.create"></fmt:message></p>
            <textarea type="text" class="text-area" rows="6" name="quest_text">
            </textarea>
                <p><fmt:message key="question.page.variants"></fmt:message></p>
                <input type="text" name="variants">
        <p><fmt:message key="question.page.answer"></fmt:message></p>
        <input type="text" name="answer">
        <button type="submit"><fmt:message key="question.page.button.create"></fmt:message></button>
        </form>
    </div>
<div class="row">
    <div class="col-lg-12">
        <c:import url="/view/elements/footer.jsp"></c:import>
    </div>
</div>
</div>
</body>
</html>