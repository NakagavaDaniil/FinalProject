<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 12.08.2018
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link type="text/css" rel="stylesheet" href="css">
</head>
<body>
<form method="post" style="border:1px solid #ccc">
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

      <b>Login</b>
        <input type="text" placeholder="Enter Lgin" name="login" required>

     <b>Password</b>
        <input type="password" placeholder="Enter Password" name="psw" required>



        <label>
            <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
        </label>



        <div class="clearfix">
            <button type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">Sign Up</button>
        </div>
    </div>
</form>
</body>
</html>
