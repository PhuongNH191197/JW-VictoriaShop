<%-- 
    Document   : productdetail
    Created on : Oct 18, 2018, 9:17:42 AM
    Author     : PhuongPyke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Chi Tiết Sản Phẩm</title>
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
        <script>(function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.1&appId=901500366721234&autoLogAppEvents=1';
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>
    </head>
    <body>

        <div class="colorlib-loader"></div>

        <div id="page">
            <%@include file="navbar.jsp" %>
            <hr class=" container">

            <!--end breadcsrum-->
            <div class="colorlib-product">
                <div class="container">
                    <div class="row row-pb-lg product-detail-wrap">
                        <!--image detail-->
                        <div class="col-sm-8">
                            <div class="owl-carousel">
                                <div class="item">
                                    <div class="product-entry border">
                                        <a href="#" class="prod-img">
                                            <img src="images/${productDetail.imageLink}" class="img-fluid" alt="image_detail_1">
                                        </a>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="product-entry border">
                                        <a href="#" class="prod-img">
                                            <img src="images/item-2.jpg" class="img-fluid" alt="image_detail_2">
                                        </a>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="product-entry border">
                                        <a href="#" class="prod-img">
                                            <img src="images/item-3.jpg" class="img-fluid" alt="image_detail_3">
                                        </a>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="product-entry border">
                                        <a href="#" class="prod-img">
                                            <img src="images/item-4.jpg" class="img-fluid" alt="image_detail_4">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end image detail-->
                        <!--information-->
                        <div class="col-sm-4">
                            <div class="product-desc">
                                <!--name-->
                                <h3>${productDetail.name}</h3> 
                                <p class="price">
                                    <!--gia-->
                                    <span>${productDetail.price}$</span> 
                                    <!--danh gia-->
                                    <span class="rate">
                                        <i class="icon-star-full"></i>
                                        <i class="icon-star-full"></i>
                                        <i class="icon-star-full"></i>
                                        <i class="icon-star-full"></i>
                                        <i class="icon-star-half"></i>
                                        (74 Rating)
                                    </span>
                                    <!--ket thuc danh gia-->
                                </p>
                                <!--mo ta-->
                                <!--end mo ta-->
                                <form action="" method="">
                                    <div class="size-wrap">
                                        <div class="block-26 mb-2">
                                            <h4>Size</h4>
                                            <ul>
                                                <c:forEach items="${listSize}" var="size">
                                                    <input class="mr-1"type="checkbox" name="txt_size" value="${size.size}">${size.size}
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="input-group mb-4">
                                        <span class="input-group-btn">
                                            <button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
                                                <i class="icon-minus2"></i>
                                            </button>
                                        </span>
                                        <input type="text" id="quantity" name="quantity" class="form-control input-number" value="1" min="1" max="100">
                                        <span class="input-group-btn ml-1">
                                            <button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
                                                <i class="icon-plus2"></i>
                                            </button>
                                        </span>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 text-center">
                                            <p class="addtocart"><a href="addtocart?productId=${productDetail.id}" class="btn btn-primary btn-addtocart"><i class="icon-shopping-cart"></i> Add to Cart</a></p>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--end information-->
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="row">
                                <div class="col-md-12 pills">
                                    <div class="bd-example bd-example-tabs">
                                        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">

                                            <li class="nav-item">
                                                <a class="nav-link active" id="pills-description-tab" data-toggle="pill" href="#pills-description" role="tab" aria-controls="pills-description" aria-expanded="true">Miêu Tả Chi Tiết</a>
                                            </li>

                                            <li class="nav-item">
                                                <a class="nav-link" id="pills-review-tab" data-toggle="pill" href="#pills-review" role="tab" aria-controls="pills-review" aria-expanded="true">Ý Kiến Khách Hàng</a>
                                            </li>
                                        </ul>
                                        <!--tab san phan--> 
                                        <div class="tab-content" id="pills-tabContent">
                                            <!--mieu ta san pham-->
                                            <div class="tab-pane border fade show active" id="pills-description" role="tabpanel" aria-labelledby="pills-description-tab">
                                                <p>${productDetail.description}</p>
                                            </div>
                                            <!--end mieu ta san pham-->                                      
                                            <!--review-->
                                            <div class="tab-pane border fade" id="pills-review" role="tabpanel" aria-labelledby="pills-review-tab">
                                                <div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/comments#configurator" data-width="700" data-numposts="5"></div>

                                            </div>
                                            <!--end review-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

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

        <script>

            $(document).ready(function () {

                var quantitiy = 0;
                $('.quantity-right-plus').click(function (e) {

                    // Stop acting like a button
                    e.preventDefault();
                    // Get the field name
                    var quantity = parseInt($('#quantity').val());

                    // If is not undefined

                    $('#quantity').val(quantity + 1);


                    // Increment

                });

                $('.quantity-left-minus').click(function (e) {
                    // Stop acting like a button
                    e.preventDefault();
                    // Get the field name
                    var quantity = parseInt($('#quantity').val());

                    // If is not undefined

                    // Increment
                    if (quantity > 0) {
                        $('#quantity').val(quantity - 1);
                    }
                });

            });
        </script>


    </body>
</html>

