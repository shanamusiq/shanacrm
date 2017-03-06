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
 *
 * @author Shana
 */
public class DealDBAccess {
    
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

    public static ArrayList<Deal> getDeals() {
        ArrayList<Deal> deals = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM deal");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Deal deal = new Deal();
                deal.setDeal_id(set.getInt(1));
                deal.setProperty_address(set.getString(2));
                deal.setProperty_state(set.getString(3));
                deal.setProperty_zip_code(set.getString(4));
                deal.setCustomer_name(set.getString(5));
                deal.setCustomer_phone(set.getString(6));
                deal.setAddress(set.getString(7));
                deal.setState(set.getString(8));
                deal.setZip_code(set.getString(9));
                deal.setClose_date(set.getString(10));
                deal.setSales_stage(set.getString(11));
                deal.setAmount(set.getInt(12));
                deal.setComment(set.getString(13));
                deals.add(deal);
                //System.out.println (client.getName());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return deals;
    }

    public static int edit(Deal deal) {
        int result = 0;
        try {
            Connection conn = getConnection();
            if (deal.getDeal_id()== 0) {
                PreparedStatement statement = conn.prepareStatement("INSERT INTO Deals (deal_id, property_address, "
                        + "property_state, property_postal_code, customer_name,customer_phone , address, state, zip_code, close_date, sales_stage, amount, comment) "
                        + "values (\"" + deal.getDeal_id()+ "\" ,  \""
                        + deal.getProperty_postal_code()+ "\", \"" + deal.getCustomer_name()
                        + "\" ,  \"" + deal.getCustomer_phone()+ "\",\"" + deal.getAddress()
                        + "\" ,  \"" + deal.getState()+ "\",\"" + deal.getZip_code() + "\" ,  \""
                        + deal.getClose_date() + "\",\"" +deal.getSales_stage()+ "\" ,  \"" + deal.getAmount()
                        + deal.getComment() + ")");
               
                result
                        = statement.executeUpdate();
            } else {
                PreparedStatement statement = conn.prepareStatement("UPDATE deals set deal_id = \""
                        + deal.getDeal_id()
                        + "\" , property_address = \"" + deal.getProperty_address()
                        + "\",  property_state= " + deal.getProperty_state()
                        + "\" , property_postal_code = \"" + deal.getProperty_postal_code()
                        + "\" , customer_name = \"" + deal.getCustomer_name()
                        + "\" , customer_phone = \"" + deal.getCustomer_phone()
                        + "\" , address = \"" + deal.getAddress()
                        + "\" , state = \"" + deal.getState()
                        + "\" , zip_code = \"" + deal.getZip_code()
                        + "\" , close_date = \"" + deal.getClose_date()
                        + "\" , sales_stage = \"" + deal.getSales_stage()
                        + "\" , amount = \"" + deal.getAmount()
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

    public static int delete(Deal deal) {
        int result = 0;
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE from deals WHERE deal_id = "
                    + deal.getDeal_id());
            result = statement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;

    }

    public static Deal getDeal(int deal_id) {
        Deal deal = new Deal();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM deals WHERE deal_id = " + deal_id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                deal.setDeal_id(set.getInt(1));
                deal.setProperty_address(set.getString(2));
                deal.setProperty_state(set.getString(3));
                deal.setProperty_zip_code(set.getString(4));
                deal.setCustomer_name(set.getString(5));
                deal.setCustomer_phone(set.getString(6));
                deal.setAddress(set.getString(7));
                deal.setState(set.getString(8));
                deal.setZip_code(set.getString(9));
                deal.setClose_date(set.getString(10));
                deal.setSales_stage(set.getString(11));
                deal.setAmount(set.getInt(12));
                deal.setComment(set.getString(13));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return deal;
    }
}
