/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import com.realestate.model.Client;
import com.realestate.model.Deal;
import java.util.List;

/**
 * 
 * @author Shana
 */
public interface ClientService {

    /**
     *
     * @return
     */
    public List<Client> getClients();

    /**
     *
     * @param client_id
     * @return
     */
    public Client getClient(int client_id);

    /**
     *
     * @param client
     * @return
     */
    public int edit(Client client);

    /**
     *
     * @param client
     * @return
     */
    public int delete(Client client);
    
       	public List<Deal> getDeals(int client_id);
        public Deal getDeal(int deal_id);
        public int edit(Deal deal);
        public int delete(Deal deal); 
       
}
