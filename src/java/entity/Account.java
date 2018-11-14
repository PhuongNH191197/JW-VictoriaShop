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
public class Account {

    private int id;
    private String email;
    private String password;
    private int acountDetailId;
    private int roleId;
    private int status;
    private String codeActive;
    private String createdDate;

    public Account() {
    }

    public Account( String email, String password, int acountDetailId, int roleId, int status, String codeActive) {
   
        this.email = email;
        this.password = password;
        this.acountDetailId = acountDetailId;
        this.roleId = roleId;
        this.status = status;
        this.codeActive = codeActive;
    }

    public Account(int id, String email, String password, int acountDetailId, int roleId, int status, String codeActive, String createdDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.acountDetailId = acountDetailId;
        this.roleId = roleId;
        this.status = status;
        this.codeActive = codeActive;
        this.createdDate = createdDate;
    }

    public String getCodeActive() {
        return codeActive;
    }

    public void setCodeActive(String codeActive) {
        this.codeActive = codeActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAcountDetailId() {
        return acountDetailId;
    }

    public void setAcountDetailId(int acountDetailId) {
        this.acountDetailId = acountDetailId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedDate() {
        String[] tmp = createdDate.split("-");
        String date = tmp[2]+"-"+tmp[1]+"-"+tmp[0];
        return date;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", email=" + email + ", password=" + password + ", acountDetailId=" + acountDetailId + ", roleId=" + roleId + ", status=" + status + ", createdDate=" + createdDate + '}';
    }

}
