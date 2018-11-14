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
                        <a class="nav-link active" href="profile">Thông Tin Chung</a>
                        <a class="nav-link " href="securityinfor" >Thông Tin Bảo Mật</a>
                        <a class="nav-link" href="historyBuyProduct">Lịch Sử Mua Hàng</a>
                    </div>
                </div>
                <div class="col-9 ">

                    <h3>Thông Tin Cơ bản</h3>
                    <div class="border-dashed">
                        <table>
                            <tr >
                                <th>Họ Tên :</th>
                                <td>&nbsp;</td>
                                <td>${acDetail.name}</td>      
                            </tr>
                            <tr >
                                <th>Giới Tính :</th>
                                <td>&nbsp;</td>
                                <td>${acDetail.gender==0?"Nữ":"Nam"}</td>                                           
                            </tr>
                            <tr >
                                <th>Email :</th>
                                <td>&nbsp;</td>
                                <td>${account.email}</td>      
                            </tr>
                            <tr >
                                <th>Địa Chỉ :</th>
                                <td>&nbsp;</td>
                                <td>${acDetail.address}</td>
                            </tr> 
                            <tr >
                                <th>Số Điện Thoại :</th>
                                <td>&nbsp;</td>
                                <td>${acDetail.phone_Number}</td>
                            </tr>


                            <tr >
                                <th>Trạng Thái:</th>
                                <td>&nbsp;</td>
                                <td><i class="text-success">Đang Hoạt Động</i></td>
                            </tr>   
                            <tr >
                                <th>Loại Tài Khoản:</th>
                                <td>&nbsp;</td>
                                <c:if test="${role.name ne null}">
                                    <td><i class="text-success">Khách Hàng</i></td>
                                </c:if>

                            </tr>
                            <tr >
                                <th>Ngày Kích Hoạt:</th>
                                <td>&nbsp;</td>
                                <td>${account.createdDate}</td>
                            </tr>  
                            <tr>
                                <td> <p class="mt-3">
                                        <a class="btn btn-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                            Chỉnh Sửa
                                        </a>                                
                                    </p>
                                </td>
                            </tr>
                        </table>
                        <div class="collapse" id="collapseExample">
                            <div class="card card-body">
                                <form action="profile" method="post">
                                    <div class="row">
                                        <div class="col-3 text-center mt-3">
                                            <label><b>Họ và Tên :</b></label>                                                   
                                        </div>
                                        <div class="col-9">
                                            <input type="text" name="fullname" height="20" size="40">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-3 text-center mt-3">
                                            <label><b>Giới Tính :</b></label>                                                   
                                        </div>
                                        <div class="col-9 ">
                                            <div class="pt-2 pl-4 row">
                                                <div class="form-check ">
                                                    <input class="form-check-input" type="radio" name="gender" id="exampleRadios1" value="1" checked>
                                                    <label class="form-check-label" for="exampleRadios1">
                                                        Nam
                                                    </label>
                                                </div>
                                                <div class="form-check ml-3">
                                                    <input class="form-check-input " type="radio" name="gender" id="exampleRadios2" value="0">
                                                    <label class="form-check-label" for="exampleRadios2">
                                                        Nữ
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-3 text-center mt-3">
                                            <label><b>Số Điện Thoại:</b></label>                                                   
                                        </div>
                                        <div class="col-9">
                                            <input type="text" name="phone" height="20">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-3 text-center mt-3">
                                            <label ><b>Địa Chỉ:</b></label>                                                   
                                        </div>
                                        <div class="col-9">
                                            <textarea  name="address" rows="4" cols="40"></textarea>
                                        </div>
                                    </div>                                    
                                    <div class="float-right">
                                        <button class="btn btn-info" type="submit">Cập Nhập</button>
                                    </div>
                                </form>
                            </div>
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
