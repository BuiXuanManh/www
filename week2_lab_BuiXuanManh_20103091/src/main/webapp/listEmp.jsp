<%@ page import="iuh.fit.week2.models.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: bmanh
  Date: 9/30/2023
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
    List<Employee> l= (List<Employee>) request.getAttribute("employees");
    %>
</head>
<body>
<h1>Employee Management</h1>

<!-- Form để thêm mới Employee -->
<form action="/api/ControlServlet?action=create" method="POST">
    <label >Full Name:</label>
    <input type="text" name="fullName" required><br>
    <label >Date of Birth (yyyy-MM-dd):</label>
    <input type="text" name="dob" required><br>
    <label >Email:</label>
    <input type="text" name="email" required><br>
    <label >Phone:</label>
    <input type="text" name="phone" required><br>
    <label >Address:</label>
    <input type="text" name="address" required><br>
    <input type="submit" value="Create Employee">
</form>

<!-- Danh sách Employee -->
<h2>List of Employees</h2>
<table >
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Date of Birth</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <% for (Employee e:l){%>
        <tr>
            <td><%e.getEmpId();%></td>
            <td><%e.getFullName();%></td>
            <td><%e.getDob();%></td>
            <td><%e.getEmail();%></td>
            <td><%e.getPhone();%></td>
            <td><%e.getAddress();%></td>
            <td><%e.getStatus();%></td>
            <td>
                <a href="/api/ControlServlet?action=edit&&id=<%e.getEmpId();%>">Edit</a>
                <a href="/api/ControlServlet?action=delete&&id=<%e.getEmpId();%>">Delete</a>
            </td>
        </tr>
        <%}%>

</table>
</body>
</html>
