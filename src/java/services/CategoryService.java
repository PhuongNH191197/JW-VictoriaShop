/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Category;
import java.util.ArrayList;
import model.CategoryModel;

/**
 *
 * @author phuon
 */
public class CategoryService {

    CategoryModel categoryModel = new CategoryModel();

    public ArrayList<Category> getAllCategory() {
        return categoryModel.getAll();
    }
}
