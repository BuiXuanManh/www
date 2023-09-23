<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ControlServlet" method="post">
  <h2>Cấp Quyền cho Tài Khoản</h2>
  <label for="grantUsername">Tên Đăng Nhập:</label>
  <input type="text" id="grantUsername" name="grantUsername" required><br>

  <label for="grantRole">Vai Trò:</label>
  <input type="text" id="grantRole" name="grantRole" required><br>

  <input type="hidden" name="action" value="grantPermission">
  <button type="submit">Cấp Quyền</button>
</form>

</body>
</html>
