<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="colorlib-nav" role="navigation">
    <div class="top-menu">
        <div class="container">
            <div class="row">
                <div class="col-sm-5 ">
                    <div id="colorlib-logo"><a href="index.jsp"><img src="images/icons/Victoria-Secret-logo.png" width="30%"/></a></div>
                </div>
                <div class="col-sm-3 pt-4">
                    <form action="fillter" method="post" class="search-wrap">
                        <div class="form-group">
                            <input type="search" name="txtsearch"class="form-control search" placeholder="Tìm kiếm Sản Phẩm">
                            <button class="btn btn-primary submit-search text-center" type="submit"><i class="icon-search"></i></button>
                        </div>
                    </form>
                </div>
                <div class="col-sm-4 pt-4">
                    <c:choose>
                        <c:when test="${currentLoginAccount eq null}">
                            <div class="float-right">
                                <button class="btn btn-group btn-info " style="padding: 2px 20px;" type="button" onclick="window.location.href = 'login.jsp'">Đăng Nhập</button>
                                <button class="btn btn-group btn-danger " style="padding: 2px 20px;" type="button" onclick="window.location.href = 'register.jsp'">Đăng Kí</button>
                            </div>
                        </c:when>
                        <c:otherwise>

                            <div class="nav-item dropdown  pt-2">
                                <a class="dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <c:out  value="${sessionScope.currentLoginAccount.email}"/>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="profile">Thông tin cá nhân</a>                                
                                    <a class="dropdown-item" href="changePassword.jsp">Đổi mật khẩu</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="logout">Đăng xuất</a>
                                </div>
                            </div>     
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="col">
                <div class="col-sm-12 text-left menu-1">
                    <ul>
                        <li class="active"><a href="index.jsp">Trang Chủ</a></li>                   
                        <li><a href="product.jsp">Sản Phẩm</a></li>
                        <li><a href="about.jsp">Mẹo Vặt</a></li>
                        <li><a href="contact.jsp">Liên Hệ</a></li>                                   
                        <li ><a href="cart.jsp"><i class="icon-shopping-cart"></i> Giỏ Hàng [${listcart.size()>0?listcart.size():0}]</a></li>
                    </ul>
                </div>




            </div>
        </div>
    </div>
</nav>


