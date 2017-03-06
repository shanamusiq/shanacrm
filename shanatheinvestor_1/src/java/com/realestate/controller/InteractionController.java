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
 *
 * @author Shana
 */
@Controller
@SessionAttributes("interaction")
public class InteractionController {

    @RequestMapping(value = "/interactionPage.htm")
    public String showInteractionForm(ModelMap model) {
        Interaction interaction = new Interaction();
        model.addAttribute(interaction);
        return "interactionPage";
    }

        private InteractionService interactionService;

        @Autowired
        public void setInteractionService(InteractionService interactionService) {
            this.interactionService = interactionService;
        }

        @RequestMapping(value = "/editInteraction.htm")
        public String editInteractionPage(@RequestParam("interaction_id") int interaction_id, ModelMap model) {
            return "redirect:editInteractionPage.htm?Interaction_id=" + interaction_id;
        }

        @RequestMapping(value = "/editInteractionPage.htm")
        public String showEditInteractionPage(@RequestParam("interaction_id") int interaction_id, ModelMap model) {
            Interaction interaction = interactionService.getInteraction(interaction_id);
            model.addAttribute("interaction", interaction);
            return "editInteractionPage";
        }

        @RequestMapping(value = "/submitEditInteractionPage.htm")
        public String submitEditInteractionPage(@ModelAttribute("interaction") Interaction interaction, ModelMap model) {
            System.out.println("Editing " + interaction.getInteraction_id() + " : " + interaction.getEmail()); //?
            //int result = interactionService.edit(interaction);
            return "redirect:interactionPage.htm";
        }

        @RequestMapping(value = "/deleteInteraction.htm")
        public String deleteInteractionPage(@RequestParam("interaction_id") int interaction_id, ModelMap model) {
            Interaction interaction = new Interaction();
            interaction.setInteraction_id(interaction_id);
            System.out.println("Deleting Interaction " + interaction_id);
            //int result = interactionService.delete(interaction);
            return "redirect:interactionPage.htm";

        }

    }

