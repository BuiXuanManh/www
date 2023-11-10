<%@ page import="java.util.List" %>
<%@ page import="com.example.week.models.Role" %>
<%@ page import="com.example.week.models.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <%
        Account a= (Account) request.getAttribute("acc");
        List<Role> l= (List<Role>) request.getAttribute("listRole");
    %>
</head>
<body>
<div class="container">
    <div class="row">
        <h2>Hiển Thị Thông Tin Tài Khoản</h2>
    </div>
    <div class="row">
        <div class="col-md-3">
            <label >Tên Đăng Nhập:</label>
        </div>
        <div class="col-md-3">
            <label ><%=a.getAccount_id()%></label>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <label >Email:</label>
        </div>
        <div class="col-md-3">
            <label ><%=a.getEmail()%></label>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <label >Phone:</label>
        </div>
        <div class="col-md-3">
            <label ><%=a.getPhone()%></label>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <label >Full Name:</label>
        </div>
        <div class="col-md-3">
            <label ><%=a.getFull_name()%></label>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <label >Status:</label>
        </div>
        <div class="col-md-3">
            <label ><%=a.getStatus()%></label>
        </div>
    </div>
    <div class="row">
        <h3>Roles</h3>
    </div>
        <form  method="post" action=<%="ControlServlet?action=grantP&&id="+ a.getAccount_id()%>>
            <div class="row justify-content-center">
                <div class="col-md-1">
                    <label class="text-center">Add role:</label>
                </div>
                <div class="col-md-1">
                    <select class="text-center" name="select">
                        <option value="ADMIN" >ADMIN</option>
                        <option value="USER" >USER</option>
                    </select>
                </div>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>

            </div>
        </form>
    <table class="table table-striped table-bordered table-hover">
        <thead >
        <tr>
            <th>Role Name</th>
            <th>Status</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Role r:l){
        %>
        <tr>
            <th><%=r.getRole_name()%></th>
            <th><%=r.getStatus()%></th>
            <th><%=r.getDescription()%></th>
            <th>
                <a class="btn btn-danger" href=<%="ControlServlet?action=deleteGrant&&id="+a.getAccount_id()+"&&role="+r.getRole_name()%> >Delete</a>
            </th>
        </tr>
        <%}%>
        </tbody>
    </table>


</div>




</body>
</html>
