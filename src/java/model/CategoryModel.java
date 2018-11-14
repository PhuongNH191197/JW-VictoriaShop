/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MSSQLConnection;
import entity.Category;
import entity.Product;
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
public class CategoryModel implements ICommon<Category> {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Category> getAll() {
        ArrayList<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Categories";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt(1), rs.getString(2));
                list.add(category);
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
        CategoryModel categoryModel = new CategoryModel();
        ArrayList<Category> list = categoryModel.getAll();
        for(Category cate : list){
            System.out.println(cate.getCategory());
        }
    }

    @Override
    public Category getOne(int Id) {
       String sql = "SELECT * FROM Categories WHERE Id = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, Id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt(1), rs.getString(2));
                return c;
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
    public boolean add(Category obj) {
        return false;
    }

    @Override
    public boolean update(Category obj, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}
