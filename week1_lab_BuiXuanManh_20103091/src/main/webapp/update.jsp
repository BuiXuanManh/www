<%@ page import="com.example.week.models.Account" %><%--
  Created by IntelliJ IDEA.
  User: bmanh
  Date: 9/13/2023
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <%
    Account acc= (Account) request.getAttribute("acc");
  %>
</head>
<body>
<div class="container">
  <div class="row">
    <h2>Update</h2>
  </div>
  <form action=<%="ControlServlet?action=update&&id="+acc.getAccount_id()%> method="post">
    <div class="form-group">
      <label for="Password">Password:</label>
      <input class="form-control" type="password" id="Password" name="password" value=<%=acc.getPassword()%> required><br>
    </div>
    <div class="form-group">
      <label>Email:</label>
      <input class="form-control" type="text" name="email" value=<%=acc.getEmail()%> required><br>
    </div>
    <div class="form-group">
      <label>Phone:</label>
      <input class="form-control" type="text" name="phone" value=<%=acc.getPhone()%> required><br>
    </div>
    <div class="form-group">
      <label>Full name:</label>
      <input class="form-control" type="text" name="fullName" value=<%=acc.getFull_name()%> required><br>
    </div>
    <button class="btn btn-primary" type="submit">Cập Nhật Tài Khoản</button>
  </form>
</div>

</body>
</html>
