/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincp.controller;

import entity.Brand;
import entity.Category;
import entity.Product;
import entity.Status;
import entity.Status_Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StatusModel;
import services.BrandService;
import services.CategoryService;
import services.ProductService;

/**
 *
 * @author PhuongPyke
 */
@WebServlet(name = "productmanagerservlet", urlPatterns = {"/productmanagerservlet"})
public class productManagerServlet extends HttpServlet {

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
            ProductService productService = new ProductService();
            CategoryService categoryService = new CategoryService();
            BrandService brandService = new BrandService();
            StatusModel statusModel = new StatusModel();
            String productId = request.getParameter("productId");
            ArrayList<Product> arrayList = productService.getAllProduct();
            ArrayList<Category> listCategory = categoryService.getAllCategory();
            ArrayList<Brand> listBrand = brandService.getAllBrand();
            ArrayList<Status_Product> listStatusP = statusModel.getAllStatusProduct();
            if (productId != null) {
                Product product = productService.getOneProduct(Integer.parseInt(productId));
                request.setAttribute("product", product);
            }
            request.setAttribute("listProducts", arrayList);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("listBrand", listBrand);
            request.setAttribute("listStatusP", listStatusP);
            System.out.println("ok1");
            request.getRequestDispatcher("/adminWebpage/productmanager.jsp").forward(request, response);
            System.out.println("ok2");
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
