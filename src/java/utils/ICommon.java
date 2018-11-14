/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;

/**
 *
 * @author phuon
 */
//1 bang desgn tong the cua project thiet ke funciton - dung cho cac function dc lap di lap lai
public interface ICommon<T> {
    ArrayList<T> getAll();
    T getOne(int id);
    boolean add(T obj);
    boolean update(T obj , int id);
    boolean delete(int id);
    
    
}
