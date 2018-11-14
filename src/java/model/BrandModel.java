/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MSSQLConnection;
import entity.Brand;
import entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ICommon;

/**
 *
 * @author phuon
 */
public class BrandModel implements ICommon<Brand> {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Brand> getAll() {
        ArrayList<Brand> list = new ArrayList<>();
        String sql = "SELECT * FROM Brand";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand(rs.getInt(1), rs.getString(2));
                list.add(brand);
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
    
    public static void main(String[] args) {
        BrandModel bm = new BrandModel();
        ArrayList<Brand> al = bm.getAll();
        System.out.println(al);
        
    }

    @Override
    public Brand getOne(int id) {
       String sql = "SELECT * FROM Brand WHERE Id = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Brand brand = new Brand(rs.getInt(1), rs.getString(2));
                return brand;
            }
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean add(Brand obj) {
        return false;
    }

    @Override
    public boolean update(Brand obj, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
