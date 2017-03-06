/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import com.realestate.model.WholesaleCalculator;

/**
 *
 * @author Shana
 */
public class CalculatorServiceImpl implements CalculatorService {

    /**
     *
     * @param wholesalecalculator
     * @return
     */
    @Override
    public double calculateWholesale(WholesaleCalculator wholesalecalculator) {
        
      double arv = wholesalecalculator.getArv();
      double net_profit = wholesalecalculator.getNet_profit();
      double repair_cost = wholesalecalculator.getRepair_cost();
      double assignment_fee = wholesalecalculator.getAssignment_fee();     
      double max_offer = arv-(net_profit + repair_cost + assignment_fee); 

      return max_offer;  

    }
    
}
