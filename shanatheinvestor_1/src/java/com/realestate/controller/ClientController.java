/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.model.*;
import com.realestate.services.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Shana
 */
@Controller
@SessionAttributes("client")
public class ClientController {

    @RequestMapping(value = "/clientPage.htm")
    public String showClientForm(ModelMap model) {
        Client client = new Client();
        model.addAttribute(client);
        return "clientPage";
    }

    @RequestMapping(value = "/goTowholesaleCalculatorFromClient.htm")
    public String goTowholesaleCalculator(ModelMap model) {

        return "redirect:wholesaleCalculatorPage.htm";
    }
 @RequestMapping(value = "/downloadDashboard.htm")
    public String downloadDashboard(ModelMap model) {

        return "test.txt";
    }
        private ClientService clientService;

        @Autowired
        public void setClientService(ClientService clientService) {
            this.clientService = clientService;
        }

        @RequestMapping(value = "/editDeal.htm")
        public String editClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
            return "redirect:editClientPage.htm?client_id=" + client_id;
        }

        @RequestMapping(value = "/editDealPage.htm")
        public String showEditClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
            Client client = clientService.getClient(client_id);
            model.addAttribute("client", client);
            return "editClientPage";
        }

        @RequestMapping(value = "/submitEditDealPage.htm")
        public String submitEditClientPage(@ModelAttribute("client") Client client, ModelMap model) {
            System.out.println("Editing " + client.getClient_id() + " : " + client.getEmail());
            //int result = clientService.edit(client);
            return "redirect:clientPage.htm";
        }

        @RequestMapping(value = "/deleteDeal.htm")
        public String deleteClientPage(@RequestParam("client_id") int client_id, ModelMap model) {
            Client client = new Client();
            client.setClient_id(client_id);
            System.out.println("Deleting Client " + client_id);
            //int result = clientService.delete(client);
            return "redirect:clientPage.htm";

        }

    }

