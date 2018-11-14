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
        <title>Order</title>
        <link rel="stylesheet" href="css/bootstrap.min_1.css">
        <link rel="stylesheet" href="css/admin.css">
    </head>
    <body>
        <c:if test="${listOrder ==null}">
            <c:redirect url="orderManagerServlet"/>
        </c:if>


        <div class="container">
            <div class="row">
                <div class="col-3">
                    <h1 class="pl-4">LOGO</h1>
                </div>
                <div class="col-9">
                    <p class="fixlogout text-sm-right mt-3"><span class="text-info">Xin Chào :</span><c:out  value="${sessionScope.currentLoginAccount.email}"/>
                        <span> <a class="fixlogout " href="logout">Đăng Xuất</a></span>
                    </p>
                </div>
            </div>            <hr>
            <!-- Nav tabs -->
            <div class="row">
                <%@include  file="menuAdmin.jsp" %>
                <!-- Tab panes -->
                <div class="col-9"><br>
                    <h5>Quản Lý Đơn Hàng</h5>
                    <hr>
                    <div>
                        <table id="ordermanager" table class="table table-bordered" cellspacing="0" width="100%">                  
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>Mã Tài Khoản</th>
                                    <th>Tổng Giá</th>
                                    <th>Trạng Thái</th>
                                    <th>Ngày Mua</th>
                                    <th>Lưu ý</th>
                                    <th>Chi Tiết</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listOrder}" var="listOr">
                                    <tr>
                                        <td>${listOr.id}</td>
                                        <td>${listOr.accountId}</td>
                                        <td>${listOr.totalPrice}$</td>
                                        <td>
                                            <c:if test="${listOr.status==1}" >
                                                <p class="text-primary">Đang Vận Chuyển</p>
                                            </c:if>
                                            <c:if test="${listOr.status==2}" >
                                                <p class="text-success">Đã Giao Hàng</p>
                                            </c:if>
                                            <c:if test="${listOr.status==3}" >
                                                <p class="text-warning">Đợi Trả Hàng</p>
                                            </c:if>
                                            <c:if test="${listOr.status==4}" >
                                                <p class="text-danger">Đã Hủy</p>
                                            </c:if>
                                        </td>
                                        <td>${listOr.createDate}</td>
                                        <td>${listOr.note}</td>
                                        <td><a href="orderManagerServlet?orderId=${listOr.id}" ><i class="text-danger">Chi tiết</i></a></td>
                                    </tr>   
                                </c:forEach>
                            </tbody>
                        </table>
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


            $(document).ready(function () {
                $('#ordermanager').DataTable();
            });

        </script>
        <c:if test="${listDetail ne null}">
            <script>
                $(document).ready(function () {
                    $('#myModal').modal('show');
                });
            </script>
            <%@include file="User-modal-detail-order.jsp" %>
        </c:if>

    </body>
</html>
