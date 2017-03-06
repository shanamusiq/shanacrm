/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.model.*;
import com.realestate.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Shana
 */
@Controller
@SessionAttributes ("wholesaleCalculator")
public class WholesaleCalculatorController {
    private CalculatorService calculatorService;

    /**
     *
     * @param calculatorService
     */
    @Autowired
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    
    /**
     *
     * @param model
     * @return
     */
    @RequestMapping (value = "/wholesaleCalculatorPage.htm", method = RequestMethod.GET)
    public String showForm(ModelMap model){
     WholesaleCalculator wholesalecalculator = new WholesaleCalculator();
     model.addAttribute(wholesalecalculator);
     
     return "wholesaleCalculatorPage";
    }

    /**
     *
     * @param wholesalecalculator
     * @param model
     * @return
     */
    @RequestMapping (value = "/wholesaleCalculatorPage.htm", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("wholesaleCalculator") WholesaleCalculator wholesalecalculator, ModelMap model){
        
     wholesalecalculator.setMax_offer(calculatorService.calculateWholesale(wholesalecalculator));
     return "wholesaleCalculatorPage";
    }
    
}
