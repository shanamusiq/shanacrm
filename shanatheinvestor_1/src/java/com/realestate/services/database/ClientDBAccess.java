/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services.database;

import com.realestate.model.*;
import static com.realestate.services.database.ProspectDBAccess.getConnection;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Shana
 */
public class ClientDBAccess {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shanacrm", "root", "smh.03005");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return conn;
    }

    public static ArrayList<Client> getClients() {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM clients");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Client client = new Client();
                client.setFirst_name(set.getString(1));
                client.setLast_name(set.getString(2));
                client.setPhone(set.getString(3));
                client.setAddress(set.getString(4));
                client.setState(set.getString(5));
                client.setPostal_code(set.getString(6));
                client.setCredit_card(set.getString(7));
                client.setClient_id(set.getInt(8));
                client.setEmail(set.getString(9));
                client.setPassword(set.getString(10));
                client.setCredit_card_pin(set.getInt(11));
                client.setCredit_card_exp(set.getInt(12));
                client.setCity(set.getString(13));
                client.setUser_id(set.getInt(14));
                clients.add(client);
                //System.out.println (client.getName());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return clients;
    }

    public static int edit(Client client) {
        int result = 0;
        try {
            Connection conn = getConnection();
            if (client.getClient_id() == 0) {
                PreparedStatement statement = conn.prepareStatement("INSERT INTO clients (first_name, last_name, "
                        + "phone, address, state, zip_code, credit_card, client_id, email, password, card_pin, card_exp, city, user_id) "
                        + "values (\"" + client.getFirst_name() + "\" ,  \""
                        + client.getLast_name() + "\", \"" + client.getPhone()
                        + "\" ,  \"" + client.getAddress() + "\",\"" + client.getState()
                        + "\" ,  \"" + client.getPostal_code() + "\",\"" + client.getCredit_card() + "\" , "
                        + client.getClient_id() + ",\"" + client.getEmail()
                        + "\" " + "" + "," + name(client.getPassword()) + ","
                        + (client.getCredit_card_pin()) + "," + (client.getCredit_card_exp()) + ","
                        + name(client.getCity()) + "," + client.getUser_id() + ")");
                System.out.println(statement.toString());
                // correct type
                result
                        = statement.executeUpdate();
            } else {
                PreparedStatement statement = conn.prepareStatement("UPDATE clients set first_name = \""
                        + client.getFirst_name()
                        + "\" , last_name = \"" + client.getLast_name()
                        + "\", phone = " + client.getUser_id()
                        + "\" , address = \"" + client.getAddress()
                        + "\" , city = \"" + client.getCity()
                        + "\" , state = \"" + client.getState()
                        + "\" , zip = \"" + client.getPostal_code()
                        + "\" , card = \"" + client.getCredit_card()
                        + "\" , card_exp = \"" + client.getCredit_card_exp()
                        + "\" , card_pin = \"" + client.getCredit_card_pin()
                        + " WHERE client_id = " + client.getClient_id());
                result = statement.executeUpdate();
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

    private static String name(String x) {
        return "\"" + x + "\"";

    }

    public static int delete(Client client) {
        int result = 0;
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE from clients WHERE client_id = "
                    + client.getClient_id());
            result = statement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;

    }

    public static Client getClient(int client_id) {
        Client client = new Client();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM clients WHERE client_id = " + client_id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                client.setFirst_name(set.getString(1));
                client.setLast_name(set.getString(2));
                client.setPhone(set.getString(3));
                client.setAddress(set.getString(4));
                client.setState(set.getString(5));
                client.setPostal_code(set.getString(6));
                client.setCredit_card(set.getString(7));
                client.setClient_id(set.getInt(8));
                client.setEmail(set.getString(9));
                client.setPassword(set.getString(10));
                client.setCredit_card_pin(set.getInt(11));
                client.setCredit_card_exp(set.getInt(12));
                client.setCity(set.getString(13));
                client.setUser_id(set.getInt(14));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return client;
    }
}
