/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services;

import java.util.List;
import com.realestate.model.*;
import com.realestate.services.database.ClientDBAccess;
import com.realestate.services.database.ProspectDBAccess;
import com.realestate.services.database.UserDBAccess;

/**
 *
 * @author Shana
 */
public class AdminServiceImpl implements AdminService {

    @Override
    public List<User> getUsers() {
        List<User> users = UserDBAccess.getUsers();
        return users;
    }

    @Override
    public int edit(User user) {
        return UserDBAccess.edit(user);
    }

    @Override
    public int delete(User user) {
        return UserDBAccess.delete(user);
    }

    @Override
    public User getUser(int user_id) {
        return UserDBAccess.getUser(user_id);
    }

    @Override
    public List<Prospect> getProspects() {
        List<Prospect> prospects = ProspectDBAccess.getProspects();
        return prospects;
    }

    @Override
    public int edit(Prospect prospect) {
        return ProspectDBAccess.edit(prospect);
    }

    @Override
    public int delete(Prospect prospect) {
        return ProspectDBAccess.delete(prospect);
    }
        @Override
    public int upgrade(Prospect prospect) {
        Client client = new Client();
        client.setClient_id(0);
        client.setAddress(prospect.getAddress());
        client.setFirst_name(prospect.getFirst_name());
        client.setLast_name(prospect.getLast_name());
        client.setUser_id(prospect.getUser_id());
        int n = ClientDBAccess.edit(client);
        if(n>0){
            n = ProspectDBAccess.delete(prospect);
            User user = UserDBAccess.getUser(prospect.getUser_id());
            user.setLevel(User.CLIENTROLE);
            n = UserDBAccess.edit(user);
        }
        return n;
    
    }

    @Override
    public Prospect getProspect(int prospect_id
    ) {
        return ProspectDBAccess.getProspect(prospect_id);
    }

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
    public int downgrade(Client client) {
        Prospect prospect = new Prospect();
        prospect.setProspect_id(0);
        prospect.setAddress(client.getAddress());
        prospect.setFirst_name(client.getFirst_name());
        prospect.setLast_name(client.getLast_name());
        prospect.setUser_id(client.getUser_id());
        int n = ProspectDBAccess.edit(prospect);
        if(n>0){
            n = ClientDBAccess.delete(client);
            User user = UserDBAccess.getUser(client.getUser_id());
            user.setLevel(User.PROSPECTROLE);
            n = UserDBAccess.edit(user);
        }
        return n;
    
    }

}
