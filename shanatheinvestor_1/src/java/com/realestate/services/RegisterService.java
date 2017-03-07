/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import com.realestate.model.Registrant;
import com.realestate.services.*;
import com.realestate.model.*;
/**
 *
 * @author Shana
 */
public interface RegisterService {
    public Prospect  register (Registrant registrant);
    
   public boolean  validate (Registrant registrant); 
    
}
