/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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

/**
 *
 * @author phuon
 */
@WebServlet(name = "Active", urlPatterns = {"/active"})
public class Active extends HttpServlet {

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
            // user session get email of register
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("currentLoginAccount");
            // get parameter code
            String code = request.getParameter("codeactive");
            System.out.println("code:" + code);
            //service
            AccountService accountService = new AccountService();
            // gop 2 ham lai 
            if (account != null) {
                String email = account.getEmail();
                System.out.println("EmailActive:" + email);
                if (accountService.Active(email, code)) {
                    request.setAttribute("message", IMessageConfig.ACTIVE_SUCCSESS);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    System.out.println("ok");
                } else {
                    request.setAttribute("message", IMessageConfig.ACTIVE_FAIL);
                    request.getRequestDispatcher("active.jsp").forward(request, response);
                }
            } else {
                String email = account.getEmail();
                System.out.println("Email register:" + email);
                if (accountService.Active(email, code)) {
                    request.setAttribute("message", IMessageConfig.ACTIVE_SUCCSESS);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", IMessageConfig.ACTIVE_FAIL);
                    request.getRequestDispatcher("active.jsp").forward(request, response);
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
