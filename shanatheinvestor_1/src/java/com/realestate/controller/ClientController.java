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
 * These methods are used to retrieve pages that update, delete, and edit the
 * deals listed on client page
 * @author Shana
 */
@Controller
@SessionAttributes("client")
public class ClientController {

    /**
     * Retrieves the client page 
     * @param model
     * @return
     */
    @RequestMapping(value = "/clientPage.htm")
    public String showClientForm(@ModelAttribute("client") Client client, ModelMap model) {

        List<Deal> deals = clientService.getDeals(client.getClient_id());
        model.addAttribute("dealList", deals);
        model.addAttribute(client);
        System.out.println(client.getClient_id());
        return "clientPage";
    }

    /**
     * Link that goes to Wholesale Calc
     * @param model
     * @return
     */
    @RequestMapping(value = "/goTowholesaleCalculatorFromClient.htm")
    public String goTowholesaleCalculator(ModelMap model) {

        return "redirect:wholesaleCalculatorPage.htm";
    }

    /**
     * Method for downloading dashboard created in Excel
     * @param model
     * @return
     */
    @RequestMapping(value = "/downloadDashboard.htm")
    public String downloadDashboard(ModelMap model) {

        return "test.txt";
    }
        private ClientService clientService;

    /**
     *
     * @param clientService
     */
    @Autowired
        public void setClientService(ClientService clientService) {
            this.clientService = clientService;
        }

    /**
     * Method used to retrieve page where deals are listed.
     * @param client_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editDeal.htm")
        public String editClientPage(@RequestParam("deal_id") int deal_id, ModelMap model) {
            return "redirect:editDealPage.htm?deal_id=" + deal_id;
        }

    /**
     * Method used to retrieve page with the form to edit deal;
     * @param client_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editDealPage.htm")
        public String showEditDealPage(@RequestParam("deal_id") int deal_id, ModelMap model) {
            Deal deal = clientService.getDeal(deal_id);
            Client client = (Client)model.get("client");
            deal.setClient_id(client.getClient_id());
            model.addAttribute("deal", deal);
            System.out.println("client = " + client.getClient_id());
            return "editDealPage";
        }

    /**
     * Submits the changes that were updated on edit deal form
     * @param client
     * @param model
     * @return
     */
    @RequestMapping(value = "/submitEditDealPage.htm")
        public String submitEditDealPage(@ModelAttribute("deal") Deal deal, ModelMap model) {
            System.out.println("Editing " + deal.getClient_id() + " " + deal.getDeal_id() + " : " + deal.getCustomer_name()+ " / " + deal.getPostal_code());
            int result = clientService.edit(deal);
            return "redirect:clientPage.htm";
        }

    /**
     * Method used to delete the deal and all corresponding information
     * @param client_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteDeal.htm")
        public String deleteDeletePage(@RequestParam("deal_id") int deal_id, ModelMap model) {
            Deal deal = new Deal();
            deal.setDeal_id(deal_id);
            System.out.println("Deleting Deal" + deal_id);
            int result = clientService.delete(deal);
            return "redirect:clientPage.htm";

        }

    /**
     * This method is used to change the sales stage of the deals
     * @param client_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateStage.htm")
        public String SaleStagePage(@RequestParam("client_id") int client_id, ModelMap model) {
            Client client = new Client();
            client.setClient_id(client_id);
            System.out.println("Deleting Client " + client_id);
            //int result = clientService.delete(client);
            return "redirect:clientPage.htm";

        }
    }

