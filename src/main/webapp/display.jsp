<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ControlServlet" method="post">
    <h2>Hiển Thị Thông Tin Tài Khoản</h2>
    <label >Tên Đăng Nhập:</label>
    <h4 name="username"><%=request.getAttribute("username") %></h4>
    <input type="hidden" name="action" value="displayAccountInfo">
    <button type="submit">Hiển Thị Thông Tin</button>
</form>

</body>
</html>
