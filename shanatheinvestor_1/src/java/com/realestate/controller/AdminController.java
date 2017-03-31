/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.model.Client;
import com.realestate.model.Interaction;
import com.realestate.model.Prospect;
import com.realestate.model.User;
import com.realestate.services.AdminService;
import com.realestate.services.InteractionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controller for the admin page that contains all the methods for retrieving pages
 * that are used for editing,deleting and creating new users, prospects and clients 
 * @author Shana
 */
@Controller
@SessionAttributes({"user", "prospect", "client"})
public class AdminController {

    private AdminService adminService;

    /**
     * Constructor for admin service
     * @param adminService
     */
    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * Constructor for list of users, prospects and clients
     * @param model
     * @return
     */
    @RequestMapping(value = "/adminPage.htm")
    public String showAdminForm(@ModelAttribute("user") User user, ModelMap model) {
        List<User> users = adminService.getUsers();
        model.addAttribute("userList", users);
        List<Prospect> prospects = adminService.getProspects();
        model.addAttribute("prospectList", prospects);
        List<Client> clients = adminService.getClients();
        model.addAttribute("clientList", clients);
        model.addAttribute("mainuser", user);
        System.out.println (user.getUser_name()+ " " + user.getLevel());
        return "adminPage";
    }

    /**
     * Retrieves the edit user page
     * @param user_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editUser.htm")
    public String editUserPage(@RequestParam("user_id") int user_id, ModelMap model) {
        return "redirect:editUserPage.htm?user_id=" + user_id;
    }

    /**
     * Retrieves the edit user form that can be updated.
     * @param user_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editUserPage.htm")
    public String showEditUserPage(@RequestParam("user_id") int user_id, ModelMap model) {
        User user = adminService.getUser(user_id);
        model.addAttribute("user", user);
        return "editUserPage";
    }

    /**
     * Submit method for edit user form/updates
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/submitEditUserPage.htm")
    public String submitEditUserPage(@ModelAttribute("user") User user, ModelMap model) {
        System.out.println("Editing " + user.getUser_id() + " : " + user.getUser_name());
        int result = adminService.edit(user);
        return "redirect:adminPage.htm";
    }

    /**
     * Deletes all content that is correlated to user and deletes user
     * @param user_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteUser.htm")
    public String deleteUserPage(@RequestParam("user_id") int user_id, ModelMap model) {
        User user = new User();
        user.setUser_id(user_id);
        System.out.println("Deleting User " + user_id);
        int result = adminService.delete(user);
        return "redirect:adminPage.htm";
    }

    /**
     * Retrieves the edit page page
     * @param prospect_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editProspect.htm")
    public String editProspectPage(@RequestParam("prospect_id") int prospect_id, ModelMap model) {
        return "redirect:editProspectPage.htm?prospect_id=" + prospect_id;
    }

    /**
     * Retrieves the edit user form that can be updated.
     * @param prospect_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editProspectPage.htm")
    public String showEditProspectPage(@RequestParam("prospect_id") int prospect_id, ModelMap model) {
        Prospect prospect = adminService.getProspect(prospect_id);
        model.addAttribute("prospect", prospect);
        return "editProspectPage";
    }

    /**
     * Submit method for edit prospect form/updates
     * @param prospect
     * @param model
     * @return
     */
    @RequestMapping(value = "/submitEditProspectPage.htm")
    public String submitEditProspectPage(@ModelAttribute("prospect") Prospect prospect, ModelMap model) {
        System.out.println("Editing " + prospect.getProspect_id() + " : " + prospect.getUser_id());
        int result = adminService.edit(prospect);
        return "redirect:adminPage.htm";
    }

    /**
     * Deletes all content that is correlated to prospect and deletes user
     * @param prospect_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteProspect.htm")
    public String deleteProspectPage(@RequestParam("prospect_id") int prospect_id, ModelMap model) {
        Prospect prospect = new Prospect();
        prospect.setProspect_id(prospect_id);
        System.out.println("Deleting Prospect " + prospect_id);
        int result = adminService.delete(prospect);
        return "redirect:adminPage.htm";

    }

    /**
     * This upgrades the prospect to a client
     * @param prospect_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/upgradeProspect.htm")
    public String upgradeProspectPage(@RequestParam("prospect_id") int prospect_id, ModelMap model) {
        Prospect prospect = adminService.getProspect(prospect_id);
        adminService.upgrade(prospect);
        return "redirect:adminPage.htm";
    }

    /**
     * Retrieves the edit client page
     * @param client_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editClient.htm")
    public String editClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
        return "redirect:editClientPage.htm?client_id=" + client_id;
    }

    /**
     * Retrieves the edit prospect form page that can be updated.
     * @param client_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editClientPage.htm")
    public String showEditClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
        Client client = adminService.getClient(client_id);
        model.addAttribute("client", client);
        return "editClientPage";
    }

    /**
     * Submit method for edit client form/updates
     * @param client
     * @param model
     * @return
     */
    @RequestMapping(value = "/submitEditClientPage.htm")
    public String submitClientPage(@ModelAttribute("client") Client client, ModelMap model) {
        System.out.println("Editing " + client.getClient_id() + " : " + client.getFirst_name()); 
        int result = adminService.edit(client);
        return "redirect:adminPage.htm";
    }

    /**
     * Deletes all content that is correlated to user and deletes user
     * @param client_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteClient.htm")
    public String deleteClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
        Client client = new Client();
        client.setClient_id(client_id);
        System.out.println("Deleting Client " + client_id);
        int result = adminService.delete(client);
        return "redirect:adminPage.htm";
    }

    /**
     * Method moves the client to prospect list
     * @param client_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/downgradeClient.htm")
    public String downgradeClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
        Client client = adminService.getClient(client_id);
        adminService.downgrade(client);
        return "redirect:adminPage.htm";
    }

    /**
     * Link that goes to the interactions page
     * @param model
     * @return
     */
    @RequestMapping(value = "/GoToInteractionPage.htm")
    public String GoToInteractionPage(ModelMap model) {

        return "redirect:interactionPage.htm";
    }
            @RequestMapping(value = "/ToLoginFromAdmin.htm")
    public String ToLoginPage(ModelMap model) {
        return "redirect:frontPage.htm";
    }
}
