<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container justify-content-center">
    <div class="row">
        <h1>Đăng Nhập</h1>
    </div>
    <form action="ControlServlet?action=login" method="post" >
        <div class="form-group">
            <label >Tên Đăng Nhập:</label>
            <input type="text" class="form-control" name="username" required>
        </div>
        <div class="form-group">
            <label >Mật Khẩu:</label>
            <input type="password" class="form-control" name="password" required><br>
        </div>
        <button type="submit" class="btn btn-primary">Đăng Nhập</button>
    </form>
</div>


</body>
</html>