/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author phuon
 */
public interface IMessageConfig {

    //login
    public static final String LOGIN_FAIL = "Sai email hoặc mật khẩu !";
    public static final String NOT_ACTIVE = "Tài khoản của bạn chưa được kích hoạt";
    public static final String LOGIN_SUCCESS = "Đăng nhập thành công";
    // register
    public static final String REGISTER_SUCCESS = "Đăng kí thành công mời bạn  kiểm tra email để nhận mã kích hoạt";
    public static final String REGISTER_FAIL = "Email đã tồn tại mời dùng email khác";
    // email
    public static final String EMAIL_OUT_OF_FROME = "Email không đúng định dạng";
    public static final String DUPLICATE_EMAIL = "Email đã tồn tại ";
    //password
    public static final String PASSWORD_NOT_THE_SAME = "Mật khẩu phải trùng khớp nhau";
    public static final String VALIDATE_PASSWORD = "Mật khẩu phải dài hơn 8 kí tự và bắt buộc có một chữ hoa và chữ số ";
    // codeactive
    public static final String ACTIVE_FAIL = "Mã kích hoạt của bạn không tồn tại";
    public static final String CODE_ACTIVE = "Mã kích hoạt đã được gửi đến email";
    public static final String ACTIVE_SUCCSESS = " Chúc mừng bạn đã kích hoạt thành công mời đăng nhập";
    public static final String DE_ACTIVE = " Tài khoản của bạn đã bị cấm vĩnh viễn";

    //resend email
    public static final String SEND_SUCCESS = "Mã kích hoạt đã được gửi lại ";
    //reset password
    public static final String RESET_SUCCESS = "Thành công ! mời kiểm tra email để nhận mật khẩu mới";
    public static final String RESET_FAIL = "Email của bạn không tồn tại";
    // change password 
    public static final String CHANGE_SUCCESS = "Đổi mật khẩu thành công";
    public static final String OLD_PASSWORD_FAIL = "Mật khẩu hiện tại không đúng";
    public static final String NEW_PASSWORD_OUT_OF_FROM = "Mật khẩu mới không đúng định dạng";
    public static final String NEW_PASSWORD_NOT_DUPLICATE = "Mật khẩu mới không trùng khớp với nhau";
    //cart
    public static final String NullCart = "Không có sản phẩm nào trong giỏ hàng";
    public static final String AddSuccess = "Thêm thành công!";

}
