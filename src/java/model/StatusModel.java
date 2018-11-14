/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MSSQLConnection;
import entity.AccountDetail;
import entity.Status;
import entity.Status_Order;
import entity.Status_Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PhuongPyke
 */
public class StatusModel {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Status getStatusById(int id) {
        String sql = "SELECT * FROM Status WHERE Id = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Status s = new Status(rs.getInt(1), rs.getString(2));
                return s;
            }
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return null;
    }

    public ArrayList<Status_Product> getAllStatusProduct() {
        ArrayList<Status_Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Status_Product";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Status_Product s = new Status_Product(rs.getInt(1), rs.getString(2));

                list.add(s);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return null;

    }
      public ArrayList<Status_Order> getAllStatusOrder() {
        ArrayList<Status_Order> list = new ArrayList<>();
        String sql = "SELECT * FROM Status_Order";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Status_Order s = new Status_Order(rs.getInt(1), rs.getString(2));

                list.add(s);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return null;

    }
    
    
     public boolean updateStatus(String setString, String whereString, int setValue, int whereValue) {
        String sql = "UPDATE Account SET " + setString + " = ? WHERE " + whereString + " = ?";
        int check = 0;
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, setValue);
            ps.setInt(2, whereValue);
            check = ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return check > 0;
    }
        public boolean updateStatusOrder(String setString, String whereString, int setValue, int whereValue) {
        String sql = "UPDATE Orders SET " + setString + " = ? WHERE " + whereString + " = ?";
        int check = 0;
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, setValue);
            ps.setInt(2, whereValue);
            check = ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return check > 0;
    }
    public static void main(String[] args) {
        StatusModel statusModel =new StatusModel();
        statusModel.updateStatusOrder("StatusId", "Id", 4, 14);
    }

}
