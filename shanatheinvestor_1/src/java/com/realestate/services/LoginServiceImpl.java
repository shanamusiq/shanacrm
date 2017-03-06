/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import java.util.ArrayList;
import com.realestate.model.User;
import com.realestate.services.database.UserDBAccess;
/**
 *
 * @author Shana
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public int login(User user) {
        int level = 0;
        ArrayList< User> users = UserDBAccess.getUsers();
        for (User found : users) {
            if (found.getUser_name().equals(user.getUser_name())) {
                if (found.getPassword().equals(user.getPassword())) {
                    return found.getLevel();
                }
                return -1;
            }

        }
        return level;
    }

}
