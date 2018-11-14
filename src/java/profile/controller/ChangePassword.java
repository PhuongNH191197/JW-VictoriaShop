/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile.controller;

import config.IMessageConfig;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;
import utils.BCrypt;
import utils.StringUtil;

/**
 *
 * @author phuon
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/changepassword"})
public class ChangePassword extends HttpServlet {

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
            // user session get email 
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("currentLoginAccount");
            String email = account.getEmail();
            
            
            String oldPassword = request.getParameter("oldpassword");
            String newPassword = request.getParameter("newpassword");
            String reNewPassword = request.getParameter("renewpassword");
            
            
            
            System.out.println(email);
            System.out.println(oldPassword);
            System.out.println(newPassword);
            System.out.println(reNewPassword);

            //creat new accoutn service
            AccountService accountService = new AccountService();
            // check old password
            
            Account accountCheckPassword = accountService.processLogin(email, oldPassword);
            
            
            if (accountCheckPassword != null) {
                if (StringUtil.validatePassword(newPassword)) {
                    System.out.println("check form pass");
                    if (StringUtil.validatePasswordConfirm(newPassword, reNewPassword)) {
                        System.out.println("check validate ok ");
                        String hashedNewPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
                        
                        // thay vi choc vao DB 2 lan su dung luon cai account tra ve o tren va setPassword
//                        account.setPassword(newPassword);
                        if (accountService.update("Password", "Email", hashedNewPassword, email)){
                            request.setAttribute("message", IMessageConfig.CHANGE_SUCCESS);
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }

                    } else {
                        request.setAttribute("message", IMessageConfig.NEW_PASSWORD_NOT_DUPLICATE);
                        request.getRequestDispatcher("changePassword.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("message", IMessageConfig.NEW_PASSWORD_OUT_OF_FROM);
                    request.getRequestDispatcher("changePassword.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", IMessageConfig.OLD_PASSWORD_FAIL);
                request.getRequestDispatcher("changePassword.jsp").forward(request, response);

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
