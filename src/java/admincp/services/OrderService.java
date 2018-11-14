/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincp.services;

import admincp.entity.Order;
import java.util.ArrayList;
import admincp.model.OrderModel;

/**
 *
 * @author PhuongPyke
 */
public class OrderService {

    OrderModel orderModel = new OrderModel();

    public int AddOder(Order or) {
        return orderModel.addOder(or);
    }

    public ArrayList<Order> getAllOder() {
        return orderModel.getAll();
    }
}
