<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ControlServlet" method="post">
  <h2>Hiển Thị Quyền của Tài Khoản</h2>
  <label for="accountRoles">Tên Đăng Nhập:</label>
  <input type="text" id="accountRoles" name="accountRoles" required><br>
  <h4 name="username"><%=request.getAttribute("username") %></h4>
  <input type="hidden" name="action" value="displayAccountRoles">
  <button type="submit">Hiển Thị Quyền</button>
</form>
</body>
</html>
