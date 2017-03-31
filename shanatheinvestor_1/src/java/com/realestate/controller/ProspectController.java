/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.model.Prospect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Methods control functions on the prospect page.
 * @author Shana
 */
@Controller
@SessionAttributes("prospect")
public class ProspectController {

    /**
     * Retrieves the prospect page
     * @param model
     * @return
     */
    @RequestMapping(value = "/prospectPage.htm")
    public String showProspectForm(ModelMap model) {

        return "prospectPage";
    }

    /**
     * This directs the prospect users to the prospect page from the register page
     * @param prospect
     * @param model
     * @return
     */
    @RequestMapping(value = "/fromRegisterPage.htm")
    public String register( @ModelAttribute("prospect") Prospect prospect, ModelMap model) {

        return "prospectPage";
    }

    /**
     * Link to the Wholesale calc
     * @param model
     * @return
     */
    @RequestMapping(value = "/goTowholesaleCalculator.htm")
    public String goTowholesaleCalculator(ModelMap model) {

        return "redirect:wholesaleCalculatorPage.htm";
    }
}
