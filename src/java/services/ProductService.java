/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Product;
import entity.Size;
import java.util.ArrayList;
import model.ProductModel;
import utils.ICommon;

/**
 *
 * @author phuon
 */
public class ProductService {

//    ProductModel productModel = new ProductModel();
//    ICommon<Product> icommon = new ProductModel();
//    
//    public  Product getproductDetail(int id){
//        return  productModel.getOne(id);
//    }
    ProductModel productModel = new ProductModel();

    public ArrayList<Product> getAllProduct() {
        return productModel.getAll();
    }

    public int countTotalProduct() {
        return productModel.countTotalProduct();
    }

    public ArrayList<Product> getAllProduct(int page, int brandId, int categoryId, String txtsearch) {
        if (brandId != 0 && categoryId == 0 && txtsearch == null) {
            return productModel.getAllByBrand(brandId);
        }
        if (brandId == 0 && categoryId != 0 && txtsearch == null) {
            return productModel.getAllByCategory(categoryId);
        }
        if (brandId != 0 && categoryId != 0 && txtsearch == null) {
            return productModel.getAllByPriceAndBrand(brandId, categoryId);
        }
        if (brandId == 0 && categoryId == 0 && txtsearch != null) {
            return  productModel.searchProductByName(txtsearch);
        }
        return productModel.getAll(page);

    }
    public boolean deleteProductById(int id){
        return productModel.delete(id);
    }

    public Product getOneProduct(int id) {
        return productModel.getOne(id);
    }

    public ArrayList<Size> getAllSize() {
        return productModel.getAllSize();
    }

    public boolean addProduct(Product product) {
        return productModel.add(product);
    }
}
