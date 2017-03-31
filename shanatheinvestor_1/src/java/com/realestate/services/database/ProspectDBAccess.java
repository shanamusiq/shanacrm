/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services.database;

import com.realestate.model.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Method used to connect to the database and control all the functions associated
 * with the prospects database
 * @author Shana
 */
public class ProspectDBAccess {

    /**
     * Connects to the database (shanacrm)
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
     * Retrieves the list of prospects within the database to display in prospect
     * section
     * @return
     */
    public static ArrayList<Prospect> getProspects() {
        ArrayList<Prospect> prospects = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM prospects");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Prospect prospect = new Prospect();
                prospect.setFirst_name(set.getString(1));
                prospect.setLast_name(set.getString(2));
                prospect.setPhone(set.getString(3));
                prospect.setAddress(set.getString(4));
                prospect.setState(set.getString(5));
                prospect.setPostal_code(set.getString(6));
                prospect.setCredit_card(set.getString(7));
                prospect.setProspect_id(set.getInt(8));
                prospect.setEmail(set.getString(9));
                prospect.setPassword(set.getString(10));
                prospect.setCredit_card_pin(set.getInt(11));
                prospect.setCredit_card_exp(set.getInt(12));
                prospect.setCity(set.getString(13));
                prospect.setUser_id(set.getInt(14));
                prospects.add(prospect);
                // System.out.println (prospect.getName());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return prospects;
    }

    /**
     * Saves updates from the changes made in the edit form
     * @param prospect
     * @return
     */
    public static int edit(Prospect prospect) {
        int result = 0;
        try {
            Connection conn = getConnection();
            if (prospect.getProspect_id() == 0) {
                PreparedStatement statement = conn.prepareStatement("INSERT INTO prospects (first_name, last_name, "
                        + "phone, address, state, zip_code, credit_card, id, email, password, card_pin, card_exp, city, user_id) "
                        + "values (\"" + prospect.getFirst_name() + "\" ,  \""
                        + prospect.getLast_name() + "\", \"" + prospect.getPhone()
                        + "\" ,  \"" + prospect.getAddress() + "\",\"" + prospect.getState()
                        + "\" ,  \"" + prospect.getPostal_code() + "\",\"" + prospect.getCredit_card() + "\" ,  "
                        + prospect.getProspect_id() + ",\"" + prospect.getEmail()
                        + "\" ,  " + "" + name(prospect.getPassword()) + ","
                        + (prospect.getCredit_card_pin()) + "," + (prospect.getCredit_card_exp()) + ","
                        + name(prospect.getCity()) + "," + prospect.getUser_id() + ")");
                        System.out.println(statement.toString());
                // correct type
                result
                        = statement.executeUpdate();
            } else {
                PreparedStatement statement = conn.prepareStatement("UPDATE prospects set first_name = \""
                        + prospect.getFirst_name()
                        + "\" , last_name = \"" + prospect.getLast_name()
                        + "\", phone = \" " + prospect.getPhone()
                        + "\" , address = \"" + prospect.getAddress()
                        + "\" , city = \"" + prospect.getCity()
                        + "\" , state = \"" + prospect.getState()
                        + "\" , zip_code = \"" + prospect.getPostal_code()
                        + "\" , credit_card = \"" + prospect.getCredit_card()
                        + "\" , card_exp = " + prospect.getCredit_card_exp()
                        + " , card_pin = " + prospect.getCredit_card_pin()
                        + " WHERE id = " + prospect.getProspect_id());
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
     * Deletes prospects from database
     * @param prospect
     * @return
     */
    public static int delete(Prospect prospect) {
        int result = 0;
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM prospects WHERE id = "
                    + prospect.getProspect_id());
            result = statement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

    /**
     * Saves new prospect to the database, for prospect creation 
     * @param prospect_id
     * @return
     */
    public static Prospect getProspect(int prospect_id) {
        Prospect prospect = new Prospect();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM prospects WHERE id = " + prospect_id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                prospect.setFirst_name(set.getString(1));
                prospect.setLast_name(set.getString(2));
                prospect.setPhone(set.getString(3));
                prospect.setAddress(set.getString(4));
                prospect.setState(set.getString(5));
                prospect.setPostal_code(set.getString(6));
                prospect.setCredit_card(set.getString(7));
                prospect.setProspect_id(set.getInt(8));
                prospect.setEmail(set.getString(9));
                prospect.setPassword(set.getString(10));
                prospect.setCredit_card_pin(set.getInt(11));
                prospect.setCredit_card_exp(set.getInt(12));
                prospect.setCity(set.getString(13));
                prospect.setUser_id(set.getInt(14));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return prospect;
    }
}
