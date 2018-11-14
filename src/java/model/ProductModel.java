/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MSSQLConnection;
import entity.Product;
import entity.Size;
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
public class ProductModel implements ICommon<Product> {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public int countTotalProduct() {
        String sql = "SELECT COUNT(Id) FROM Products";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return 0;
    }

    public ArrayList<Product> getAll(int page) {
        ArrayList<Product> list = new ArrayList<>();
//        String sql = "SELECT *FROM Products\n"
//                + "ORDER BY Id\n"
//                + "OFFSET " + pageNumber + " ROWS\n"
//                + "FETCH NEXT 6 ROWS ONLY";
        String sql = "select * from (\n"
                + "    select ROW_NUMBER() over (order by Id ASC) as rn, *\n"
                + "    from Products\n"
                + ") as x\n"
                + "where rn between (?-1)*? +1 "
                + "and ? * ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, page);
            ps.setInt(2, 9);
            ps.setInt(3, page);
            ps.setInt(4, 9);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("Id"),
                        rs.getString("Code"),
                        rs.getString("Name"),
                        rs.getInt("CategoryId"),
                        rs.getInt("Price"),
                        rs.getInt("Quantity"),
                        rs.getInt("Status"),
                        rs.getString("Description"),
                        rs.getString("Image"),
                        rs.getInt("brandId"),
                        rs.getString("Note"));
                list.add(product);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return list;
    }

    public boolean updateProduct(Product product, int id) {
        String updateTableSQL = "UPDATE Products SET Code = ? ,Name =?,CategoryId=?,Price=?,Quantity=?,Status=?,Description=?,Image=?,brandId=?,Note=?\n"
                + "WHERE Id =?";
        int check = 0;
        try (Connection con = MSSQLConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(updateTableSQL)) {
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getCategoryId());
            ps.setInt(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.setInt(6, product.getStatus());
            ps.setString(7, product.getDescription());
            ps.setString(8, product.getImageLink());
            ps.setInt(9, product.getBrandId());
            ps.setString(10, product.getNote());
            ps.setInt(11, id);
            // execute update SQL stetement
            check = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return check > 0;
    }

    public ArrayList<Product> getAllByBrand(int brandId) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE brandId = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, brandId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11));

                list.add(product);
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

//    public static void main(String[] args) {
//        ProductModel model = new ProductModel();
//        ArrayList<Product> list = model.getAllByCategory(2);
//        for(Product pro : list){
//            System.out.println(pro.getImageLink());
//        }
//    }
    public ArrayList<Product> getAllByPrice(double minPrice, double maxPrice) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE Price BETWEEN " + minPrice + " AND " + maxPrice;
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11));

                list.add(product);
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

    @Override
    public Product getOne(int id) {
        String sql = "SELECT *FROM Products WHERE Id = '" + id + "'";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11));

                return product;
            }
        } catch (SQLException e) {
            System.out.println("error getproduct ");
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return null;
    }

    public static void main(String[] args) {
        ProductModel model = new ProductModel();
        ArrayList<Product> list = model.getAll(4);
        for (Product p : list) {
            System.out.println(p.getId());

        }
    }

    @Override
    public boolean add(Product product) {
        int check = 0;
        String query = "INSERT INTO Products(Code, Name, CategoryId, Price , Quantity, Status,Description,Image,brandId,Note)"
                + " VALUES(?, ?, ?, ?, ?,?,?,?,?,?)";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getCategoryId());
            ps.setInt(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.setInt(6, product.getStatus());
            ps.setString(7, product.getDescription());
            ps.setString(8, product.getImageLink());
            ps.setInt(9, product.getBrandId());
            ps.setString(10, product.getNote());
            check = ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return check > 0;
    }

    @Override
    public boolean update(Product obj, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM Products WHERE Id = ?";
        int check = 0;
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }

        return check > 0;
    }

    public ArrayList<Product> searchProductByName(String name) {
//        SELECT * FROM Customers
//WHERE CustomerName LIKE '%a%';
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE Name LIKE '%" + name + "%'";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11));
                list.add(product);
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

    public ArrayList<Product> getAllByPriceAndBrand(int brandId, double minPrice, double maxPrice) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE Brand_Id = ? AND (Price BETWEEN " + minPrice + " AND " + maxPrice + ")";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, brandId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11));

                list.add(product);
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

    public ArrayList<Product> getAllByPriceAndBrand(int brandId, int categoryId) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE brandId = ? AND CategoryId='" + categoryId + "'";
        System.out.println(sql);
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, brandId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11));

                list.add(product);
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

//    public static void main(String[] args) {
//        ProductModel productModel = new ProductModel();
//
//        ArrayList<Product> arrayList = productModel.getAllByPriceAndBrand(3, 2);
//        for (Product p : arrayList) {
//            System.out.println(p.toString()+"\n");
//        }
//    }
    public ArrayList<Product> getAllByCategory(int categoryId) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE CategoryId = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11));

                list.add(product);
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

    @Override
    public ArrayList<Product> getAll() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT *FROM Products\n";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11));
                list.add(product);
            }

            return list;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return null;
    }

    public ArrayList<Size> getAllSize() {
        ArrayList<Size> list = new ArrayList<>();
        String sql = "SELECT *FROM Size\n";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Size size = new Size(rs.getInt(1),
                        rs.getInt(2));
                list.add(size);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return null;
    }

}
