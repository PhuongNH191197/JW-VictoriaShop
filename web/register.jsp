
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Đăng Kí Tài Khoản</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.png"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min_1.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="css/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="css/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/common/util.css">
        <link rel="stylesheet" type="text/css" href="css/common/main.css">
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form class="login100-form " action="register" method="post">
                        <span class="login100-form-title mb-4 ">
                            Đăng Kí Tài Khoản
                        </span>      
                        <h5 class="text-center text-danger p-2">${message}</h5>
                        <div class="wrap-input100 validate-input" data-validate = "Bạn Phải Nhập Email">
                            <input class="input100" type="text" name="txt_email">
                            <span class="focus-input100" data-placeholder="Nhập Email"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate = "Bạn Phải Nhập Tên">
                            <input class="input100" type="text" name="txt_fullname">
                            <span class="focus-input100" data-placeholder="Họ và Tên"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate = "Bạn Phải Nhập Địa Chỉ">
                            <input class="input100" type="text" name="txt_address">
                            <span class="focus-input100" data-placeholder="Địa Chỉ"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate = "Bạn Phải Nhập SĐT">
                            <input class="input100" type="text" name="txt_phone">
                            <span class="focus-input100" data-placeholder="Số Điện Thoại"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate = "Chọn Giới Tính">
                            <label class="custom-control custom-checkbox mr-4">
                                <input type="radio" class="custom-control-input" value="1" name="gender">
                                <span class="custom-control-indicator"></span>
                                <span class="custom-control-description">Male</span>
                            </label>
                            <label class="custom-control custom-checkbox">
                                <input type="radio" class="custom-control-input" value="0" name="gender">
                                <span class="custom-control-indicator"></span>
                                <span class="custom-control-description">Female</span>
                            </label>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Bạn Phải Nhập Mật Khẩu">
                            <span class="btn-show-pass">
                                <i class="zmdi zmdi-eye"></i>
                            </span>
                            <input class="input100" type="password" name="txt_pwd">
                            <span class="focus-input100" data-placeholder="Mật Khẩu"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Nhập lại Mật Khẩu">
                            <span class="btn-show-pass">
                                <i class="zmdi zmdi-eye"></i>
                            </span>
                            <input class="input100" type="password" name="txt_re-pwd">
                            <span class="focus-input100" data-placeholder="Nhập lại Mật Khẩu"></span>
                        </div>

                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn">
                                    Đăng kí
                                </button>
                            </div>
                        </div>

                        <div class="text-center p-t-20">
                            <span class="txt1">
                                Bạn Đã Có Tài Khoản ?
                            </span>

                            <a class="txt2" href="login.jsp">
                                Đăng Nhập
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/login/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/login/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/login/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/login/moment.min.js"></script>
        <script src="js/login/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="js/login/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/login/login.js"></script>

    </body>
</html>
