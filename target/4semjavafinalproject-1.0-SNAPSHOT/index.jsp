<%-- 
    Document   : index
    Created on : Feb 8, 2023, 11:07:32 AM
    Author     : nitro 5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Final Project</title>
    </head>
    <body>

        <form action="user" method="post">
            <label for="Username">Username:</label><br>
            <input type="text" name="Username"><br>
            <label for="Password">Password:</label><br>
            <input type="password" name="Password">
             <input type="submit" value="Login">
             <a href="Pages/register.jsp">Register</a>
        </form>
        

    </body>
</html>
