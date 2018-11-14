<%-- 
    Document   : userModal-Detail
    Created on : Nov 12, 2018, 2:26:10 PM
    Author     : PhuongPyke
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal" id="myModal">
    <div class="modal-lg modal-dialog-centered " style="margin-left: 35%;">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Mô Tả Chi Tiết Tài Khoản</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
               <table class="table table-bordered text-center" cellspacing="0" width="100%">                  
                    <tr>
                        <th>Name</th>
                        <th>Số Điện Thoại</th>
                        <th>Địa Chỉ</th>
                        <th>Giới Tính</th>                                      
                        <th>Ngày Sinh</th>                            
                    </tr>
                        <tr>
                            <td>${listAccountDetail.name}</td>
                            <td>${listAccountDetail.phone_Number}</td>
                            <td>${listAccountDetail.address}</td>
                            <td>${listAccountDetail.gender==1?"Nam":"Nữ"}</td>
                            <td>19/11/1997</td>
                        </tr>
                </table>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
                <a href="functionAccount?AccountId=${AccountId}" class="btn btn-success">Khóa</a>
                <a href="functionAccount?AccountId=${AccountId}" class="btn btn-success" >Kích Hoạt</a>
                <a href="functionAccount?delete=1&AccountId=${AccountId}" class="btn btn-success" >Xóa</a>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>