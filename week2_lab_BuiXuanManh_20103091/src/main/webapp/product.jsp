<%--
  Created by IntelliJ IDEA.
  User: bmanh
  Date: 9/23/2023
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>Danh sách sản phẩm</h1>
    <div class="row">
        <c:forEach items="${products}" var="product">

            <div class="col-lg-3 col-md-3 col-sm-3">
                <div class="card mb-4 shadow-sm">
                    <img class="card-img-top" th:src="@{|${product.path}|}" alt=""/>
                    <div class="card-body">
                        <h5 class="card-title" th:text="${product.product.name}"></h5>
                        <p class="card-text" th:text="${product.product.}"></p>
                        <div class="d-flex justify-content-between align-items-center">
                            <small class="text-muted" th:text="${product.price}"></small>
                            <div class="btn-group">
                                <a th:href="@{|/products/${product.id}|}" class="btn btn-sm btn-outline-secondary">Xem
                                    chi tiết</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<!-- Liên kết Bootstrap JS (tùy chọn) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
