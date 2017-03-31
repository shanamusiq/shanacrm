/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import com.realestate.model.WholesaleCalculator;
/**
 * Methods that operate calculators
 * @author Shana
 */
public interface CalculatorService {

    /**
     * Method for the wholesale calculator that contains the formula to generate
     * estimated offer price
     * @param wholesalecalculator
     * @return
     */
    public double calculateWholesale (WholesaleCalculator wholesalecalculator);
    
}
