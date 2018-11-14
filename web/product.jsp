
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="controller" uri="/WEB-INF/tlds/controller" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Sản Phẩm</title>
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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

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
        <c:if test="${listproduct eq null}">
            <c:redirect url="fillter"/>
        </c:if>

        <div class="colorlib-loader"></div>
        <div id="page">
            <%@include file="navbar.jsp" %>
            <!--            <div class="breadcrumbs">
                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                        <p class="bread"><span><a href="index.html">Home</a></span> / <span>Product</span></p>
                                    </div>
                                </div>
                            </div>
                        </div>-->

            <div class="breadcrumbs-two">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="breadcrumbs-img" style="background-image: url(images/sb_1530246933_750.png);">

                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="colorlib-product">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-xl-3">
                            <div class="row">
                                <!--bran-->
                                <div class="col-sm-12">
                                    <div class="side border mb-1">
                                        <h3>Hãng Sản Phẩm</h3>
                                        <ul>
                                            <c:forEach items="${listbrand}" var="brand">
                                                <li><a href="fillter?${urlCategory}idBrand=${brand.id}">${brand.name}</a></li>
                                                </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <!--end brand-->
                                <!--style-->
                                <div class="col-sm-12">
                                    <div class="side border mb-1">
                                        <h3>Loại Sản Phẩm</h3>
                                        <ul>
                                            <c:forEach items="${listcategory}" var="category">
                                                <li><a href="fillter?${urlBrand}categoryId=${category.id}">${category.category}</a></li>
                                                </c:forEach>
                                        </ul>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-lg-9 col-xl-9">
                            <!--product-->
                            <div class="row row-pb-md">
                                <c:forEach items="${listproduct}" var="product">
                                    <div class="col-lg-4 mb-4 text-center">
                                        <div class="product-entry border">
                                            <a href="#" class="prod-img">
                                                <img src="images/${product.imageLink}" class="img-fluid" alt="${product.imageLink}">
                                            </a>
                                            <div class="desc pb-0">
                                                <h2><a href="productdetail?productid=${product.id}">${product.name}</a></h2>
                                                <span class="price">${product.price}$</span>
                                            </div>
                                            <div>
                                                <div class="p-2">
                                                    <c:if test="${product.status==1}">
                                                        <a href="#" class="mr-3 hover_cart  text-success">                                                    
                                                            <i class="fa fa-shopping-bag " aria-hidden="true"></i> Còn Hàng                                                    
                                                        </a>
                                                        <a href="addtocart?productId=${product.id}" class="ml-3 hover_cart">
                                                            <i class="fa fa-shopping-cart " aria-hidden="true"></i> Chọn
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${product.status==2}">
                                                        <a href="#" class="mr-3 hover_cart  text-warning">                                                    
                                                            <i class="fa fa-shopping-basket " aria-hidden="true"></i> Tạm Hết                                                    
                                                        </a>
                                                        <a href="addtocart?productId=${product.id}" class="ml-3 hover_cart disabled" >
                                                            <i class="fa fa-shopping-cart "  aria-hidden="true" ></i> Chọn
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${product.status==3}">
                                                        <a href="#" class="mr-3 hover_cart  text-primary">                                                    
                                                            <i class="fa fa-share " aria-hidden="true"></i> Giảm Giá                                                    
                                                        </a>
                                                        <a href="addtocart?productId=${product.id}" class="ml-3 hover_cart">
                                                            <i class="fa fa-shopping-cart " aria-hidden="true"></i> Chọn
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${product.status==4}">
                                                        <a href="#" class="mr-3 hover_cart  text-danger">                                                    
                                                            <i class="fa fa-arrow-down " aria-hidden="true"></i> Ngừng Sản Xuất                                                    
                                                        </a>
                                                        <a href="addtocart?productId=${product.id}" class="ml-3 hover_cart disabled">
                                                            <i class="fa fa-shopping-cart " aria-hidden="true"></i> Chọn
                                                        </a>
                                                    </c:if>

                                                </div>  
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!--end product-->
                            <div class="row">
                                <div class="col-md-12 text-center">
                                    <div class="block-27">
                                        <ul>
                                            <c:if test="${backPage > 0}">
                                                <li>
                                                    <a href="fillter?page=${backPage}"><i class="ion-ios-arrow-back"></i></a>
                                                </li>
                                            </c:if>
                                            <c:forEach begin="1" end="${pageSize}" step="1" varStatus="pageIndex" >
                                                <li>
                                                    <a href="fillter?page=${pageIndex.count}">${pageIndex.count}</a>
                                                </li>  
                                            </c:forEach>                                         
                                            <c:if test="${nextPage < 5}">
                                                <li>
                                                    <a href="fillter?page=${nextPage}"><i class="ion-ios-arrow-forward"></i></a>
                                                </li>
                                            </c:if>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <!--end brand partent-->
                <%@include file="footer.jsp" %>%>
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

