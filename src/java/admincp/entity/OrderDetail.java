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
public class OrderDetail {

    private int id;
    private String productName;
    private int productQuantity;
    private int productPrice;
    private int productId;
    private int orderId;

    public OrderDetail() {
    }

    public OrderDetail(int id, String productName, int productQuantity, int productPrice, int productId, int orderId) {
        this.id = id;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productId = productId;
        this.orderId = orderId;
    }

    public OrderDetail(String productName, int productQuantity, int productPrice, int productId, int orderId) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productId = productId;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "id=" + id + ", productName=" + productName + ", productQuantity=" + productQuantity + ", productPrice=" + productPrice + ", productId=" + productId + ", orderId=" + orderId + '}';
    }

}
