<%@ page import="java.util.List" %>
<%@ page import="com.example.week.models.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <%
    String u= (String) request.getAttribute("username");
    %>
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Amin page</h1>

    </div>
    <div class="row">
    <a class="btn btn-primary" href="create.jsp">Add</a>
    </div>
    <table class="table table-tripped table-bordered table-hover">
        <thead>
            <tr>
                <th>UserName</th>
                <th>Password</th>
                <th>Full Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <%
            if(request.getAttribute("listAcc")!=null){
            List<Account> l= (List<Account>) request.getAttribute("listAcc");
        %>
        <%
            for(Account a:l){
        %>
        <tr>
            <th><%=a.getAccount_id()%></th>
            <th><%=a.getPassword()%></th>
            <th><%=a.getFull_name()%></th>
            <th><%=a.getPhone()%></th>
            <th><%=a.getEmail()%></th>
            <th><%=a.getStatus()%></th>
            <th>
                <a class="btn btn-primary" href=<%="ControlServlet?action=update&&id="+a.getAccount_id()%>>Update</a>
                <a class="btn btn-danger" href=<%="ControlServlet?action=delete&&id="+a.getAccount_id()%>>Delete</a>
                <a class="btn btn-warning" href=<%="ControlServlet?action=grant&&id="+a.getAccount_id()%>>Grant Access</a>
                <a class="btn btn-primary" href=<%="ControlServlet?action=viewLog&&id="+a.getAccount_id()%>>View Log</a>
            </th>
        </tr>
        <%}%>
        <%}%>
        </tbody>
    </table>
    <div class="row">
        <a href=<%="ControlServlet?action=logout&&id="+u%>>Log out</a>
    </div>
</div>
</body>
</html>

