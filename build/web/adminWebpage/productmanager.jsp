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
        <title>Product</title>
        <link rel="stylesheet" href="css/bootstrap.min_1.css">
        <link rel="stylesheet" href="css/admin.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    </head>
    <body>
        <c:if test="${listProducts ==null}">
            <c:redirect url="productmanagerservlet"/>
        </c:if>


        <div class="container">
            <div class="row">
                <div class="col-3 ">
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
                <div class="col-9 mb-5"><br>
                    <h5>Quản Lý Sản Phẩm</h5>
                    <hr>

                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#addproduct" aria-expanded="false" aria-controls="collapseExample">
                        Thêm Sản Phẩm Mới
                    </button>
                  
                 
                    <div class="collapse" id="addproduct">
                        <div class="card card-body">
                            <form action="addproduct" accept="image/gif, image/jpeg" method="post">
                                <div class="row">
                                    <div class="col-3"><label>Mã SP:</label></div>
                                    <div class="col-9"><input type="text" name="code" size="10"></div>
                                    <!--<div class="col-6"><button type="submit" class="btn btn-info p-1 mb-2">GetData</button></div>-->
                                </div>
                                <div class="row">
                                    <div class="col-3"><label>Tên Sản Phẩm:</label></div>
                                    <div class="col-9"><input type="text" name="name" size="40"></div>
                                </div>
                                <div class="row">
                                    <div class="col-3"><label>Loại Sản Phẩm:</label></div>
                                    <div class="col-9">
                                        <select name="category">
                                            <c:forEach items="${listCategory}" var="cate">
                                                <option value="${cate.id}">${cate.category}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-3"><label>Giá SP :</label></div>
                                    <div class="col-9"><input type="text" name="price" size="10"><span class="ml-2">$</span></div>
                                </div>
                                <div class="row">
                                    <div class="col-3"><label>Số Lượng:</label></div>
                                    <div class="col-9"><input type="text" name="quantity" size="10"></div>
                                </div>
                                <div class="row">
                                    <div class="col-3"><label>Tình Trạng:</label></div>
                                    <div class="col-9">
                                        <select name="status">
                                            <c:forEach items="${listStatusP}" var="status">
                                                <option value="${status.id}">${status.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-3"><label>Hãng SP:</label></div>
                                    <div class="col-9">
                                        <select name="brand">
                                            <c:forEach items="${listBrand}" var="brand">
                                                <option value="${brand.id}">${brand.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-3"><label>Tải Ảnh Lên</label></div>
                                    <div class="col-9"><input type="file" name="image"></div>
                                </div>
                                <div class="row">
                                    <div class="col-3"><label>Miêu Tả:</label></div>
                                    <div class="col-9">
                                        <textarea cols="50" rows="3" name="description"></textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-3"><label>Lưu Ý:</label></div>
                                    <div class="col-9">
                                        <textarea cols="50" rows="3" name="note"></textarea>
                                    </div>
                                </div>
                                <div class="float-right">
                                    <button type="submit" class="btn btn-info">Thêm</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    
                    <h6 class="mt-3">Danh Sách Sản Phẩm</h6>
                    <hr>
                    <div class="mt-3">
                        <table id="productmanager" class="table table-bordered" cellspacing="0" width="100%">                  
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>Tên Sản Phẩm</th>
                                    <th>Giá</th>
                                    <th>Tình Trạng</th>
                                    <th>Số Lượng</th>
                                    <th>Hãng</th>
                                    <th>Loại</th>
                                    <th>Chi Tiết</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listProducts}" var="listPr">
                                    <tr>
                                        <td>${listPr.id}</td>
                                        <td>${listPr.name}</td>
                                        <td>${listPr.price}$</td>
                                        <td class="text-center">
                                            <c:if test="${listPr.status==1}">
                                                <i class="fa fa-bullseye text-primary" data-toggle="tooltip" data-placement="right" title="Còn Hàng"></i>
                                            </c:if>
                                            <c:if test="${listPr.status==2}">
                                                <i class="fa fa-bullseye text-danger" data-toggle="tooltip" data-placement="right" title="Hết Hàng"></i>
                                            </c:if>
                                            <c:if test="${listPr.status==3}">
                                                <i class="fa fa-bullseye text-success" data-toggle="tooltip" data-placement="right" title="Giảm Giá"></i>
                                            </c:if>
                                            <c:if test="${listPr.status==4}">
                                                <i class="fa fa-bullseye text-warning" data-toggle="tooltip" data-placement="right" title="Ngừng Sản Xuất"></i>
                                            </c:if>
                                        </td>
                                        <td>${listPr.quantity}</td>
                                        <td>${listPr.brand.name}</td>
                                        <td>${listPr.category.category}</td>
                                        <td><a href="productmanagerservlet?productId=${listPr.id}" >Chi tiết</a></td>
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
                $('#productmanager').DataTable();
            });

            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });

        </script>
        <c:if test="${product!=null}">
            <script>
                $(document).ready(function () {
                    $('#myModal').modal('show');
                });
            </script>
            <%@include file="User-modal-detail-product.jsp" %>
        </c:if>


    </body>
</html>
