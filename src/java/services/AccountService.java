/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Account;
import java.util.ArrayList;
import model.AccountModel;

/**
 * Describe the function:
 * < Use a service to call back the model to avoid writing the model to the serverlet user for farmwork to surprise.>
 *
 * @author phuon
 */
public class AccountService {

    AccountModel accountModel = new AccountModel();

    public Account processLogin(String email, String pasword) {
        return accountModel.login(email, pasword);
    }

    public ArrayList<Account> getAllAccount() {
        return accountModel.getAll();
    }

    public boolean Active(String email, String codeActive) {
        return accountModel.activeCode(email, codeActive);
    }

    public Account getOneById(int id) {
        return accountModel.getOne(id);
    }

    public boolean add(Account account) {
        return accountModel.add(account);
    }

    public boolean update(String whereString, String whereValue, String setString, String setValue) {
        return accountModel.updateAll(whereString, whereValue, setString, setValue);
    }

    public boolean isCheckDuplicateEmail(String email) {
        return accountModel.isCheckDuplicateEmail(email);
    }

    public boolean deleteAccountById(int id) {
        return accountModel.delete(id);
    }

}
