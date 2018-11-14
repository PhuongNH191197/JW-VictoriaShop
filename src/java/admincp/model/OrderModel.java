/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincp.model;

import dao.MSSQLConnection;
import entity.Account;
import entity.AccountDetail;
import admincp.entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.ICommon;

/**
 *
 * @author PhuongPyke
 */
public class OrderModel implements ICommon<Order> {

    private ResultSet rs = null;

    @Override
    public ArrayList<Order> getAll() {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM Orders";
        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {

            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt("Id"),
                        rs.getInt("AccountId"),
                        rs.getInt("Total_Price"),
                        rs.getInt("StatusId"),
                        rs.getString("Create_Date"),
                        rs.getString("Note")
                );
                list.add(order);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Order> getAllByAccountId(int accountId) {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM Orders WHERE AccountId =?";
        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt("Id"),
                        rs.getInt("AccountId"),
                        rs.getInt("Total_Price"),
                        rs.getInt("StatusId"),
                        rs.getString("Create_Date"),
                        rs.getString("Note")
                );
                list.add(order);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean updateOrder(String setString, String whereString, int setValue, int whereValue) {
        String sql = "UPDATE Orders SET " + setString + " = ? WHERE " + whereString + " = ?";
        int check = 0;
        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1, setValue);
            ps.setInt(2, whereValue);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        OrderModel model = new OrderModel();
        ArrayList<Order> al = model.getAllByAccountId(2);
        System.out.println(al.toString());
    }

    @Override
    public Order getOne(int id) {
        String sql = "SELECT * FROM Orders WHERE Id=?";
        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Order order = new Order(rs.getInt("Id"),
                        rs.getInt("AccountId"),
                        rs.getInt("Total_Price"));
                return order;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean add(Order or) {
        int check = 0;
        String sql = "INSERT INTO Orders(AccountId, Total_Price,StatusId)"
                + " VALUES(?, ?,?)";
        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, or.getAccountId());
            ps.setInt(2, or.getTotalPrice());
            ps.setDouble(3, or.getStatus());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check > 0;
    }

    public int addOder(Order or) {
        int orderId = 0;
        String sql = "INSERT INTO Orders(AccountId, Total_Price,StatusId)"
                + " VALUES(?, ?,?)";
        try (
                Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, or.getAccountId());
            ps.setInt(2, or.getTotalPrice());
            ps.setDouble(3, or.getStatus());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys(); // executeUpdate dùng để thực thi các câu lệnh sql và trả lại 1 hàng được thêm sau đó  lưu nó vào biến check
            if (rs.next()) {
                orderId = rs.getInt(1);
            }
        } catch (SQLException e) {
            // trả về một message thông báo nếu bị lỗi 
        }
        return orderId; // nếu biết check tồn tại tức >0 thì trả về true
        // còn không trả về false
    }

    @Override
    public boolean update(Order obj, int id) {
        return false;
    }

    @Override
    public boolean delete(int id
    ) {
        return false;
    }

}
