/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MSSQLConnection;
import entity.Account;
import entity.Role;
import utils.ICommon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.BCrypt;

/**
 * Describe the function:
 * < All functions are related to data in the object AccountModel>
 * implements interface ICommon and implements abstract all methods.
 */
public class AccountModel implements ICommon<Account> {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
//    ==============================START CODE============================//

    /**
     * Describe the function: Authentication information user input
     *
     * @param email
     * @param password
     *
     * @return Object Account
     */
    public Account login(String email, String password) {

        String query = "SELECT* FROM Account WHERE Email = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setEmail(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setAcountDetailId(rs.getInt(4));
                account.setRoleId(rs.getInt(5));
                account.setStatus(rs.getInt(6));
                account.setCodeActive(rs.getString(7));
                account.setCreatedDate(rs.getString(8));
                if (BCrypt.checkpw(password, account.getPassword())) {
                    return account;
                }

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return null;
    }

    public static void main(String[] args) {
        AccountModel adm = new AccountModel();
        Account role = adm.login("phuong1@gmail.com", "Anhphuong97");
        System.out.println(role.getCreatedDate());
    }

    /**
     * Describe the function:
     * < check duplicate email when your register>
     *
     * @param email
     * @return
     */
    public boolean isCheckDuplicateEmail(String email) {
        String query = "SELECT * FROM Account WHERE Email = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return false;
    }

    /**
     * Describe the function:
     * < active code and update status(active) when your active code succsessfull>
     *
     * @param email
     * @param activeCode
     * @return
     */
    public boolean activeCode(String email, String activeCode) {
        int isCheck = 0;
        String query = "UPDATE Account SET Status = 1 WHERE Email = ? AND Code_Active = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, activeCode);
            isCheck = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return isCheck > 0;
    }

    /**
     * User update all
     *
     * @param setString
     * @param whereString
     * @param setValue
     * @param whereValue
     * @return
     */
    public boolean updateAll(String setString, String whereString, String setValue, String whereValue) {
        String sql = "UPDATE Account SET " + setString + " = ? WHERE " + whereString + " = ?";
        int check = 0;
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, setValue);
            ps.setString(2, whereValue);
            check = ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return check > 0;
    }

    public Role getOneRoleById(int id) { // truyen them int id orr string email
        String sql = "SELECT * FROM Role WHERE Id = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2));
                return role;
            }
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return null;
    }

    //======================END SOURCE====================================//    
    //======================INTERFACE=====================================//
    // get all list san pham , list account
    @Override
    public ArrayList<Account> getAll() {
        ArrayList<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setEmail(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setAcountDetailId(rs.getInt(4));
                account.setRoleId(rs.getInt(5));
                account.setStatus(rs.getInt(6));
                account.setCodeActive(rs.getString(7));
                account.setCreatedDate(rs.getString(8));
                list.add(account);
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

    // get one 1 san pham , list account
    @Override
    public Account getOne(int id) { // truyen them int id orr string email
        String sql = "SELECT * FROM Account WHERE Id = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setEmail(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setAcountDetailId(rs.getInt(4));
                account.setRoleId(rs.getInt(5));
                account.setStatus(rs.getInt(6));
                account.setCreatedDate(rs.getString(7));
                account.setCodeActive(rs.getString(8));
                return account;
            }
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return null;
    }

    /**
     * Describe the function:
     * <+8 when your register the function will add in the database> +
     *
     * @param account
     * @return
     */
    @Override
    public boolean add(Account account) {
        int check = 0;
        String query = "INSERT INTO Account(Email, Password, Account_Detail_Id, Role_Id , Status, Code_Active)"
                + " VALUES(?, ?, ?, ?, ?,?)";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, account.getEmail());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getAcountDetailId());
            ps.setInt(4, account.getRoleId());
            ps.setInt(5, account.getStatus());
            ps.setString(6, account.getCodeActive());
            check = ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return check > 0;
    }

    @Override
    public boolean update(Account account, int id) {
        String sql = "UPDATE Account SET " + account + " = ? WHERE Id = ?";
        int check = 0;
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setObject(1, account);;
            ps.setInt(2, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM Account WHERE Id = ?";
        int check = 0;
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }

        return check > 0;
    }

}
