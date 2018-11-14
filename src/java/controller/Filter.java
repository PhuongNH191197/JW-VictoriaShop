/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Brand;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.BrandService;
import services.CategoryService;
import services.ProductService;
import utils.CollectionsSort;

/**
 *
 * @author phuon
 */
@WebServlet(name = "Filter", urlPatterns = {"/fillter"})
public class Filter extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

//===============================CREATE VARIABLE================================
            String txtSearch = null;
            int brandId = 0;
            int page = 1;
            int categoryId = 0;
            int count;
            int PageSize;
            int sort = 0;
            int nextPage;
            int backPage;
            int minprice = 0;
            int maxprice = 0;
//=========================== TRY CATCH VARIABLE================================
            try {
                txtSearch = request.getParameter("txtsearch");
            } catch (Exception e) {
                txtSearch = null;
            }
            try {
                minprice = Integer.valueOf(request.getParameter("minprice"));
            } catch (NumberFormatException e) {
                minprice = 0;
            }
            try {
                maxprice = Integer.valueOf(request.getParameter("maxprice"));
            } catch (NumberFormatException e) {
                maxprice = 0;
            }
            try {
                page = Integer.valueOf(request.getParameter("page"));
            } catch (NumberFormatException e) {
                page = 1;
            }
            try {
                categoryId = Integer.parseInt(request.getParameter("categoryId"));

            } catch (NumberFormatException e) {
                categoryId = 0;
            }
            try {
                brandId = Integer.valueOf(request.getParameter("idBrand"));
            } catch (NumberFormatException e) {
                brandId = 0;
            }
            try {

            } catch (Exception e) {
                sort = 0;
            }
//===============================TEST GET GETPARAMETER==========================

//            System.out.println("category:" + categoryId);
//            System.out.println("page:" + page);
//            System.out.println("brandId:" + brandId);
//            System.out.println("minprice:" + minprice);
//            System.out.println("maxprice:" + maxprice);
//============================CHECK FILLTER BRAND AND STYLE=====================
            if (brandId != 0 && categoryId == 0 && minprice == 0 && maxprice == 0) {
                request.setAttribute("urlBrand", "idBrand=" + brandId + "&");
            }
            if (brandId == 0 && categoryId != 0 && minprice == 0 && maxprice == 0) {
                request.setAttribute("urlCategory", "categoryId=" + categoryId + "&");
            }
            if (brandId == 0 && categoryId == 0 && minprice != 0 && maxprice != 0) {
                request.setAttribute("urlprice", "minprice=" + minprice + "&" + "maxprice" + maxprice + "&");
            }
//=========================== CREATE INTANCE SERVICE============================
            BrandService brandService = new BrandService();
            ProductService productService = new ProductService();
            CategoryService categoryService = new CategoryService();
//=============================GET DATA IN SERVICE==============================
            ArrayList<Brand> listBrand = brandService.getAllBrand();
            ArrayList<Category> listcategory = categoryService.getAllCategory();
            System.out.println("txtSearch:" + txtSearch);
            ArrayList<Product> listproduct = productService.getAllProduct(page, brandId, categoryId, txtSearch);
            count = productService.countTotalProduct();
//============================COLLECSION SORT===================================
            CollectionsSort collectionsSort = new CollectionsSort();
            collectionsSort.sort(listproduct, sort);
//=========================PAGEGING=============================================
            PageSize = 4;
            nextPage = page + 1;
            backPage = page - 1;
//=========================SET ATTRIBUTE========================================
            request.setAttribute("pageSize", PageSize);
            request.setAttribute("backPage", backPage);
            request.setAttribute("nextPage", nextPage);
            request.setAttribute("listproduct", listproduct);
            request.setAttribute("listbrand", listBrand);
            request.setAttribute("listcategory", listcategory);
//=======================SEND DATA TO BROWSER===================================
            request.getRequestDispatcher("product.jsp").forward(request, response);
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
