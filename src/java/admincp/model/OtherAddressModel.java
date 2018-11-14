/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincp.model;

import dao.MSSQLConnection;
import admincp.entity.OtherAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PhuongPyke
 */
public class OtherAddressModel {

    public boolean addOtherAddress(OtherAddress oa) {
        int check = 0;
        String sql = "INSERT INTO OtherAddress(FullName, PhoneNumber,Address,OrderId)"
                + " VALUES(?, ?,?,?)";
        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, oa.getFullname());
            ps.setString(2, oa.getPhoneNumber());
            ps.setString(3, oa.getAddress());
            ps.setInt(4, oa.getOrderId());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        OtherAddressModel addressModel = new OtherAddressModel();
        OtherAddress address = new OtherAddress("Nguyễn Hữu Phương", "01657123633", "Hưng yên", 1);
        addressModel.addOtherAddress(address);
    }
}
