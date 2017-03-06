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
public class Client implements Serializable {
    private String first_name;
    private String last_name;
    private String phone;
    private String address;
    private String state;
    private String postal_code;
    private String credit_card;
    private int client_id;
    private String email;
    private int credit_card_pin;
    private String password;
    private int user_id;
    private int credit_card_exp;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCredit_card_pin() {
        return credit_card_pin;
    }

    public void setCredit_card_pin(int credit_card_pin) {
        this.credit_card_pin = credit_card_pin;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCredit_card_exp() {
        return credit_card_exp;
    }

    public void setCredit_card_exp(int credit_card_exp) {
        this.credit_card_exp = credit_card_exp;
    }

    public int getUser_role() {
        return user_id;
    }

    public void setUser_role(int user_role) {
        this.user_id = user_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public int getProspect_id() {
        return client_id;
    }

    public void setProspect_id(int prospect_id) {
        this.client_id = prospect_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
