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

    </head>
    <body>
        <c:if test="${listAccount ==null}">
            <c:redirect url="accountmanager"/>
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
            </div>

            <hr>
            <!-- Nav tabs -->
            <div class="row">
                <%@include  file="menuAdmin.jsp" %>
                <!-- Tab panes -->
                <div class="col-9"><br>
                    <h5>Quản Lý Nhân Viên</h5>
                    <hr>
                    <div>
                        <table id="employeemanager" table class="table table-bordered display text-center" cellspacing="0" width="100%">                  
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Địa Chỉ Email</th>
                                    <th>Quyền Hành</th>
                                    <th>Tình Trạng</th>
                                    <th>Ngày Tạo</th>
                                    <th>Chi Tiết</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listAccount}" var="listAc">
                                    <tr>
                                        <td>${listAc.id}</td>
                                        <td>${listAc.email}</td>
                                        <td>
                                            <c:if test="${listAc.roleId==1}">
                                                <p class="text-danger">Admin</p>
                                            </c:if>
                                            <c:if test="${listAc.roleId==2}">
                                                <p class="text-info">Khách hàng</p>
                                            </c:if>

                                        </td>
                                        <td>
                                            <c:if test="${listAc.status==1}">
                                                <p class="text-success">Kích Hoạt</p>
                                            </c:if>
                                            <c:if test="${listAc.status==2}">
                                                <p class="text-warning">Chờ Duyệt</p>
                                            </c:if>
                                            <c:if test="${listAc.status==3}">
                                                <p class="text-danger">Khóa</p>
                                            </c:if>
                                        </td>
                                        <td>${listAc.createdDate}</td>
                                        <td><a href="accountmanager?AccountId=${listAc.id}" class="text-danger" >Chi tiết</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <%@include file="User-modal-detai-accountl.jsp" %>
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
                $('#employeemanager').DataTable();
            });

        </script>
        <c:if test="${listAccountDetail!=null}">
            <script>
                $(document).ready(function () {
                    $('#myModal').modal('show');
                });
            </script>
        </c:if>


    </body>
</html>
