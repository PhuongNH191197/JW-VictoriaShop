/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import model.BrandModel;
import model.CategoryModel;
import model.ProductModel;

/**
 *
 * @author phuon
 */
public class Product {

    private int id;
    private String code;
    private String name;
    private int categoryId;
    private int price;
    private int quantity;
    private int status;
    private String description;
    private String imageLink;
    private int brandId;
    private String note;

    public Product() {
    }

    public Product(int id, String code, String name, int categoryId, int price, int quantity, int status, String description, String imageLink, int brandId, String note) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.description = description;
        this.imageLink = imageLink;
        this.brandId = brandId;
        this.note = note;
    }

    public Product(String code, String name, int categoryId, int price, int quantity, int status, String description, String imageLink, int brandId, String note) {
        this.code = code;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.description = description;
        this.imageLink = imageLink;
        this.brandId = brandId;
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product(String code, int price) {
        this.name = code;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Brand getBrand() {
        return new BrandModel().getOne(brandId);
    }

    public Category getCategory() {
        return new CategoryModel().getOne(categoryId);
    }

    public int getSize() {
        ArrayList<Product> list = new ProductModel().getAll();
        return list.size();
    }

    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", name=" + name + ", categoryId=" + categoryId + ", price=" + price + ", quantity=" + quantity + ", status=" + status + ", description=" + description + ", imageLink=" + imageLink + ", brandId=" + brandId + ", note=" + note + '}';
    }

}
