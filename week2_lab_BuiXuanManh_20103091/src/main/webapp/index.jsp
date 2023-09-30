<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Product" %>
<%@ page import="vn.edu.iuh.fit.backend.models.ProductImage" %>
<%@ page import="vn.edu.iuh.fit.backend.models.ProductPrice" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="./template/header.jsp"/>
</head>

<body>
<%String urlProductDetails = request.getContextPath() + "/product-details";%>
<!--
Upper Header Section
-->
<jsp:include page="template/navbar-fix-top.jsp"/>
<!--
Lower Header Section 
-->
<div class="container">

    <!--
Navigation Bar Section 
-->
    <!--
Body Section 
-->
    <div class="row">
        <div class="span9">
            <div class="well np">
                <div id="myCarousel" class="carousel slide homCar">
                    <div class="carousel-inner">
                        <div class="item">
                            <img style="width:100%" src="assets/img/bootstrap_free-ecommerce.png"
                                 alt="bootstrap ecommerce templates">
                            <div class="carousel-caption">
                                <h4>WWW programming with Java technology</h4>
                                <p><span>Very clean simple to use</span></p>
                            </div>
                        </div>

                        <div class="item active">
                            <img style="width:100%" src="assets/img/carousel3.png" alt="bootstrap ecommerce templates">
                            <div class="carousel-caption">
                                <h4>WWW programming with Java technology</h4>
                                <p><span>Very easy to integrate and expand.</span></p>
                            </div>
                        </div>
                        <div class="item">
                            <img style="width:100%" src="assets/img/bootstrap-templates.png" alt="bootstrap templates">
                            <div class="carousel-caption">
                                <h4>WWW programming with Java technology</h4>
                                <p><span>Compitable to many more opensource cart</span></p>
                            </div>
                        </div>
                    </div>
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
                </div>
            </div>
            <!--
New Products
-->
            <% List<Product> products = (List<Product>) request.getAttribute("products");
                List<Product> bestProc = (List<Product>) request.getAttribute("bestProc");
            %>
            <div class="well well-small">
                <h3>New Products </h3>
                <hr class="soften"/>
                <div class="row-fluid">
                    <div id="newProductCar" class="carousel slide">
                        <div class="carousel-inner">
                            <%
                                int numPage = products.size() / 4;
                                for (int index = 0; index < numPage; index++) {%>
                            <div class="item <%=index==0?"active":""%>">
                                <ul class="thumbnails">
                                    <li class="span3">
                                        <div class="thumbnail">
                                            <a class="zoomTool"

                                               title="add to cart"><span
                                                    class="icon-search"></span> QUICK VIEW</a>
                                            <a href="#" class="tag"></a>
                                            <a href="#">
                                                <img src="assets/img/a.jpg"
                                                     alt="bootstrap-ring">
                                            </a>
                                        </div>
                                    </li>
                                            }
                                        }

                                </ul>
                            </div>
                            <%}%>
                        </div>
                        <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>
                        <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <ul class="thumbnails">
                        <%
                            for (int index = 0; index < 3; index++) {
                                Product proc = products.get(index);

                        %>
                        <li class="span4">
                            <div class="thumbnail">
                                <a class="zoomTool" href="<%= urlProductDetails+"?id="+proc.getProductId()%>"
                                   title="add to cart"><span
                                        class="icon-search"></span>
                                    QUICK VIEW</a>
                                <a href="<%= urlProductDetails+"?id="+proc.getProductId()%>">
                                    <img src="assets/img/b.jpg" alt="">
                                </a>
                                <div class="caption cntr">
                                    <p>Manicure & Pedicure</p>
                                    <p><strong> $<%=proc.getUnit()%>
                                    </strong></p>
                                    <h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
                                    <div class="actionList">
                                        <a class="pull-left" href="#">Add to Wish List </a>
                                        <a class="pull-left" href="#"> Add to Compare </a>
                                    </div>
                                    <br class="clr">
                                </div>
                            </div>
                        </li>
                        
                                }
                            }

                    </ul>
                </div>
            </div>
            <!--
Featured Products
-->
            <div class="well well-small">
                <h3><a class="btn btn-mini pull-right" href="products.html" title="View more">VIew More<span
                        class="icon-plus"></span></a> Featured Products </h3>
                <hr class="soften"/>
                <div class="row-fluid">
                    <ul class="thumbnails">
                        <%
                            for (Product e : bestProc) {

                        %>
                        <li class="span4" id="customli">
                            <div class="thumbnail">
                                <a class="zoomTool" href="<%= urlProductDetails+"?id="+e.getProductId()%>"
                                   title="add to cart"><span
                                        class="icon-search"></span>
                                    QUICK VIEW</a>
                                <a href="<%= urlProductDetails+"?id="+e.getProductId()%>">
                                    <img src="assets/img/c.jpg" alt="">
                                </a>
                                <div class="caption">
                                    <h5>Manicure & Pedicure</h5>
                                    <h4>
                                        <a class="defaultBtn" href="<%= urlProductDetails+"?id="+e.getProductId()%>"
                                           title="Click to view"><span
                                                class="icon-zoom-in"></span></a>
                                        <a class="shopBtn" href="#" title="add to cart"><span class="icon-plus"></span></a>
                                        <span class="pull-right"><%e.getUnit();%></span>
                                    </h4>
                                </div>
                            </div>
                        </li>
                        <%
                                }
                            }
                        %>

                    </ul>
                </div>
            </div>

            <div class="well well-small">
                <a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
                Popular Products
            </div>
            <hr>
            <div class="well well-small">
                <a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
                Best selling Products
            </div>
        </div>
    </div>
</div><!-- /container -->

<!-- Placed at the end of the document so the pages load faster -->

</body>

</html>