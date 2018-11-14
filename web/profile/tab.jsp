
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="border mb-2">
    <div class="border-0">
        <img src="../images/img_avatar.png" alt="John" style="width:50%; border-radius: 50%; margin-left: 4rem;margin-top: 1rem">
        <p class="text-center mt-2"><button class="btn font-italic ">Chỉnh Sửa </button></p>
    </div>
</div>
<div class="nav flex-column nav-pills" >
    <a class="nav-link " href="profile">Thông Tin Chung</a>
    <a class="nav-link" href="#v-pills-profile" >Thông Tin Bảo Mật</a>
    <a class="nav-link" href="#v-pills-settings" role="tab" >Lịch Sử Mua Hàng</a>
</div>

        <h3>Thông Tin Liên hệ</h3>
                    <div class="border">                    
                        <table>
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
                                <td>${acDetail.phone}</td>

                            </tr>
                            <tr>
                                <td> <p class="mt-3">
                                        <a class="btn btn-info" data-toggle="collapse" href="#information" role="button" aria-expanded="false" >
                                            Chỉnh Sửa
                                        </a>                                
                                    </p>
                                </td>
                            </tr>

                        </table>
                        <div class="collapse" id="information">
                            <div class="card card-body">
                                <form action="#" method="post">
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
                                        <div class="col-9">
                                            <input type="text" name="gender" height="20">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-3 text-center mt-3">
                                            <label><b>Tuổi:</b></label>                                                   
                                        </div>
                                        <div class="col-9">
                                            <input type="text" name="age" height="20">
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