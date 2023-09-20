<%--
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
</head>
<body>
<form action="ControlServlet" method="post">
    <h2>Ghi Log Đăng Nhập/Đăng Xuất</h2>
    <label for="logUsername">Tên Đăng Nhập:</label>
    <input type="text" id="logUsername" name="logUsername" required><br>
    <h4 name="username"><%=request.getAttribute("Log") %></h4>
    <input type="hidden" name="action" value="logLoginLogout">
    <button type="submit">Ghi Log</button>
</form>

</body>
</html>
