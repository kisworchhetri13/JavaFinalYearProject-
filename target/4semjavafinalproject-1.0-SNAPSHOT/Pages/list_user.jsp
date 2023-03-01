<%-- 
    Document   : list_user
    Created on : Mar 1, 2023, 7:31:23 AM
    Author     : nitro 5
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../include/navbar.jsp" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<div class="container">
  <div class="table-responsive">
    <table class="table">
      <tr>
        <th>id</th>
        <th>Full Name</th>
        <th>Username</th>
        <th>password</th>
        <th>Role</th>
      </tr>

      <c:forEach items="${userList}" var="student">
        <tr>
          <td>${student.id}</td>
          <td>${student.fullname}</td>
          <td>${student.username}</td>
          <td>${student.password}</td>

          <td><a href="user?page=userDetails&id=${student.id}">View Details</a></td>
        </tr>
      </c:forEach>

    </table>
  </div>
  <a href="user?page=newUsers"><h4>Add New User</h4></a>
</div>

</div>

</body>
</html>
