<%@ page import="com.example.week.models.Log" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: bmanh
  Date: 9/13/2023
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Log page</h1>
    </div>
    <table class="table table-tripped table-bordered table-hover">
        <thead>
        <tr>
            <th>Note</th>
            <th>Login Date</th>
            <th>Logout Date</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (request.getAttribute("listLog") != null) {
                List<Log> l = (List<Log>) request.getAttribute("listLog");
        %>
        <%
            for (Log a : l) {
        %>
        <tr>
            <th><%=a.getNote()%>
            </th>
            <th><%=a.getLoginDate()%>
            </th>
            <th><%=a.getLogoutDate()%>
            </th>
        </tr>
        <%}%>
        <%}%>
        </tbody>
    </table>
</div>

</body>
</html>
