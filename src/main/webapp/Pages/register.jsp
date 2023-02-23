<%-- 
    Document   : register
    Created on : Feb 14, 2023, 8:55:43 AM
    Author     : nitro 5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <form action="user?page=register" method="post">
            <label for="Username">Username:</label><br>
            <input type="text" name="Username"><br>
            <label for="Password">Password:</label><br>
            <input type="password" name="Password"><br>
            <label for="Fullname">Fullname</label><br>
            <input type="text" name="Fullname"><br>

            <input type="submit" value="Submit">
            <a href=""> Back TO Login</a>
        </form>
    </body>
</html>
