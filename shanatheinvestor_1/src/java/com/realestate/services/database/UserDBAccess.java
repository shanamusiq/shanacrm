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
 *
 * @author Shana
 */
public class UserDBAccess {

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

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM users");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                User user = new User();
                user.setUser_id(set.getInt(1));
                user.setUser_name(set.getString(2));
                user.setPassword(set.getString(3));
                user.setLevel(set.getInt(4));
                users.add(user);
                //System.out.println (user.getName());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return users;
    }

    /**
     *
     * @param user_id
     * @return
     */
    public static User getUser(int user_id) {
        User user = new User();
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE user_id = " + user_id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                user.setUser_id(set.getInt(1));
                user.setUser_name(set.getString(2));
                user.setPassword(set.getString(3));
                user.setLevel(set.getInt(4));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return user;
    }

    public static int edit(User user) {
        int result = 0;
        try {
            Connection conn = getConnection();
            if (user.getUser_id() == 0) {
                PreparedStatement statement = conn.prepareStatement("INSERT INTO users (user_name, password, level) values ( \"" + user.getUser_name()
                        + "\" ,  \"" + user.getPassword() + "\",  " + user.getLevel()
                        + " ) ");
                result = statement.executeUpdate();

            } else {
                PreparedStatement statement = conn.prepareStatement("UPDATE users set user_name = \"" + user.getUser_name()
                        + "\" , password = \"" + user.getPassword() + "\", level = " + user.getLevel()
                        + "WHERE user_id = " + user.getUser_id());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

    public static int delete(User user) {
        int result = 0;
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE users WHERE user_id = " + user.getUser_id());
            result = statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }
        public static int latestId() {
        int result = 0;
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT MAX(user_id) FROM users");
            ResultSet set = statement.executeQuery();
            if (set.next()){
                return set.getInt(1);
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }
}
