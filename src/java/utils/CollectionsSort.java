/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Product;
import java.util.ArrayList;

/**
 *
 * @author phuon
 */
public class CollectionsSort {


    public void sort(ArrayList<Product> list, int check) {
        if (check == 1) {
            list.sort((Product o1, Product o2) -> {
                if (o1.getPrice() - o2.getPrice() > 0) {
                    return 1;
                } else if (o1.getPrice() - o2.getPrice() < 0) {
                    return -1;
                } else {
                    return 0;
                }
            });
        }
        if (check == 2) {
            list.sort((Product o1, Product o2) -> {
                if (o1.getPrice() - o2.getPrice() > 0) {
                    return -1;
                } else if (o1.getPrice() - o2.getPrice() < 0) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }
        if (check == 3) {
            list.sort((Product o1, Product o2) -> {
                if (o1.getCode().compareTo(o2.getCode()) > 0) {
                    return 1;
                } else if (o1.getCode().compareTo(o2.getCode()) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            });
        }
        if (check == 4) {
            list.sort((Product o1, Product o2) -> {
                if (o1.getCode().compareTo(o2.getCode()) > 0) {
                    return -1;
                } else if (o1.getCode().compareTo(o2.getCode()) < 0) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }
    }



}
