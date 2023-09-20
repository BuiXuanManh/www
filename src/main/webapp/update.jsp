<%--
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
</head>
<body>
<form action="ControlServlet" method="post">
  <h2>Cập Nhật Tài Khoản</h2>
  <label for="updateUsername">Tên Đăng Nhập:</label>
  <input type="text" id="updateUsername" name="updateUsername" required><br>
  <label for="newPassword">Mật Khẩu:</label>
  <input type="password" id="Password" name="Password" required><br>
  <label for="Password">Mật Khẩu Mới:</label>
  <input type="password" id="newPassword" name="newPassword" required><br>
  <!-- Thêm các trường khác cho cập nhật thông tin tài khoản -->

  <input type="hidden" name="action" value="updateAccount">
  <button type="submit">Cập Nhật Tài Khoản</button>
</form>
</body>
</html>
