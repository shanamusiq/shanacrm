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
public class Deal implements Serializable {

    private String customer_name;
    private String customer_phone;
    private String address;
    private String state;
    private String postal_code;
    private int deal_id;
    private String property_address;
    private String property_state;
    private String property_postal_code;
    private String sales_stage;
    private int amount;
    private String close_date;
    private String comment;

    public String getSales_stage() {
        return sales_stage;
    }

    public void setSales_stage(String sales_stage) {
        this.sales_stage = sales_stage;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
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

    public String getZip_code() {
        return postal_code;
    }

    public void setZip_code(String zip_code) {
        this.postal_code = zip_code;
    }

    public String getProperty_postal_code() {
        return property_postal_code;
    }

    public void setProperty_zip_code(String property_postal_code) {
        this.property_postal_code = property_postal_code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getClose_date() {
        return close_date;
    }

    public void setClose_date(String close_date) {
        this.close_date = close_date;
    }

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public String getProperty_address() {
        return property_address;
    }

    public void setProperty_address(String property_address) {
        this.property_address = property_address;
    }

    public String getProperty_state() {
        return property_state;
    }

    public void setProperty_state(String property_state) {
        this.property_state = property_state;
    }

}
