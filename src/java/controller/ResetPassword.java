/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.EmailConfig;
import config.IMessageConfig;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;
import utils.AutoSendEmail;
import utils.BCrypt;
import utils.RandomCode;
import utils.StringUtil;

/**
 *
 * @author phuon
 */
@WebServlet(name = "ResetPassword", urlPatterns = {"/resetpassword"})
public class ResetPassword extends HttpServlet {

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
            String email = request.getParameter("txt_RSEmail");
            // creat new server account
            AccountService accountService = new AccountService();
            // randomm new password
            String newPassword = RandomCode.randomAlphaNumeric(8);
            // hasded password
            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

            AutoSendEmail autoSendEmail = new AutoSendEmail();

            if (StringUtil.isEmail(email)) {
                if (accountService.update("Password", "Email", hashedPassword, email)) {
                    autoSendEmail.sentEmail(EmailConfig.FROM_EMAIL, EmailConfig.PASSWORD, email, EmailConfig.NEW_PASSWORD, autoSendEmail.emailContent_ResetPassword(email, newPassword));
                    request.setAttribute("message", IMessageConfig.RESET_SUCCESS);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", IMessageConfig.RESET_FAIL);
                    request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", IMessageConfig.EMAIL_OUT_OF_FROME);
                request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
              
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
