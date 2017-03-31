/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import java.util.ArrayList;
import java.util.List;
import com.realestate.model.*;
import com.realestate.services.database.*;


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
       @Override
    public List<Deal> getDeals(int client_id) {
        List<Deal> deals = DealDBAccess.getDeals(client_id);
        return deals;
    }

    @Override
    public int edit(Deal deal) {
        return DealDBAccess.edit(deal);
    }

    @Override
    public int delete(Deal deal) {
        return DealDBAccess.delete(deal);
    }
    
    @Override
    public Deal getDeal(int deal_id) {
        return DealDBAccess.getDeal(deal_id);
    }

}


