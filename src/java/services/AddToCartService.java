/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import admincp.entity.Order;
import java.util.ArrayList;
import admincp.model.OrderModel;

/**
 *
 * @author PhuongPyke
 */
public class AddToCartService {

    OrderModel orderModel = new OrderModel();

    public boolean addOrder(Order or) {
        return orderModel.add(or);
    }

    public ArrayList<Order> getAll() {
        return orderModel.getAll();
    }
}
