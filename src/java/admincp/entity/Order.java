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
public class Order {

    private int id;
    private int accountId;
    private int totalPrice;
    private int status;
    private String createDate;
    private String note;

    public Order() {
    }

    public Order(int accountId, int totalPrice, int status, String createDate, String note) {
        this.accountId = accountId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createDate = createDate;
        this.note = note;
    }

    public Order(int id, int accountId, int totalPrice, int status, String createDate, String note) {
        this.id = id;
        this.accountId = accountId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createDate = createDate;
        this.note = note;
    }

    public Order(int accountId, int totalPrice, int status) {

        this.accountId = accountId;
        this.totalPrice = totalPrice;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public String getCreateDate() {
        String[] tmp = createDate.split("-");
        String date = tmp[2]+"-"+tmp[1]+"-"+tmp[0];
        return date;
    }

    public void setCreateDate(String createDate) {
        
        this.createDate = createDate;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", accountId=" + accountId + ", totalPrice=" + totalPrice + ", status=" + status + ", createDate=" + createDate + ", note=" + note + '}';
    }

}
