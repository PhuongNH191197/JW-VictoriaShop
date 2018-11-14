/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincp.controller;

import admincp.entity.Order;
import admincp.entity.OrderDetail;
import admincp.model.OrderDetailModel;
import admincp.model.OrderModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admincp.services.OrderService;
import entity.Status_Order;
import model.StatusModel;

/**
 *
 * @author PhuongPyke
 */
@WebServlet(name = "orderManagerServlet", urlPatterns = {"/orderManagerServlet"})
public class orderManagerServlet extends HttpServlet {

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
            OrderService orderService = new OrderService();
            StatusModel statusModel = new StatusModel();
            ArrayList<Order> listOrder = orderService.getAllOder();
            OrderDetailModel detailModel = new OrderDetailModel();
            String orderId = request.getParameter("orderId");
            if (orderId != null) {
                ArrayList<OrderDetail> listDetail = detailModel.getAllByOrderId(Integer.parseInt(orderId));
                ArrayList<Status_Order> list_Status_Order = statusModel.getAllStatusOrder();
                request.setAttribute("list_Status_Order", list_Status_Order);
                request.setAttribute("listDetail", listDetail);
                request.setAttribute("orderId", orderId);
            }
            request.setAttribute("listOrder", listOrder);
            request.getRequestDispatcher("adminWebpage/ordermanager.jsp").forward(request, response);
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
