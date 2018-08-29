
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/view/myHeader/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/view/myHeader/style.css" type="text/css">
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
                         <input type="text" class="input" placeholder="Login" name="login" pattern="^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\d.-]{0,19}$">
                           <input type="password" class="input" placeholder="Password" name="psw" >
                              <p></p>  <button type="submit" class="btn_style"><a  class="text" >Login</a></button>
                         </form>
                          <form action="/registration">
                              <p></p>  <button type="submit" class="btn_style"><a  class="text">Register</a></button>
                          </form>
                      </div>
                        </c:if>
                        <c:if test="${sessionScope.userLogin ne null}">
                      <p><c:out value="${sessionScope.userLogin}"></c:out></p>
                            <form action="/logOut">
                                <button type="submit">
                                    Logout
                                </button>
                            </form>
                        </c:if>
                <div  class="col-lg-1 ml-auto" >
                    <ul class="menu   ml-auto locale_menu">
                        <li><a class="text locale_a " href="/">ENG</a></li>
                        <li><a class="text locale_a" href="/">UKR</a></li>

                    </ul>

            </div>

</div>
</header>


</body>
</html>