/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import com.mysql.jdbc.StringUtils;
import com.realestate.model.*;
import com.realestate.services.database.ProspectDBAccess;
import com.realestate.services.database.UserDBAccess;

/**
 *
 * @author Shana
 */
public class RegisterServiceImpl implements RegisterService {

    /**
     * Method sets all new registrants that login through portal as prospects
     * copying info from registrant to prospect
     * @param registrant
     * @return
     */
    @Override
    public Prospect register(Registrant registrant) {
        User user = new User();
        Prospect prospect = new Prospect();
        user.setUser_name(registrant.getUser_name());
        user.setPassword(registrant.getPassword());
        user.setLevel(user.PROSPECTROLE);
        prospect.setFirst_name(registrant.getFirst_name());
        prospect.setLast_name(registrant.getLast_name());
        prospect.setAddress(registrant.getAddress());
        prospect.setPhone(registrant.getPhone());
        prospect.setEmail(registrant.getEmail());
        prospect.setCredit_card(registrant.getCredit_card());
        prospect.setCredit_card_pin(registrant.getCredit_card_pin());
        prospect.setState(registrant.getState());
        prospect.setPostal_code(registrant.getPostal_code());
        prospect.setPassword(registrant.getPassword());
        
        user.setUser_id(0);
        //saves in the user database
        UserDBAccess.edit(user);
        //creates user ID
        int id = UserDBAccess.latestId();
        prospect.setProspect_id(0);
        //saves user ID (foreign key) into prospect databse
        prospect.setUser_id(id);
        ProspectDBAccess.edit(prospect);
        
            return prospect;
    }

    /**
     * Validates that the credit card info input are all numbers no letters
     * @param registrant
     * @return
     */
    @Override
    public boolean validate(Registrant registrant) {
      boolean valid = true;
      if (!StringUtils.isStrictlyNumeric(registrant.getCredit_card())){
          return false;
      }
      return valid;
    }
}
