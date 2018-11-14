/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author phuon
 */
public class AccountDetail {
    private int id;
    private String name;
    private String phone_Number;
    private String address;
    private int gender;

    public AccountDetail() {
    }


       public AccountDetail( String name, String phone_Number, String address, int gender) {
     
        this.name = name;
        this.phone_Number = phone_Number;
        this.address = address;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "AccountDetail{" + "id=" + id + ", name=" + name + ", phone_Number=" + phone_Number + ", address=" + address + ", gender=" + gender + '}';
    }


    
}
