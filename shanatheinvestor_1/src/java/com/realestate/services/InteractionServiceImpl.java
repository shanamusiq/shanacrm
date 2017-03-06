/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import java.util.ArrayList;
import java.util.List;
import com.realestate.model.*;
import com.realestate.services.database.InteractionDBAccess;

/**
 *
 * @author Shana
 */
public class InteractionServiceImpl implements InteractionService {

    @Override
    public List<Interaction> getInteractions() {
        List<Interaction> interactions = InteractionDBAccess.getInteractions();
        return interactions;
    }

    @Override
    public int edit(Interaction interaction) {
        return InteractionDBAccess.edit(interaction);
    }

    @Override
    public int delete(Interaction interaction) {
        return InteractionDBAccess.delete(interaction);
    }
    @Override
    public Interaction getInteraction(int interaction_id) {
        return InteractionDBAccess.getInteraction(interaction_id);
}

}