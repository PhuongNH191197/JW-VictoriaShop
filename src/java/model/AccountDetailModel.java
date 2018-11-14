/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MSSQLConnection;
import entity.AccountDetail;
import utils.ICommon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Describe the function:
 * < All functions are related to data in the object AccountDetailModel>
 * implements interface ICommon and implements abstract all methods.
 */
public class AccountDetailModel implements ICommon<AccountDetail> {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * Describe the function:
     * < Insert one AccountDetail to Database and return Id>
     *
     * @param accountDetail
     * @return Id AccountDetail inserted
     */
    public int addDetail(AccountDetail accountDetail) {
        int accountDetailId = 0;
        String query = "INSERT INTO Account_Detail(Name, Phone ,Address, Gender) "
                + "VALUES (?,?,?,?)";
        try {
            connection = MSSQLConnection.getConnection(); // kết nối driver
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);  // thực thi 1 câu truy vấn có tham số.   
            ps.setString(1, accountDetail.getName()); // //truyền tham số 
            ps.setString(2, accountDetail.getPhone_Number()); // setString , setInt , .... là phương thức của prepareStatement
            ps.setString(3, accountDetail.getAddress());
            ps.setInt(4, accountDetail.getGender());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys(); // executeUpdate dùng để thực thi các câu lệnh sql và trả lại 1 hàng được thêm sau đó  lưu nó vào biến check
            if (rs.next()) {
                accountDetailId = rs.getInt(1);
            }
        } catch (SQLException e) {
            // trả về một message thông báo nếu bị lỗi 

        } finally { // dọn dẹp và giải phóng source
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return accountDetailId; // nếu biết check tồn tại tức >0 thì trả về true
        // còn không trả về false
    }

    //===================== when Implements abstract all methods======================
    /**
     * Get all AccountDetail in Database
     *
     * @return list object AccountDetail
     */
    @Override
    public ArrayList<AccountDetail> getAll() {

        ArrayList<AccountDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM Account_Detail";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                 AccountDetail accountDetail = new AccountDetail();
                accountDetail.setId(rs.getInt("Id"));
                accountDetail.setName(rs.getString("Name"));
                accountDetail.setPhone_Number(rs.getString("Phone"));
                accountDetail.setAddress(rs.getString("Address"));
                accountDetail.setGender(rs.getInt("Gender"));
                list.add(accountDetail);
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

    /**
     * Get one AccountDetail by Id
     *
     * @param id
     * @return one object AccountDetail
     */
    @Override
    public AccountDetail getOne(int id) {
        String sql = "SELECT * FROM Account_Detail WHERE Id = ?";
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                AccountDetail accountDetail = new AccountDetail();
                accountDetail.setId(rs.getInt("Id"));
                accountDetail.setName(rs.getString("Name"));
                accountDetail.setPhone_Number(rs.getString("Phone"));
                accountDetail.setAddress(rs.getString("Address"));
                accountDetail.setGender(rs.getInt("Gender"));
                return accountDetail;
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
     * Insert one AccountDetail to Database
     *
     * @param accountDetail
     * @return true if insert AccountDetail success false if insert
     * AccountDetail fail
     */
    @Override
    public boolean add(AccountDetail accountDetail) {

        return false;

    }

    /**
     * Update info one AccountDetail in Database
     *
     * @param accountDetail
     * @param id
     * @return true if update AccountDetail success false if update
     * AccountDetail fail
     */
    @Override
    public boolean update(AccountDetail accountDetail, int id) {
        String sql = "UPDATE Account_Detail SET " + accountDetail + " = ? WHERE Id = ?";
        int check = 0;
        System.out.println(sql);
        try {
            connection = MSSQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setObject(1, accountDetail);
            ps.setInt(2, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            MSSQLConnection.closePreparedStatement(ps);
            MSSQLConnection.closeConnection(connection);
        }
        return check > 0;
    }

    public boolean updateAll(String name, String phone, String address, int id) {
        String sql = "UPDATE Account_Detail SET Name = '" + name + "',Phone='" + phone + "',Address='" + address + "'\n" + "WHERE Id = ?";
        int check = 0;
        System.out.println(sql);
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

    

    /**
     * Delete one AccountDetail in Database by Id
     *
     * @param id
     * @return true if delete AccountDetail success false if delete
     * AccountDetail fail
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM Account_Detail WHERE Id = ?";
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

    //=====================Tham Khảo getIdLastRecord ============================
    //    public int getIdLastRecord() {
//        String sql = "SELECT TOP 1 * FROM Account_Detail ORDER BY Id DESC";
//        try {
//            connection = MSSQLConnection.getConnection();// lấy 
//            ps = connection.prepareStatement(sql);
//            rs = ps.executeQuery(); // thực thi  và trả về các record thỏa mãn câu lệnh sql    
//            if (rs.next()) {
//                return rs.getInt(1);// lấy dữ liệu từ rs
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {// dọn dẹp và giải phóng source
//            MSSQLConnection.closeResultSet(rs);
//            MSSQLConnection.closePreparedStatement(ps);
//            MSSQLConnection.closeConnection(connection);
//        }
//        return 0;
//    }
}
