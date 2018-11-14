<%-- 
    Document   : userModal-Detail
    Created on : Nov 12, 2018, 2:26:10 PM
    Author     : PhuongPyke
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal" id="myModal">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Chi Tiết Đơn Hàng</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
                <table class="table table-bordered text-center" cellspacing="0" width="100%">                  
                    <tr>
                        <th>ID</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Số Lượng</th>
                        <th>Giá</th>                                      
                    </tr>
                    <c:forEach items="${listDetail}" var="detail">
                        <tr>
                            <td>${detail.id}</td>
                            <td>${detail.productName}</td>
                            <td>${detail.productQuantity}</td>
                            <td>${detail.productPrice}$</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <a href="DestroyOrder?orderId=${orderId}" class="btn btn-success">Hủy Đơn Hàng</a>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>