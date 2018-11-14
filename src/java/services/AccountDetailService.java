/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.AccountDetail;
import model.AccountDetailModel;

/**
 * Describe the function:
 * < Use a service to call back the model to avoid writing the model to the serverlet user for farmwork to surprise.>
 *
 * @author phuon
 */
public class AccountDetailService {

    AccountDetailModel accountDetailModel = new AccountDetailModel();

    public int addAccountDetail(AccountDetail accountDetail) {
        return accountDetailModel.addDetail(accountDetail);
    }

    public AccountDetail getDetailById(int productDetailId) {
        return accountDetailModel.getOne(productDetailId);
    }

    public boolean updateDetailAccount(String name,String phone,String address , int id) {
        return accountDetailModel.updateAll(name, phone, address, id);
    }

}
