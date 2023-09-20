<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ControlServlet" method="post">
  <h2>Hiển Thị Tài Khoản của Một Vai Trò</h2>
  <label for="roleAccounts">Vai Trò:</label>
  <input type="text" id="roleAccounts" name="roleAccounts" required><br>
  <h4 name="username"><%=request.getAttribute("Role") %></h4>
  <input type="hidden" name="action" value="displayAccountsByRole">
  <button type="submit">Hiển Thị Tài Khoản</button>
</form>

</body>
</html>
