/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.IMessageConfig;
import entity.Account;
import services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phuon
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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
            // get parameter of web login
            String email = request.getParameter("txt_email");
            String password = request.getParameter("txt_pwd");
            // tranfer data to services
            AccountService accountService = new AccountService();
            Account accountLogin = accountService.processLogin(email, password);
            if (accountLogin == null) {
                request.setAttribute("message", IMessageConfig.LOGIN_FAIL); // gọi đến interface để lấy thông báo
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                if (accountLogin.getStatus() != 1) {
                    if (accountLogin.getStatus() != 2) {// status==3
                        request.setAttribute("message", IMessageConfig.DE_ACTIVE);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {// status ==2
                        HttpSession session = request.getSession(); //  tạo 1 session tổng lớn nhất để check  xem có đăng nhập không
                        session.setAttribute("currentLoginAccount", accountLogin);
                        request.setAttribute("message", IMessageConfig.NOT_ACTIVE); // gọi đến interface để lấy thông báo
                        request.getRequestDispatcher("active.jsp").forward(request, response);
                    }

                } else {// status ==1
                    HttpSession session = request.getSession(); //  tạo 1 session tổng lớn nhất để check  xem có đăng nhập không
                    session.setAttribute("currentLoginAccount", accountLogin);
                    if (accountLogin.getRoleId() != 1) {
                        request.getRequestDispatcher("product.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("adminWebpage/admin_index.jsp").forward(request, response);
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
