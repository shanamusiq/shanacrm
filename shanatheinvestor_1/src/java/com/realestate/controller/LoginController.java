/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.model.*;
import com.realestate.services.LoginService;
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
@SessionAttributes ("user")
public class LoginController {
    private LoginService loginService;

    /**
     *
     * @param loginService
     */
    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @RequestMapping (value = "/frontPage.htm", method = RequestMethod.GET)
    public String showUserForm(ModelMap model){
     User user = new User();
     model.addAttribute(user);
     
     return "loginPage";
    }
    @RequestMapping (value = "/frontPage.htm", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("user") User user, ModelMap model){
     int level = loginService.login(user);
        switch (level) {
            case User.PROSPECTROLE :
                return "redirect:prospectPage.htm";
            case User.CLIENTROLE :
                return "redirect:clientPage.htm";
            case User.ADMINROLE :
                return "redirect:adminPage.htm";
            default:
                break;
        }
     user.setUser_name("loginFailed");
     
     return "loginPage";
    }
    @RequestMapping (value = "/register.htm")
    public String showRegisterForm(@ModelAttribute("user") User user, ModelMap model){
     
     model.addAttribute(user);
     
     return "redirect:registerPage.htm";
    }
}
