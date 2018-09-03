
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
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/view/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/view/css/style.css" type="text/css">
    <title>Document</title>
</head>
<body>

<header class="header">

<div class="row">
                <div  class="col-lg-5" >

                    <img src="/myImg/Logo_ru.png" class="logo flex-fill">

                </div>
                        <c:if test="${sessionScope.userLogin eq null}">
                      <div class="col-lg-1 ml-auto authentication">
                          <form action="/login" method="post" >
                         <input type="text" class="input" placeholder="<fmt:message key="login.placeholder.login"/>" name="login"/>
                           <input type="password" class="input" placeholder="<fmt:message key="login.placeholder.password"/>" name="psw" >
                              <p></p>  <button type="submit" class="btn_style"><a  class="text" ><fmt:message key="login.login"/></a></button>
                         </form>
                          <form action="/registration">
                              <p></p>  <button type="submit" class="btn_style"><a  class="text"><fmt:message key="login.reqistration"/></a></button>
                          </form>
                      </div>
                        </c:if>
                        <c:if test="${sessionScope.userLogin ne null}">
                      <p><c:out value="${sessionScope.userLogin}"></c:out></p>
                            <form action="/logOut">
                                <button type="submit">
                                    <a  class="text">Logout</a>
                                </button>
                            </form>
                        </c:if>
                <div  class="col-lg-1 ml-auto" >
                    <div align="right">
                        <form>
                            <select id="language" name="language" onchange="submit()">
                                <option value="ua" ${language == 'ua' ? 'selected' : ''}>Ukraine</option>
                                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                            </select>
                        </form>
                    </div>

            </div>

</div>
</header>


</body>
</html>