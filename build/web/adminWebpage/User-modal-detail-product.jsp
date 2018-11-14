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
                <h4 class="modal-title">Mô Tả Chi Tiết Sản Phẩm</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
                <form action="updateProduct" accept="image/gif, image/jpeg" method="post">
                    <input hidden value="${product.id}" name="id"/>
                    <div class="row">
                        <div class="col-3"><label>Mã SP:</label></div>
                        <div class="col-9"><input type="text" name="code" size="10" value="${product.code}"></div>
                        <!--<div class="col-6"><button type="submit" class="btn btn-info p-1 mb-2">GetData</button></div>-->
                    </div>
                    <div class="row">
                        <div class="col-3"><label>Tên Sản Phẩm:</label></div>
                        <div class="col-9"><input type="text" name="name" value="${product.name}" size="40"></div>
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
                        <div class="col-9"><input type="text" name="price" value="${product.price}" size="10"><span class="ml-2">$</span></div>
                    </div>
                    <div class="row">
                        <div class="col-3"><label>Số Lượng:</label></div>
                        <div class="col-9"><input type="text" name="quantity"  value="${product.quantity}" value="" size="10"></div>
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
                        <div class="col-9"><input type="file" value="${product.imageLink}" name="image"></div>
                    </div>
                    <div class="row">
                        <div class="col-3"><label>Miêu Tả:</label></div>
                        <div class="col-9">
                            <textarea cols="40" rows="5"  name="description">${product.description}</textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3"><label>Lưu Ý:</label></div>
                        <div class="col-9">
                            <textarea cols="40" rows="2" name="note" >${product.note}</textarea>
                        </div>
                    </div>
                    <div class="float-right mt-4">
                        <button type="submit" class="btn btn-info">Chỉnh Sửa</button>
                        <a href="deleteProduct?productId=${product.id}" class="btn btn-success">Xóa</a>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>