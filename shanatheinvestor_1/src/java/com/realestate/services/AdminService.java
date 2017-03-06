/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import java.util.List;
import com.realestate.model.*;

/**
 *
 * @author Shana
 */
public interface AdminService {
   	public List<User> getUsers();
        public User getUser(int user_id);
        public int edit(User user);
        public int delete(User user); 
        
public List<Prospect> getProspects();
        public Prospect getProspect(int prospect_id);
        public int edit(Prospect prospect);
        public int delete(Prospect prospect);
        public int upgrade (Prospect prospect);

public List<Client> getClients();
        public Client getClient(int client_id);
        public int edit(Client client);
        public int delete(Client client);
         public int downgrade(Client client);
        
public interface InteractionService {
   	public List<Interaction> getInteractions();
        public User getInteraction(int interaction_id);
        public int edit(Interaction interaction);
        public int delete(Interaction interaction); 
}
}
// Add Interactions
