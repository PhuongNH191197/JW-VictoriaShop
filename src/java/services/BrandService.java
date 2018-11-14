/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Brand;
import java.util.ArrayList;
import model.BrandModel;

/**
 *
 * @author phuon
 */
public class BrandService {

    BrandModel brandModel = new BrandModel();

    public ArrayList<Brand> getAllBrand() {
        return brandModel.getAll();
    }
}
