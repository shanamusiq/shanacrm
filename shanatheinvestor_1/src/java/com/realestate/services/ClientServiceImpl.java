/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import java.util.ArrayList;
import java.util.List;
import com.realestate.model.Client;
import com.realestate.services.database.ClientDBAccess;


/**
 *
 * @author Shana
 */
public class ClientServiceImpl implements ClientService {

@Override
    public List<Client> getClients() {
        List<Client> clients = ClientDBAccess.getClients();
        return clients;
    }

    @Override
    public int edit(Client client) {
        return ClientDBAccess.edit(client);
    }

    @Override
    public int delete(Client client) {
        return ClientDBAccess.delete(client);
    }

    @Override
    public Client getClient(int client_id) {
        return ClientDBAccess.getClient(client_id);
    }

}


