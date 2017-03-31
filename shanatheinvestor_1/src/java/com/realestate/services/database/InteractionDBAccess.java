/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.services.database;

import com.realestate.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Method used to connect to the database and control all the functions associated
 * with the interactions database
 * @author Shana
 */
public class InteractionDBAccess {

    /**
     * Connects to the database
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
     * List interactions that are in the database
     * @return
     */
    public static ArrayList<Interaction> getInteractions() {
        ArrayList<Interaction> interactions = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM interactions1");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Interaction interaction = new Interaction();
                interaction.setName(set.getString(3));
                interaction.setEmail(set.getString(4));
                interaction.setInteraction_id(set.getInt(1));
                interaction.setPhone(set.getString(5));
                interaction.setUser_id(set.getInt(2));
                interaction.setProspect_id(set.getInt(6));
                interaction.setClient_id(set.getInt(7));
                interaction.setComments(set.getString(8));
                interactions.add(interaction);
                System.out.println (interaction.getComments());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return interactions;
    }

    /**
     * Saves changes and updates to interactions in the database
     * @param interaction
     * @return
     */
    public static int edit(Interaction interaction) {
        int result = 0;
        try {
            Connection conn = getConnection();
            if (interaction.getInteraction_id()== 0) {
                PreparedStatement statement = conn.prepareStatement("INSERT INTO interactions1 (interaction_id, user_id, name, "
                        + "email, phone, prospect_id, client_id, comments) "
                        + "values (" + interaction.getInteraction_id()+ " ,  "
                        + interaction.getUser_id() + ", \"" + interaction.getName()
                        + "\" ,  \"" + interaction.getEmail() + "\",\"" + interaction.getPhone()
                        + "\" ,  " + interaction.getProspect_id() + "," + interaction.getClient_id() + " ,  \""
                        + interaction.getComments()  + "\")" );
               
                result
                        = statement.executeUpdate();
            } else {
                PreparedStatement statement = conn.prepareStatement("UPDATE interactions1 set user_id = "
                       
                        + interaction.getUser_id()
                        + ", name = \"" + interaction.getName()
                        + "\" , email = \"" + interaction.getEmail()
                        + "\", phone = \"" + interaction.getPhone()                    
                        + "\" , prospect_id = " + interaction.getProspect_id()
                        + " , client_id = " + interaction.getClient_id()
                        + " , comments = \"" + interaction.getComments()
                        + "\" WHERE interaction_id = " + interaction.getInteraction_id());
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
     * Deletes interactions from the database
     * @param interaction
     * @return
     */
    public static int delete(Interaction interaction) {
        int result = 0;
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM interactions1 WHERE interaction_id = "
                    + interaction.getInteraction_id());
            result = statement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;

    }

    /**
     * Saves new interaction from the database, for interaction creation
     * @param interaction_id
     * @return
     */
    public static Interaction getInteraction(int interaction_id) {
        Interaction interaction = new Interaction();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM interactions1 WHERE interaction_id = " + interaction_id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                interaction.setUser_id(set.getInt(2));
                interaction.setName(set.getString(3));
                interaction.setEmail(set.getString(4));
                interaction.setInteraction_id(set.getInt(1));
                interaction.setPhone(set.getString(5));
                interaction.setProspect_id(set.getInt(6));
                interaction.setClient_id(set.getInt(7));
                interaction.setComments(set.getString(8));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return interaction;
    }
}

