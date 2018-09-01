<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.08.2018
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
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

<body>
<ul class="menu">
    <li><a href="/main" class="text"><span><fmt:message key="menu.button.main"/></span></a></li>
    <li><a href="/userInfo" class="text"><span><fmt:message key="menu.button.home"/></span></a></li>
    <li><a href="/playerInfo" class="text"><span><fmt:message key="menu.button.player"/></span></a></li>
    <li><a href="/judgeInfo" class="text"><span><fmt:message key="menu.button.judge"/></span></a></li>
    <li><a href="/teamInfo" class="text"><span><fmt:message key="menu.button.team"/></span></a></li>
    <li><a href="/questionEditor" class="text"><span><fmt:message key="menu.button.questions"/></span></a></li>
</ul>
</body>
</html>
