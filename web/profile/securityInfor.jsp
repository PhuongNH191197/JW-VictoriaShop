<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : admin
    Created on : Oct 29, 2018, 11:35:05 AM
    Author     : PhuongPyke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link rel="stylesheet" href="css/bootstrap.min_1.css">
        <link rel="stylesheet" href="css/admin.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/icomoon.css">

    </head>
    <body>

        <div class="container">
            <%@include file="../navbar.jsp" %>
            <hr>
            <!-- Nav tabs -->
            <div class="row">
                <div class="col-3 border-right">
                    <div class="border mb-2">
                        <div class="border-0">
                            <img src="images/img_avatar.png" alt="John" style="width:50%; border-radius: 50%; margin-left: 4rem;margin-top: 1rem">
                            <p class="text-center mt-2"><button class="btn font-italic ">Chỉnh Sửa </button></p>
                        </div>
                    </div>
                    <div class="nav flex-column nav-pills" >
                        <a class="nav-link " href="profile">Thông Tin Chung</a>
                        <a class="nav-link active" href="securityinfor" >Thông Tin Bảo Mật</a>
                        <a class="nav-link" href="historyBuyProduct">Lịch Sử Mua Hàng</a>
                    </div>
                </div>
                <div class="col-9 ">                        
                    <h3 >Thay đổi mật khẩu</h3>
                    <div class="border-dashed">
                        <table>
                            <tr>
                                <th>Tên đầy đủ :</th>
                                <td>&nbsp;</td>
                                <td>Nguyễn Hữu Phương</td>

                            </tr>
                            <tr>
                                <th>Địa Chỉ Email :</th>
                                <td>&nbsp;</td>
                                <td>phuongnhse05047@fpt.edu.vn</td>
                            </tr>
                            <tr>
                                <th>Mật khẩu :</th>
                                <td>&nbsp;</td>
                                <td>***********</td>
                            </tr>
                            <tr>
                                <td> <p class="mt-3">
                                        <a class="btn btn-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                            Đổi Mật Khẩu
                                        </a>                                
                                    </p></td>

                            </tr>
                        </table>

                        <div class="collapse" id="collapseExample">
                            <form action="changepassword" method="post">
                                <div class="card card-body">
                                    <table >
                                        <tr>
                                            <th>Mật Khẩu hiện Tại:</th>
                                            <td><input type="password" name="oldpassword"/></td>
                                        </tr>
                                        <tr>
                                            <th>Mật Khẩu Mới:</th>    
                                            <td><input type="password" name="newpassword"/></td>
                                        </tr>
                                        <tr>
                                            <th>Xác Nhận Mật Khẩu Mới:</th>      
                                            <td><input type="password" name="renewpassword"/></td>
                                        </tr>

                                    </table>
                                    <div class="mt-4">
                                        <button type="submit" class="btn btn-info float-right" >Cập Nhập</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <h3 >Mạng Xã Hội</h3>
                    <div class="border-dashed">
                        <table>

                            <tr>
                                <th><i class="icon-facebook" style="font-size: x-large; color: blue"></i><span>Facebook</span></th>
                                <td>&nbsp;</td>
                                <td><a class="btn btn-info" href="#">Kết Nối</a></td>
                            </tr>
                            <tr>
                                <th><i class="icon-twitter" style="font-size: x-large;color: blue"></i><span>Twitter</span></th>
                                <td>&nbsp;</td>
                                <td><a class="btn btn-info" href="#">Kết Nối</a></td>
                            </tr>
                        </table>                          
                    </div>

                </div>


            </div>
        </div>


    </div>




    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="js/jquery.dataTables.min.js"></script>
    <script>

        $('#myTab a').on('click', function (e) {
            e.preventDefault()
            $(this).tab('show')
        })

    </script>


</body>
</html>
