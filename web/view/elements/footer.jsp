<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.08.2018
  Time: 15:13
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
<style>
    footer{
        background-color: #424558;
        position: fixed;
        bottom: 0;
        left: 0;
        right: 0;
        height: 35px;
        text-align: center;
        color: #CCC;
    }

    footer p {
        font-size: 10px;
        padding: 10.5px;
        margin: 0px;
        line-height: 100%;
    }
</style>
<body>
<footer>
    <div class="row">
        <div class="col-lg-12">
<div class="text-center">
    <p>© 2018 Made by Nakagava Daniil , Logo by Anton Dihtyar .</p>
</div>

        </div>
    </div>

</footer>
</body>
</html>
