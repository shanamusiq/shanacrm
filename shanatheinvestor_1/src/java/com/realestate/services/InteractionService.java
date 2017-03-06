/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import java.util.List;
import com.realestate.model.Interaction;

/**
 *
 * @author Shana
 */
public interface InteractionService {
   	public List<Interaction> getInteractions();
        public Interaction getInteraction(int interaction_id);
        public int edit(Interaction interaction);
        public int delete(Interaction interaction); 
        
}
// Add Interaction
