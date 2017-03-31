/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services.database;

import com.realestate.model.Deal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Method used to connect to the database and control all the functions associated
 * with the deal database
 * @author Shana
 */
public class DealDBAccess {
    
    /**
     * Connects to database (shanacrm)
     * @return
     */
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

    /**
     * Retrieves the list of deals in the database to displace in deals 
     * section
     * @return
     */
    public static ArrayList<Deal> getDeals(int client_id) {
        ArrayList<Deal> deals = new ArrayList<>();
        try {
            Connection conn = getConnection();
            System.out.println ("database = " + client_id);
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM deals1 WHERE client_id = "+ client_id);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Deal deal = new Deal();
                deal.setDeal_id(set.getInt(1));
                deal.setProperty_address(set.getString(2));
                deal.setProperty_state(set.getString(3));
                deal.setProperty_postal_code(set.getString(4));
                deal.setCustomer_name(set.getString(5));
                deal.setCustomer_phone(set.getString(6));
                deal.setAddress(set.getString(7));
                deal.setState(set.getString(8));
                deal.setPostal_code(set.getString(9));
                deal.setClose_date(set.getString(10));
                deal.setSales_stage(set.getString(11));
                deal.setAmount(set.getInt(12));
                deal.setComment(set.getString(13));
                deal.setClient_id(set.getInt(14));
                deals.add(deal);
                System.out.println (deal.getCustomer_name());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return deals;
    }

    /**
     * Saves changes of updated info in the database
     * @param deal
     * @return
     */
    public static int edit(Deal deal) {
        int result = 0;
        try {
            Connection conn = getConnection();
            if (deal.getDeal_id()== 0) {
                PreparedStatement statement = conn.prepareStatement("INSERT INTO Deals1 (deal_id, property_address, "
                        + "property_state, property_zip_code, customer_name,customer_phone , address, state, zip_code, close_date, sales_stage, amount, comment, client_id) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                System.out.println(deal.getPostal_code()+ " "+ deal.getProperty_postal_code());
                statement.setInt(1, deal.getDeal_id());
                statement.setString(2, deal.getProperty_address());
                statement.setString(3, deal.getState());
                statement.setString(4, deal.getProperty_postal_code());
                statement.setString(5, deal.getCustomer_name());
                statement.setString(6, deal.getCustomer_phone());
                statement.setString(7, deal.getAddress());
                statement.setString(8, deal.getState());
                statement.setString(9, deal.getPostal_code());
                statement.setString(10, deal.getClose_date());
                statement.setString(11, deal.getSales_stage());
                statement.setInt(12, deal.getAmount());
                statement.setString(13, deal.getComment());
                statement.setInt(14, deal.getClient_id());
               
                result
                        = statement.executeUpdate();
            } else {
                PreparedStatement statement = conn.prepareStatement("UPDATE deals1 set deal_id = \""
                        + deal.getDeal_id()
                        + "\" , property_address = \"" + deal.getProperty_address()
                        + "\",  property_state= " + deal.getProperty_state()
                        + "\" , property_postal_code = \"" + deal.getProperty_postal_code()
                        + "\" , customer_name = \"" + deal.getCustomer_name()
                        + "\" , customer_phone = \"" + deal.getCustomer_phone()
                        + "\" , address = \"" + deal.getAddress()
                        + "\" , state = \"" + deal.getState()
                        + "\" , zip_code = \"" + deal.getPostal_code()
                        + "\" , close_date = \"" + deal.getClose_date()
                        + "\" , sales_stage = \"" + deal.getSales_stage()
                        + "\" , amount = \"" + deal.getAmount()
                        + ",client_id=" + deal.getClient_id()
                        + " WHERE deal_id = " + deal.getDeal_id());
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

    /**
     * Deletes deal from database
     * @param deal
     * @return
     */
    public static int delete(Deal deal) {
        int result = 0;
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM deals1 WHERE deal_id = "
                    + deal.getDeal_id());
            result = statement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;

    }

    /**
     * Saves new deal to database, for deal creation
     * @param deal_id
     * @return
     */
    public static Deal getDeal(int deal_id) {
        Deal deal = new Deal();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM deals1 WHERE deal_id = " + deal_id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                deal.setDeal_id(set.getInt(1));
                deal.setProperty_address(set.getString(2));
                deal.setProperty_state(set.getString(3));
                deal.setProperty_postal_code(set.getString(4));
                deal.setCustomer_name(set.getString(5));
                deal.setCustomer_phone(set.getString(6));
                deal.setAddress(set.getString(7));
                deal.setState(set.getString(8));
                deal.setPostal_code(set.getString(9));
                deal.setClose_date(set.getString(10));
                deal.setSales_stage(set.getString(11));
                deal.setAmount(set.getInt(12));
                deal.setComment(set.getString(13));
                deal.setClient_id(set.getInt(14));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return deal;
    }
}
