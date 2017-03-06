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
 *
 * @author Shana
 */
@Controller
@SessionAttributes({"user","prospect"})
public class AdminController {

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/adminPage.htm")
    public String showAdminForm(ModelMap model) {
        List<User> users = adminService.getUsers();
        model.addAttribute("userList", users);
        List<Prospect> prospects = adminService.getProspects();
        model.addAttribute("prospectList", prospects);
        List<Client> clients = adminService.getClients();
        model.addAttribute("clientList", clients);
        return "adminPage";
    }

    @RequestMapping(value = "/editUser.htm")
    public String editUserPage(@RequestParam("user_id") int user_id, ModelMap model) {
        return "redirect:editUserPage.htm?user_id=" + user_id;
    }

    @RequestMapping(value = "/editUserPage.htm")
    public String showEditUserPage(@RequestParam("user_id") int user_id, ModelMap model) {
        User user = adminService.getUser(user_id);
        model.addAttribute("user", user);
        return "editUserPage";
    }

    @RequestMapping(value = "/submitEditUserPage.htm")
    public String submitEditUserPage(@ModelAttribute("user") User user, ModelMap model) {
        System.out.println("Editing " + user.getUser_id() + " : " + user.getUser_name());
        //int result = adminService.edit(user);
        return "redirect:adminPage.htm";
    }

    @RequestMapping(value = "/deleteUser.htm")
    public String deleteUserPage(@RequestParam("user_id") int user_id, ModelMap model) {
        User user = new User();
        user.setUser_id(user_id);
        System.out.println("Deleting User " + user_id);
        //int result = adminService.delete(user);
        return "redirect:adminPage.htm";
    }
    @RequestMapping(value = "/editProspect.htm")
    public String editProspectPage(@RequestParam("prospect_id") int prospect_id, ModelMap model) {
        return "redirect:editProspectPage.htm?prospect_id=" + prospect_id;
    }
    @RequestMapping(value = "/editProspectPage.htm")
    public String showEditProspectPage(@RequestParam("user_id") int user_id, ModelMap model) {
        User user = adminService.getUser(user_id);
        model.addAttribute("user", user);
        return "editProspectPage";
    }

    @RequestMapping(value = "/submitEditProspectPage.htm")
    public String submitEditProspectPage(@ModelAttribute("prospect") Prospect prospect, ModelMap model) {
        System.out.println("Editing " + prospect.getProspect_id() + " : " + prospect.getUser_id());
        //int result = adminService.edit(user);
        return "redirect:adminPage.htm";
    }

    @RequestMapping(value = "/deleteProspect.htm")
    public String deleteProspectPage(@RequestParam("prospect_id") int prospect_id, ModelMap model) {
        Prospect prospect = new Prospect();
        prospect.setProspect_id(prospect_id);
        System.out.println("Deleting Prospect " + prospect_id);
        //int result = adminService.delete(prospect);
        return "redirect:adminPage.htm";
        
       
    }
    
    @RequestMapping(value = "/upgradeProspect.htm")
    public String upgradeProspectPage(@RequestParam("prospect_id") int prospect_id, ModelMap model) {
        Prospect prospect = adminService.getProspect(prospect_id);
        adminService.upgrade(prospect);
        return "redirect:adminPage.htm"; 
    }
    @RequestMapping(value = "/editClient.htm")
    public String editClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
        return "redirect:editClientPage.htm?client_id=" + client_id;
    }

    @RequestMapping(value = "/editClientPage.htm")
    public String showEditClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
      //  Client client = adminService.getClient(client_id);
     // model.addAttribute("client", client);
        return "editClientPage";
    }

    @RequestMapping(value = "/submitEditClientPage.htm")
    public String submitClientPage(@ModelAttribute("client") Client client, ModelMap model) {
        System.out.println("Editing " + client.getClient_id() + " : " + client.getFirst_name()); //should I add last name since there is no client_name?
        //int result = adminService.edit(client);
        return "redirect:AdminPage.htm";
    }

    @RequestMapping(value = "/deleteClient.htm")
    public String deleteClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
        Client client = new Client();
        client.setClient_id(client_id);
        System.out.println("Deleting Client " + client_id);
        //int result = adminService.delete(client);
        return "redirect:AdminPage.htm";
}
    @RequestMapping(value = "/downgradeClient.htm")
    public String downgradeClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
        Client client = adminService.getClient(client_id);
        adminService.downgrade(client);
        return "redirect:adminPage.htm"; 
    }

}

