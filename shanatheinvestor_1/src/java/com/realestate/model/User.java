/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.model;

import java.io.Serializable;

/**
 *
 * @author Shana
 */
public class User implements Serializable {
    public static final int ADMINROLE = 1;
    public static final int USERROLE = 2;
    public static final int PROSPECTROLE = 3;
    public static final int CLIENTROLE = 4;
    private int user_id;
    private String user_name;
    private String password;
    private int level;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
   
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
