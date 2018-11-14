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
                <div class="col-lg-3 border-right">
                    <div class="border mb-2">
                        <div class="border-0">
                            <img src="images/img_avatar.png" alt="John" style="width:50%; border-radius: 50%; margin-left: 4rem;margin-top: 1rem">
                            <p class="text-center mt-2"><button class="btn font-italic ">Chỉnh Sửa </button></p>
                        </div>
                    </div>
                    <div class="nav flex-column nav-pills" >
                        <a class="nav-link " href="profile">Thông Tin Chung</a>
                        <a class="nav-link" href="securityinfor" >Thông Tin Bảo Mật</a>
                        <a class="nav-link active" href="historyBuyProduct"  >Lịch Sử Mua Hàng</a>
                    </div>
                </div>
                <div class="col-lg-9 ">
                    <!--Tab panes--> 
                    <br>
                    <h5>Lịch Sử Mua Hàng</h5>
                    <hr>

                    <table class="table table-bordered text-center" cellspacing="0" width="100%">                  
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tổng  Tiền </th>
                                <th>Trạng Thái</th>
                                <th>Ngày Mua Hàng</th>
                                <th>Lưu Ý </th>
                                <th>Chi Tiết</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listOrder}" var="order">
                                <tr>
                                    <td>${order.id}</td>
                                    <td>${order.totalPrice}$</td>
                                    <td>
                                        <c:if test="${order.status==1}" >
                                            <p class="text-primary">Đang Vận Chuyển</p>
                                        </c:if>
                                        <c:if test="${order.status==2}" >
                                            <p class="text-success">Đã Giao Hàng</p>
                                        </c:if>
                                        <c:if test="${order.status==3}" >
                                            <p class="text-warning">Đợi Trả Hàng</p>
                                        </c:if>
                                        <c:if test="${order.status==4}" >
                                            <p class="text-danger">Đã Hủy</p>
                                        </c:if>
                                    </td>
                                    <td>${order.createDate}</td>
                                    <td>${order.note}</td>
                                    <td><a href="historyBuyProduct?orderId=${order.id}" class="text-danger" >Chi tiết</a></td>
                                </tr>   
                            </c:forEach>


                        </tbody>
                    </table>                     
                </div>
                <!-- The Modal -->
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>


        <c:if test="${listDetail ne null}">
            <script>
                $(document).ready(function () {
                    $('#myModal').modal('show');
                });
            </script>
            <%@include file="userModal-Detail.jsp" %>
        </c:if>



    </body>
</html>
