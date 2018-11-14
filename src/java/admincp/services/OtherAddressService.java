/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincp.services;

import admincp.entity.OtherAddress;
import admincp.model.OtherAddressModel;

/**
 *
 * @author PhuongPyke
 */
public class OtherAddressService {

    OtherAddressModel addressModel = new OtherAddressModel();

    public boolean addOtherAddress(OtherAddress oa) {
        return addressModel.addOtherAddress(oa);
    }
}
