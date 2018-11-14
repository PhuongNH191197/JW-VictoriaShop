/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.EmailConfig;
import config.IMessageConfig;
import entity.Account;
import entity.AccountDetail;
import services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountDetailService;
import utils.AutoSendEmail;
import utils.BCrypt;
import utils.RandomCode;
import utils.StringUtil;

/**
 *
 * @author phuon
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int idAccountDetail = 0;
            // supports charracter of unicode
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String fullname = request.getParameter("txt_fullname");
            String phone = request.getParameter("txt_phone");
            String address = request.getParameter("txt_address");
            int gender = Integer.parseInt(request.getParameter("gender"));
            String email = request.getParameter("txt_email");
            String password = request.getParameter("txt_pwd");
            String rePassword = request.getParameter("txt_re-pwd");
         
            //services
            AccountService accountService = new AccountService();
            AccountDetailService accountDetailSevice = new AccountDetailService();
            AutoSendEmail autoSendEmail = new AutoSendEmail();

            if (!StringUtil.isEmail(email)) { // kiểm tra email có đúng định dạng @a.bc không
                request.setAttribute("message", IMessageConfig.EMAIL_OUT_OF_FROME);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else { // nếu đúng định dạng thì thực thiện tiếp 
                if (accountService.isCheckDuplicateEmail(email)) { // kiểm tra xem email đã tồn tại trong DB chưa nếu có rồi bắn rồi 
                    request.setAttribute("message", IMessageConfig.DUPLICATE_EMAIL);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else { // nếu chưa có thì kiểm tra tiếp 
                    if (!StringUtil.validatePassword(password)) { // kiểm tra mật khẩu có đúng định dạng 1 chữ hoa 1 chữ số
                        request.setAttribute("message", IMessageConfig.VALIDATE_PASSWORD);
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    } else { // nếu đúng định dạng rồi thì 
                        if (StringUtil.validatePasswordConfirm(password, rePassword)) { // kiểm tra tiếp xem 2 mật khẩu có trung khớp nhau không
                            AccountDetail accountDetail = new AccountDetail(fullname, phone, address, gender); // tạo intance của Object AcccountDetail và lưu lại
                            idAccountDetail = accountDetailSevice.addAccountDetail(accountDetail);// Thêm vào DB và trả về 1 kiểu int idAccountDetail để sử dụng cho việc thêm bảng AcccountDetail
                            if (idAccountDetail > 0) { // nếu nó đã trả về 1 idAccountDetail thì tức là đã add thành công Acccount và bắt đầu hashed code 
                                String hashed = BCrypt.hashpw(password, BCrypt.gensalt()); // hasded code sử dụng Bcrypt
                                String codeActive = RandomCode.randomAlphaNumeric(8); // random 1 code để kích hoạt tài khoản
                                Account account = new Account(email, hashed, idAccountDetail, 2, 2, codeActive); // khởi tạo 1 intance của object Acccount
                                if (accountService.add(account)) { // nếu thêm acccount thành công thì tạo ra 1 session
                                    // creat two session
                                    HttpSession session = request.getSession();
                                    session.setAttribute("currentLoginAccount", account);
                                    // send email
                                    autoSendEmail.sentEmail(EmailConfig.FROM_EMAIL, EmailConfig.PASSWORD, account.getEmail(), EmailConfig.CODE_ACTIVE, autoSendEmail.emailContent(email, codeActive));
                                    request.setAttribute("message", IMessageConfig.CODE_ACTIVE);
                                    request.getRequestDispatcher("active.jsp").forward(request, response);

                                    /*
                                forward(ServletRequest request, ServletResponse response)
                                Chuyển tiếp một yêu cầu từ một servlet đến một tài nguyên khác (servlet, tệp JSP hoặc tệp HTML) trên máy chủ.
                                include(ServletRequest request, ServletResponse response)
                                Bao gồm nội dung của tài nguyên (servlet, trang JSP, tệp HTML) trong phản hồi.
                                     */
                                }
                            }

                        } else { // nếu mật khẩu không trùng nhau thì bắn message báo lỗi
                            request.setAttribute("message", IMessageConfig.PASSWORD_NOT_THE_SAME);
                            request.getRequestDispatcher("register.jsp").forward(request, response);
                        }
                    }
                }

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
