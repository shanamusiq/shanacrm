/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.model.*;
import com.realestate.services.InteractionService;
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
 * These methods control the actions on the interactions pages; enables editing,
 * deleting and creating interactions.
 * @author Shana
 */
@Controller
@SessionAttributes("interaction")
public class InteractionController {

    private InteractionService interactionService;

    /**
     *
     * @param interactionService
     */
    @Autowired
    public void setInteractionService(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    /**
     * Retrieves the list of interactions
     * @param model
     * @return
     */
    @RequestMapping(value = "/interactionPage.htm")
    public String showInteractionForm(ModelMap model) {
        List<Interaction> interactions = interactionService.getInteractions();
        model.addAttribute("interactionList", interactions);

        return "interactionPage";
    }

    /**
     * Retrieves the edit interaction page
     * @param interaction_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editInteraction.htm")
    public String editInteractionPage(@RequestParam("interaction_id") int interaction_id, ModelMap model) {
        return "redirect:editInteractionPage.htm?interaction_id=" + interaction_id;
    }

    /**
     * Retrieves the page with the form that can be updated to make changes to interaction
     * @param interaction_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editInteractionPage.htm")
    public String showEditInteractionPage(@RequestParam("interaction_id") int interaction_id, ModelMap model) {
        Interaction interaction = interactionService.getInteraction(interaction_id);
        model.addAttribute("interaction", interaction);
        return "editInteractionPage";
    }

    /**
     * Method to submit updated changes
     * @param interaction
     * @param model
     * @return
     */
    @RequestMapping(value = "/submitEditInteractionPage.htm")
    public String submitEditInteractionPage(@ModelAttribute("interaction") Interaction interaction, ModelMap model) {
        System.out.println("Editing " + interaction.getInteraction_id() + " : " + interaction.getEmail()); //?
        int result = interactionService.edit(interaction);
        return "redirect:interactionPage.htm";
    }

    /**
     * Method that deletes the interaction and all of the corresponding info
     * @param interaction_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteInteraction.htm")
    public String deleteInteractionPage(@RequestParam("interaction_id") int interaction_id, ModelMap model) {
        Interaction interaction = new Interaction();
        interaction.setInteraction_id(interaction_id);
        System.out.println("Deleting Interaction " + interaction_id);
        int result = interactionService.delete(interaction);
        return "redirect:interactionPage.htm";

    }

        @RequestMapping(value = "/ToAdminFromInteraction.htm")
    public String ToAdminPage(ModelMap model) {
        return "redirect:adminPage.htm";
    }
}
