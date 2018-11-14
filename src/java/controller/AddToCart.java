/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Cart;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.ProductService;

/**
 *
 * @author PhuongPyke
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/addtocart"})
public class AddToCart extends HttpServlet {

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
            int quantity = 1; // gán cứng số lượng  =1
            int productId = Integer.parseInt(request.getParameter("productId")); // get bên product về productID
            ProductService productService = new ProductService(); // khởi tạo intance productservice

            Product product = productService.getOneProduct(productId); // get one detail bằng product id để lấy name , giá ....
            HttpSession session = request.getSession(); // khởi tạo 1 con session 

            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listcart"); // tạo một arraylist để getatribute trên session về ( mặc định = null) vì chưa add cái nào cả         
            Cart cart = new Cart(productId, product.getName(), (int) product.getPrice(), quantity, product.getImageLink()); // khởi tạo intance của Object cart ra rồi new Cart(paramerter tương ứng).
            boolean flat = false; // tạo một cờ đếm check  gán = false

            if (listCart == null) { // check nếu list cart tức cái mình ghét trên session về lúc ban đầu mà  = null 
                listCart = new ArrayList<>(); //thì khởi tạo mới 1 cái arraylist
                listCart.add(cart); // sau đó add cái cart đó vào arrayList - > khi đó session của mình đã có 1 order
                session.setAttribute("listcart", listCart); // set cái order đó vào ssession
            } else { // còn ngược lại nếu list đã có order rồi thì 
                for (Cart c : listCart) { // for để check productID
                    if (c.getProductId() == productId) { // nếu id trùng nhau thì 
                        int quan = c.getQuantity() + 1; // tăng số lượng sản phẩm lên 1
                        c.setQuantity(quan); // và update lại quantity
                        flat = true; // lúc này flat sẽ là sai 
                    }
                }
                if (!flat) { // còn nếu flat mà là đúng (khác false )
                    listCart.add(cart); // thì add tiếp thằng thứ 2 
                    flat = false;
                }
                session.removeAttribute("listcart"); // khi F5 lại sẽ tự động reset cart - gioosgn remove all  order - bỏ đi chạy thử biết ngay @@
                session.setAttribute("listcart", listCart); // set cái listcart lên session
            }
            int total = 0;
            for (Cart c : listCart) {
                int price = c.getQuantity() * (int) c.getPrice();
                total += price;
            }

            session.setAttribute("total", total);
            request.getRequestDispatcher("product.jsp").forward(request, response); // getRequestDispatcher để đẩn dữ liệu lên nếu chú làm cái count để khi adđ nó tăng số 1,2,3,4 sản phẩm 
            // không sài respone.sendirec cũng được . 
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
