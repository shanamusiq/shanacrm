/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import com.realestate.model.Client;
import com.realestate.model.User;
/**
 * Method for creation of users during login
 * @author Shana
 */
public interface LoginService {
    public int login (User user);
    public Client getClient(User user);
    
}
