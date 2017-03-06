/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import java.util.List;
import com.realestate.model.Deal;

/**
 *
 * @author Shana
 */
public interface DealService {
   	public List<Deal> getDeals();
        public Deal getDeal(int deal_id);
        public int edit(Deal deal);
        public int delete(Deal deal);        
}

