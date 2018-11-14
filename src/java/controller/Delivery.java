/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.AccountDetail;
import entity.Cart;
import admincp.entity.Order;
import admincp.entity.OrderDetail;
import admincp.entity.OtherAddress;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountDetailService;
import admincp.services.OrderDetailService;
import admincp.services.OrderService;
import admincp.services.OtherAddressService;

/**
 *
 * @author PhuongPyke
 */
@WebServlet(name = "Delivery", urlPatterns = {"/Delivery"})
public class Delivery extends HttpServlet {

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
            HttpSession session = request.getSession();
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listcart");
            Account account = (Account) session.getAttribute("currentLoginAccount");
            int accountId = account.getId();
            int statusId = 1;
            int total_price = (int) session.getAttribute("total");
            AccountDetailService accountDetailService = new AccountDetailService();
            AccountDetail accountDetail = accountDetailService.getDetailById(accountId);

//            =================Add order====================
            Order order = new Order(accountId, total_price, statusId);
            OrderService orderService = new OrderService();
            int orderId = orderService.AddOder(order);
            
//            ================Add OrderDetail=================
            OrderDetailService detailService = new OrderDetailService();
            detailService.addOrderDetail(listCart, orderId);
            //===================Add Other Address==============
            
            OtherAddress oa = new OtherAddress(accountDetail.getName(), accountDetail.getPhone_Number(), accountDetail.getAddress(), orderId);
            OtherAddressService addressService = new OtherAddressService();
            addressService.addOtherAddress(oa);
            session.removeAttribute("total");
            session.removeAttribute("listcart");
            response.sendRedirect("orderSuccess.jsp");
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
