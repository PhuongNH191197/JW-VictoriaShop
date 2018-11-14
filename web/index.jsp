<%-- 
    Document   : index
    Created on : 17-Oct-2018, 02:40:48
    Author     : PhuongPyke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trang Chủ</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700" rel="stylesheet">
        <!-- Animate.css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="css/icomoon.css">
        <!-- Ion Icon Fonts-->
        <link rel="stylesheet" href="css/ionicons.min.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.min_1.css">
        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/magnific-popup.css">
        <!-- Flexslider  -->
        <link rel="stylesheet" href="css/flexslider.css">
        <!-- Owl Carousel -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <!-- Date Picker -->
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <!-- Flaticons  -->
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <!-- Theme style  -->
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>

        <div class="colorlib-loader"></div>
        <div id="page">
            <%@include file="navbar.jsp" %>
            <aside id="colorlib-hero">
                <div class="flexslider">
                    <ul class="slides">
                        <li style="background-image: url(images/img_bg_1.jpg);">
                            <div class="overlay"></div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-6 offset-sm-3 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <div class="desc">
                                                <h1 class="head-1">Chào Mừng Bạn </h1>
                                                <h2 class="head-2">Đến Với</h2>
                                                <h2 class="head-3">Victoria</h2>
                                                <p class="category"><span>Khai Trương vào 29/11</span></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li style="background-image: url(images/img_bg_2.jpg);">
                            <div class="overlay"></div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-6 offset-sm-3 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <div class="desc">
                                                <h1 class="head-1">VICTORIA</h1>
                                                <h2 class="head-2">Giảm Giá</h2>
                                                <h2 class="head-3"><strong class="font-weight-bold">50%</strong> Off</h2>
                                                <p class="category"><span>Ưu Đãi Lớn</span></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li style="background-image: url(images/img_bg_3.jpg);">
                            <div class="overlay"></div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-6 offset-sm-3 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <div class="desc ">
                                                <h1 class="head-1 text-danger">Sản Phẩm Mới</h1>
                                                <h2 class="head-2 text-danger ">Khai Trương</h2>
                                                <h2 class="head-3 text-danger">Giảm <strong class="font-weight-bold">20%</strong>Tất cả mặt hàng</h2>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </aside>

            <c:if test="${listproduct eq null}">
                <c:redirect url="loadIndex"/>
            </c:if>
            <div class="colorlib-product">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
                            <h2>Giá Tốt Nhất</h2>
                        </div>
                    </div>

                    <div class="row row-pb-md">
                        `<c:forEach items="${listproduct}" begin="1" end="6" step="1" var="product">                        
                            <div class="col-lg-3 mb-4 text-center">
                                <div class="product-entry border">
                                    <a href="#" class="prod-img">
                                        <img src="images/${product.imageLink}" class="img-fluid" alt="${product.imageLink}">
                                    </a>
                                    <div class="desc">
                                        <h2><a href="productdetail?productid=${product.id}">${product.name}</a></h2>
                                        <span class="price">${product.price}$</span>
                                    </div>

                                    <div>
                                        <div class="p-2">
                                            <a href="#" class="mr-3 hover_cart">
                                                <i class="fa fa-shopping-bag " aria-hidden="true"></i> Còn Hàng
                                            </a>
                                            <a href="addtocart?productId=${product.id}" class="ml-3 hover_cart">
                                                <i class="fa fa-shopping-cart " aria-hidden="true"></i> Chọn
                                            </a>
                                        </div>  
                                    </div>
                                </div>
                            </div>
                        </c:forEach>



                    </div>
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <p><a href="product.jsp" class="btn btn-primary btn-lg">Hiện Thị Tất Cả Sản Phẩm</a></p>
                        </div>
                    </div>
                </div>



                <%@include file="footer.jsp" %>
            </div>
            <div class="gototop js-top">
                <a href="#" class="js-gotop"><i class="ion-ios-arrow-up"></i></a>
            </div>

            <!-- jQuery -->
            <script src="js/jquery.min.js"></script>
            <!-- popper -->
            <script src="js/popper.min.js"></script>
            <!-- bootstrap 4.1 -->
            <script src="js/bootstrap.min.js"></script>
            <!-- jQuery easing -->
            <script src="js/jquery.easing.1.3.js"></script>
            <!-- Waypoints -->
            <script src="js/jquery.waypoints.min.js"></script>
            <!-- Flexslider -->
            <script src="js/jquery.flexslider-min.js"></script>
            <!-- Owl carousel -->
            <script src="js/owl.carousel.min.js"></script>
            <!-- Magnific Popup -->
            <script src="js/jquery.magnific-popup.min.js"></script>
            <script src="js/magnific-popup-options.js"></script>
            <!-- Date Picker -->
            <script src="js/bootstrap-datepicker.js"></script>
            <!-- Stellar Parallax -->
            <script src="js/jquery.stellar.min.js"></script>
            <!-- Main -->
            <script src="js/main.js"></script>

    </body>
</html>


