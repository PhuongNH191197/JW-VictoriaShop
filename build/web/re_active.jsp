
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login V2</title>
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
                    <form class="login100-form validate-form" action="resendemail" method="post">
                        <span class="login100-form-title p-b-26">
                            Active Code
                        </span>
                        <span class="login100-form-title p-b-48">
                            <i class="zmdi zmdi-windows"></i>
                        </span>
                        <h5 class="text-danger text-center">${message}</h5>
                        <div class="wrap-input100 validate-input" data-validate = "Code active not empty">
                            <input class="input100" type="text" name="codeactive">
                            <span class="focus-input100" data-placeholder="Enter Code Active"></span>
                        </div>
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button type="submit" class="login100-form-btn">
                                    Active
                                </button>
                            </div>

                        </div>
                        <div class="float-left mt-2">
                            <i><a href="resendemail">Gửi lại Mã kích hoạt</a></i>
                        </div>

                        <div class="text-center p-t-115">
                            <span class="txt1">
                                Don’t have an account?
                            </span>

                            <a class="txt2" href="register.jsp">
                                Sign Up
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
