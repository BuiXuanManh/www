<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Thêm Tài Khoản</title>
  <!-- Sử dụng Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h2 class="text-center">Thêm Tài Khoản</h2>
  <form action="ControlServlet" method="post">
    <div class="form-group">
      <label for="newUsername">Tên Đăng Nhập *:</label>
      <input type="text" class="form-control" id="newUsername" name="newUsername" required>
    </div>
    <div class="form-group">
      <label for="newPassword">Mật Khẩu *:</label>
      <input type="password" class="form-control" id="newPassword" name="newPassword" required>
    </div>
    <div class="form-group">
      <label for="fullName">Ho Tên *:</label>
      <input type="text" class="form-control" id="fullName" name="fullName" required>
    </div>
    <div class="form-group">
      <label for="email">Email *:</label>
      <input type="text" class="form-control" id="email" name="email" required>
    </div>
    <div class="form-group">
      <label for="phone">Phone *:</label>
      <input type="text" class="form-control" id="phone" name="phone" required>
    </div>
    <input type="hidden" name="action" value="addAccount">
    <button type="submit" class="btn btn-primary">Register</button>
  </form>
</div>

<!-- Sử dụng Bootstrap JS và jQuery (tùy chọn) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

