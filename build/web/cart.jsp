<%-- 
    Document   : cart
    Created on : Oct 10, 2018, 8:25:22 AM
    Author     : PhuongPyke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>x
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ Hàng</title>
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
        <%@include file="navbar.jsp" %>
        <hr class="container ">

        <div class="container">
         
            <div class="mb-3"><b>Giỏ Hàng</b><i>(${listcart.size()>0?listcart.size():0} sản phẩm)</i></div>

            <c:if test="${empty listcart}">
                <div class="text-center" style="margin-left: 2rem">
                    <img src="images/icons/cart-empty.png"/>
                    <p><c:out value="Không có sản phẩm nào trong giỏ hàng của bạn."/></p>
                    <a href="product.jsp" class="btn bg-primary">Tiếp tục mua sắm</a>
                </div>
            </c:if>
            <c:if test="${not empty listcart}">
                <div class="row">
                    <div class="border col-8 ">
                        <c:forEach items="${listcart}" var="cart">
                            <div class="row p-3 border-bottom">
                                <div class="col-2">
                                    <img src="images/${cart.image}" width="50%" />
                                </div>
                                <div class="col-6">
                                    <p class="p-2">${cart.name}</p>
                                </div>

                                <div class="col-2 p-2">
                                    <div class="input-group ">
                                        <a href="#"><button type="button">-</button></a>
                                        <input type="tel" size="1" class="text-center" min="0"  value="${cart.quantity}" style="display: block;">
                                        <span style="display: none;"></span>
                                        <a href="#"><button class="" type="button">+</button></a>
                                    </div>
                                </div>
                                <div class="col-1 text-center p-2">
                                    <p><fmt:formatNumber value="${cart.price}" type="currency" currencySymbol="" minFractionDigits="0"/>
                                        $</p>
                                </div>
                                <div class="col-1 text-center p-2">
                                    <a class="text-danger" href="reloadcart?productId=${cart.productId}" >Xóa</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col-3 ml-1 " >
                        <div class="border p-2">
                            <p class="font-weight-bold">Tạm Tính :<span class="text-danger float-right ">${total}$</span></p>
                            <hr>
                            <p class="font-weight-bold pb-3">Thành Tiền:<span class="text-danger float-right ">${total}$</span>
                                <span class="float-right text-danger font-weight-light">( Đã bao gồm Phí Ship )</span></p>
                            <hr>
                            <p class="font-weight-light"><i>Miễn Phí Ship nếu đơn hàng trên 200$</i></p>                                              

                        </div>

                        <br>

                        <div class="border p-2">
                            <button type="button" class="btn btn-large btn-block btn-danger " onclick="location.href = 'CheckOut';return false;">Tiến hành đặt hàng</button>
                            <button type="button" class="btn btn-large btn-block bg-info "  onclick="location.href = '#';return false;">Gửi quà tặng</button>
                        </div>
                        <br>
                        <div class="border p-2">
                            <h6 class="panel-title font-weight-bold">Mã giảm giá / Quà tặng</h6>    <hr>
                            <div class="">
                                <div class="input-group">
                                    <input id="coupon" placeholder="Nhập ở đây.." height="10"  class="form-control " value="">
                                    <span class="input-group-btn">
                                        <button class="bg-warning" type="button">Đồng ý</button>
                                    </span>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </c:if>   

        </div>

        <%@include file="footer.jsp" %>
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
