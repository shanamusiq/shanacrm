/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import java.util.ArrayList;
import java.util.List;
import com.realestate.model.Deal;
import com.realestate.services.database.DealDBAccess;

/**
 *
 * @author Shana
 */
public class DealServiceImpl implements DealService {

    @Override
    public List<Deal> getDeals() {
        List<Deal> deals = DealDBAccess.getDeals(0);
        return deals;
    }

    @Override
    public int edit(Deal deal) {
        return DealDBAccess.edit(deal);
    }

    @Override
    public int delete(Deal deal) {
        return DealDBAccess.delete(deal);
    }
    
    @Override
    public Deal getDeal(int deal_id) {
        return DealDBAccess.getDeal(deal_id);
    }

}

