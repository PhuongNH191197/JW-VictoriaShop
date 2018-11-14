/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincp.services;

import entity.Cart;
import admincp.entity.OrderDetail;
import java.util.ArrayList;
import admincp.model.OrderDetailModel;

/**
 *
 * @author PhuongPyke
 */
public class OrderDetailService {

    OrderDetailModel detailModel = new OrderDetailModel();

    public boolean addOrderDetail(ArrayList<Cart> listordetail, int orderId) {
        return detailModel.addOrderDetail(listordetail, orderId);

    }
}
