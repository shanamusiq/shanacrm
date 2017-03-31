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

    /**
     *Method to perform all functions on admin page
     * @return
     */
    public List<User> getUsers();

    /**
     * Method that displays user list
     * @param user_id
     * @return
     */
    public User getUser(int user_id);

    /**
     * Method enables creating users
     * @param user
     * @return
     */
    public int edit(User user);
 
    /**
     * Method that enables editing users
     * @param user
     * @return
     */
    public int delete(User user); 
        
    /**
     * Method that enables deleting of users
     * @return
     */
    public List<Prospect> getProspects();

    /**
     * Method that displays prospects
     * @param prospect_id
     * @return
     */
    public Prospect getProspect(int prospect_id);

    /**
     * Method that enables creation of prospect
     * @param prospect
     * @return
     */
    public int edit(Prospect prospect);

    /**
     *
     * @param prospect
     * @return
     */
    public int delete(Prospect prospect);

    /**
     * Method that enables deleting of prospects
     * @param prospect
     * @return
     */
    public int upgrade (Prospect prospect);

    /**
     * Method that moves prospect to a client; also updates the correct
     * level for client for login access
     * @return
     */
    public List<Client> getClients();

    /**
     * Method that displays list of clients
     * @param client_id
     * @return
     */
    public Client getClient(int client_id);

    /**
     * Method enables creation of client
     * @param client
     * @return
     */
    public int edit(Client client);

    /**
     * Method enables editing of client
     * @param client
     * @return
     */
    public int delete(Client client);

    /**
     * Method changes the client to a prospect; also updates the correct
     * level for prospect for login access
     * @param client
     * @return
     */
    public int downgrade(Client client);
        
    /**
     * Methods for all of the functions within the interaction page
     */
    public interface InteractionService {

               /**
                * Retrieves the list for all interactions
                * @return
                */
               public List<Interaction> getInteractions();

        /**
         * Method that allows the creation of interactions
         * @param interaction_id
         * @return
         */
        public User getInteraction(int interaction_id);

               /**
                * Method that enables editing of interactions
                * @param interaction
                * @return
                */
               public int edit(Interaction interaction);

        /**
         * Method that enables deleting of interactions
         * @param interaction
         * @return
         */
        public int delete(Interaction interaction); 
           }
}

