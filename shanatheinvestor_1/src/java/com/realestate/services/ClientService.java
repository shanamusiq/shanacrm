/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import com.realestate.model.Client;
import java.util.List;

/**
 *
 * @author Shana
 */
public interface ClientService {
    public List<Client> getClients();
        public Client getClient(int client_id);
        public int edit(Client client);
        public int delete(Client client);
       
}
