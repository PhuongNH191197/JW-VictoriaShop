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
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;
import utils.AutoSendEmail;
import utils.RandomCode;

/**
 *
 * @author phuon
 */
@WebServlet(name = "ReSendEmail", urlPatterns = {"/resendemail"})
public class ReSendEmail extends HttpServlet {

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
            //service
            AccountService accountService = new AccountService();
            //auto send email
            AutoSendEmail autoSendEmail = new AutoSendEmail();
            //new session
            HttpSession session = request.getSession();
            // user session get email and full name of register
            Account account = (Account) session.getAttribute("currentLoginAccount");
            // random new code active
            String newCodeActive = RandomCode.randomAlphaNumeric(8);
            // save new active code in database
            String code = request.getParameter("codeactive");
            if (account != null) { // neu chua active ma dang nhap no bat active
//                Account accountOflogin = (Account) session.getAttribute("currentActiveAccount");
                System.out.println("Email login - chua active : " + account.getEmail());
                if (accountService.update("Code_Active", "Email", newCodeActive, account.getEmail())) {
                    autoSendEmail.sentEmail(EmailConfig.FROM_EMAIL, EmailConfig.PASSWORD, account.getEmail(), EmailConfig.NEW_CODE_ACTIVE, autoSendEmail.emailContent(account.getEmail(), newCodeActive));
                    request.setAttribute("message", IMessageConfig.SEND_SUCCESS);
                    request.getRequestDispatcher("active.jsp").forward(request, response);
                }
                if (accountService.Active(account.getEmail(), code)) {
                    request.setAttribute("message", IMessageConfig.ACTIVE_SUCCSESS);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    session.removeAttribute("currentRegisterAccount");
                } else {
                    request.setAttribute("message", IMessageConfig.ACTIVE_FAIL);
                    request.getRequestDispatcher("active.jsp").forward(request, response);
                }
            }
//            else { 
//                System.out.println("Email register - chua active : " + account.getEmail());
//                // if save succsess then auto send email again !  (account.getEmail(), newCodeActive)
//                if (accountService.update("Code_Active", "Email", newCodeActive, account.getEmail())) {
//                    autoSendEmail.sentEmail(EmailConfig.FROM_EMAIL, EmailConfig.PASSWORD, account.getEmail(), EmailConfig.NEW_CODE_ACTIVE, autoSendEmail.emailContent(account.getEmail(), newCodeActive));
//                    request.setAttribute("message", IMessageConfig.SEND_SUCCESS);
//                    request.getRequestDispatcher("active.jsp").forward(request, response);
//                }
//                if (accountService.Active(account.getEmail(), code)) {
//                    request.setAttribute("message", IMessageConfig.ACTIVE_SUCCSESS);
//                    request.getRequestDispatcher("login.jsp").forward(request, response);
//                    session.removeAttribute("currentRegisterAccount");
//                } else {
//                    request.setAttribute("message", IMessageConfig.ACTIVE_FAIL);
//                    request.getRequestDispatcher("active.jsp").forward(request, response);
//                }
//            }

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
