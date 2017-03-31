/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.MyLogger;
import com.realestate.model.*;
import com.realestate.services.LoginService;
import com.realestate.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Methods control registration
 * @author Shana
 */
@Controller
@SessionAttributes({"prospect", "registrant"})
public class RegisterController {

    private RegisterService registerService;

    /**
     *
     * @param registerService
     */
    @Autowired
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    /**
     * Sets up the page with blank data for the registrants/placeholder for registrant;
     * registrant page is displayed
     * @param model
     * @return
     */
    @RequestMapping(value = "/registerPage.htm")
    public String showRegisterForm(ModelMap model) {
        Prospect prospect = new Prospect();
        model.addAttribute(prospect);
        Registrant registrant = new Registrant();
        model.addAttribute(registrant);

        return "registerPage";
    }


    /**
     * Submits the info from the registration form and saves info to the registrant.
     * Returns invalid if all inputs in cc info are not numbers.
     * @param registrant
     * @param model
     * @return
     */
    @RequestMapping(value = "/submitRegisterPage.htm")
    public String submitForm(@ModelAttribute("registrant") Registrant registrant, ModelMap model) {
        if (registerService.validate(registrant)) {
            Prospect prospect = registerService.register(registrant);
            model.addAttribute(prospect);
            MyLogger.log(prospect.getFirst_name() + prospect.getLast_name() + " is registered");
            return "redirect:fromRegisterPage.htm";
        } else {
            registrant.setCredit_card("***invalid***");
            return "registerPage";
        }

    }
}
