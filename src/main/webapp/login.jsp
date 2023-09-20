<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
</head>
<body>
<h1>Đăng Nhập</h1>
<form action="ControlServlet" method="post" >
    <label for="username">Tên Đăng Nhập:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="password">Mật Khẩu:</label>
    <input type="password" id="password" name="password" required><br>

    <input type="hidden" name="action" value="login">
    <button type="submit">Đăng Nhập</button>
</form>
</body>
</html>