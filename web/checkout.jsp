<%-- 
    Document   : checkout
    Created on : Oct 24, 2018, 9:03:14 AM
    Author     : PhuongPyke
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>CheckOut</title>
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
        <nav>
            <div class="row border-bottom pb-3 pt-5">
                <div class="col-sm-2">
                    <h3 class="text-center mt-2"><a href="index.jsp"><img src="images/icons/Victoria-Secret-logo.png" width="50%"/></a></h3>
                </div>
                <div class="col-sm-8 ">
                    <div class="process-wrap">
                        <div class="process text-center active">
                            <p><span>01</span></p>
                            <h3 class="text-danger">Mua Sắm</h3>
                        </div>
                        <div class="process text-center active">
                            <p><span>02</span></p>
                            <h3 class="text-danger">Thanh Toán</h3>
                        </div>
                        <div class="process text-center">
                            <p><span>03</span></p>
                            <h3>Thành Công</h3>
                        </div>
                    </div>
                </div>
                <div class="col-sm-2 mt-3">
                    <img src="https://salt.tikicdn.com/assets/img/hotline.png" height="42" width="176" alt="">
                </div>
            </div>
        </nav>
        <div class="colorlib-product">

            <div class="container">
                <div class="border p-3 w-50">
                    <p>Name:${detailAccount.name}</p>
                    <p>Địa chỉ: ${detailAccount.address} </p>
                    <p>Số điện thoại: ${detailAccount.phone_Number}</p>     
                    <div class="row">
                        <p class="col-md-3"><a href="Delivery" class="btn btn-danger">Giao Hàng</a></p>
                        <p class="col-md-9">
                            <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                Edit
                            </a>
                        </p>
                    </div>
                </div>

                <div class="row collapse" id="collapseExample">
                    <div class="col-lg-8">
                        <form action="CheckOut" method="post" class="colorlib-form">
                            <h2>2. Địa chỉ giao hàng</h2>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="fname">Full Name</label>
                                        <input type="text" name="fullname" id="fname" class="form-control" placeholder="Your fullname">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="country">Số điện thoại</label>
                                        <input type="text" id="fname" name="phone" class="form-control" placeholder="Your phone number">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="companyname">Address</label>
                                        <input type="text" id="companyname" name="address" class="form-control" placeholder="Your address">
                                    </div>
                                </div>
                            </div>
                            <p><button class="btn btn-info" name="btnUpdate" type="submit">Update</button></p>
                        </form>
                    </div>
                </div>
            </div>
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


