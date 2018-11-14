<%-- 
    Document   : contact
    Created on : Oct 24, 2018, 11:29:39 AM
    Author     : PhuongPyke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Liên Hệ</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">



        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

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

        <div id="page">
            <%@include file="navbar.jsp" %>

            <div id="colorlib-contact">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <h3>Thông tin Liên lạc</h3>
                            <div class="row contact-info-wrap">
                                <div class="col-md-3">
                                    <p><span><i class="icon-location"></i></span> Thạch Hòa, Thạch Thất, Hà Nội </p>
                                </div>
                                <div class="col-md-3">
                                    <p><span><i class="icon-phone3"></i></span> <a href="tel://01657123633"> 01657 123 633</a></p>
                                </div>
                                <div class="col-md-3">
                                    <p><span><i class="icon-paperplane"></i></span> <a href="mailto:info@yoursite.com">phuongpyke@gmail.com</a></p>
                                </div>
                                <div class="col-md-3">
                                    <p><span><i class="icon-globe"></i></span> <a href="#">thebodyhug.com</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="contact-wrap">
                                <h3>Liên Lạc</h3>
                                <form action="#" class="contact-form">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="fname">Tên</label>
                                                <input type="text" id="fname" class="form-control" placeholder="Tên của bạn">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="lname">Họ</label>
                                                <input type="text" id="lname" class="form-control" placeholder="Họ của bạn">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="email">Địa chỉ Email</label>
                                                <input type="text" id="email" class="form-control" placeholder="Địa chỉ hòm thư của bạn">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="subject">Thông điệp</label>
                                                <input type="text" id="subject" class="form-control" placeholder="Viết thông điệp của bạn ...">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="message">Tin nhắn</label>
                                                <textarea name="message" id="message" cols="30" rows="10" class="form-control" placeholder="Viết cái gì đó vào đây"></textarea>
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <input type="submit" value="Gửi tin nhắn" class="btn btn-primary">
                                            </div>
                                        </div>
                                    </div>
                                </form>		
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div id="map" style="width:100%;height:400px;">

                                <script src="js/map.js"></script>
                                <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2LlIj3sk2akFpnpNcXzX9_NS08Xda1sE&callback=myMap"></script>
                                <div class="address">
                                    <div class="address1">
                                        <h2 class="text-center">Địa Chỉ</h2>
                                        <ul>
                                            <li><i class="fa fa-map-marker" aria-hidden="true"></i><span>Địa Chỉ : FPT University Hòa Lạc.</span></li>
                                            <li><i class="fa fa-envelope" aria-hidden="true"></i><span>Email:phuongpyke@gmail.com</span></li>
                                            <li><i class="fa fa-phone" aria-hidden="true"></i><span>SĐT : (+84) 1657 123 633</span></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>	
                        </div>
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
        <!-- Google Map -->

        <!-- Main -->
        <script src="js/main.js"></script>

    </body>
</html>


