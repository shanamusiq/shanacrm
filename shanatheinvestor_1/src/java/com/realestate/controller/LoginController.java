/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.MyLogger;
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
 * Methods used to direct the new user (registrant) when they are logging in as
 * well as members, clients, admin and users.
 * @author Shana
 */
@Controller
@SessionAttributes ({"user","client"})
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
    
    /**
     * Retrieves login page
     * @param model
     * @return
     */
    @RequestMapping (value = "/frontPage.htm", method = RequestMethod.GET)
    public String showUserForm(ModelMap model){
     User user = new User();
     model.addAttribute(user);
     
     return "loginPage";
    }

    /**
     * Method used to route the different users that log in.  It maps the users
     * to their correct dedicated pages.
     * @param user
     * @param model
     * @return
     */
    @RequestMapping (value = "/frontPage.htm", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("user") User user, ModelMap model){
     int level = loginService.login(user);
        user.setLevel(level);
        switch (level) {
            case User.PROSPECTROLE :
                MyLogger.log(user.getUser_name()+ " has logged in");
                return "redirect:prospectPage.htm";
            case User.CLIENTROLE :
                Client client = loginService.getClient(user);
                model.addAttribute(client);
                return "redirect:clientPage.htm";
            case User.ADMINROLE :
                model.addAttribute(user);
                return "redirect:adminPage.htm";
            case User.USERROLE :
                model.addAttribute(user);
                return "redirect:adminPage.htm";
            default:
                break;
        }
     user.setUser_name("loginFailed");
     
     return "loginPage";
    }

    /**
     * Method retrieves the registration form.
     * @param user
     * @param model
     * @return
     */
    @RequestMapping (value = "/register.htm")
    public String showRegisterForm(@ModelAttribute("user") User user, ModelMap model){
     
     model.addAttribute(user);
     
     return "redirect:registerPage.htm";
    }
}
