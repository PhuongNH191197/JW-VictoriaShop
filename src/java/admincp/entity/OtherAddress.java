/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincp.entity;

/**
 *
 * @author PhuongPyke
 */
public class OtherAddress {

    private int id;
    private String fullname;
    private String phoneNumber;
    private String address;
    private int orderId;

    public OtherAddress() {
    }

    public OtherAddress( String fullname, String phoneNumber, String address, int orderId) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OtherAddress{" + "id=" + id + ", fullname=" + fullname + ", phoneNumber=" + phoneNumber + ", address=" + address + ", orderId=" + orderId + '}';
    }

}
