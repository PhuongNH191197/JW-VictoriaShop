/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincp.model;

import admincp.entity.Order;
import dao.MSSQLConnection;
import entity.Cart;
import admincp.entity.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.smartcardio.Card;
import utils.ICommon;

/**
 *
 * @author PhuongPyke
 */
public class OrderDetailModel implements ICommon<OrderDetail> {

    private ResultSet rs = null;

    public ArrayList<OrderDetail> getAllByOrderId(int Orderid) {
        ArrayList<OrderDetail> listDetail = new ArrayList<>();
                String sql = "SELECT * FROM Orders_Detail WHERE Order_Id=?";

        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1, Orderid);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail(rs.getInt("Id"),
                        rs.getString("Product_Name"),
                        rs.getInt("Product_Quantity"),
                        rs.getInt("Product_Price"),
                        rs.getInt("product_Id"),
                        rs.getInt("Order_Id"));
                listDetail.add(orderDetail);
            }
            return listDetail;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public ArrayList<OrderDetail> getAll() {
        ArrayList<OrderDetail> listDetail = new ArrayList<>();
                String sql = "SELECT * FROM Orders_Detail";

        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {

            rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail(rs.getInt("Id"),
                        rs.getString("Product_Name"),
                        rs.getInt("Product_Quantity"),
                        rs.getInt("Product_Price"),
                        rs.getInt("product_Id"),
                        rs.getInt("Order_Id"));
                listDetail.add(orderDetail);
            }
            return listDetail;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        OrderDetailModel detailModel = new OrderDetailModel();
        ArrayList<OrderDetail> listDetail = detailModel.getAllByOrderId(9);
        System.out.println(listDetail.toString());
    }

    @Override
    public OrderDetail getOne(int id) {
        String sql = "SELECT * FROM Orders_Detail WHERE Order_Id=?";
        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                OrderDetail orderDetail = new OrderDetail(rs.getInt("Id"),
                        rs.getString("Product_Name"),
                        rs.getInt("Product_Quantity"),
                        rs.getInt("Product_Price"),
                        rs.getInt("product_Id"),
                        rs.getInt("Order_Id"));
                return orderDetail;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean add(OrderDetail detail) {
        return false;
    }

    public boolean addOrderDetail(ArrayList<Cart> listcart, int orderId) {
        String sql = "INSERT INTO Orders_Detail(Product_Name, Product_Quantity,Product_Price,Product_Id,Order_Id)"
                + " VALUES(?, ?,?,?,?)";
        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Cart c : listcart) {
                ps.setString(1, c.getName());
                ps.setInt(2, c.getQuantity());
                ps.setInt(3, (int) c.getPrice());
                ps.setInt(4, c.getProductId());
                ps.setInt(5, orderId);
                ps.addBatch();
            }
            ps.executeBatch();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(OrderDetail obj, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
