<%--
  Created by IntelliJ IDEA.
  User: bmanh
  Date: 9/13/2023
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ControlServlet" method="post">
  <h2>Thêm Tài Khoản</h2>
  <label for="deleteUsername">Tên Đăng Nhập:</label>
  <input type="text" id="deleteUsername" name="deleteUsername" required><br>
  <!-- Thêm các trường khác cho thông tin tài khoản -->
  <input type="hidden" name="action" value="deleteAccount">
  <button type="submit">Thêm Tài Khoản</button>
</form>
</body>
</html>
