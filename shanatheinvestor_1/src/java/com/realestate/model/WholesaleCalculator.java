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
public class WholesaleCalculator implements Serializable {
    private double arv;
    private double net_profit;
    private double repair_cost;
    private double assignment_fee;
    private double max_offer;

    public double getArv() {
        return arv;
    }

    public void setArv(double arv) {
        this.arv = arv;
    }

    public double getNet_profit() {
        return net_profit;
    }

    public void setNet_profit(double net_profit) {
        this.net_profit = net_profit;
    }

    public double getRepair_cost() {
        return repair_cost;
    }

    public void setRepair_cost(double repair_cost) {
        this.repair_cost = repair_cost;
    }

    public double getAssignment_fee() {
        return assignment_fee;
    }

    public void setAssignment_fee(double assignment_fee) {
        this.assignment_fee = assignment_fee;
    }

    public double getMax_offer() {
        return max_offer;
    }

    public void setMax_offer(double max_offer) {
        this.max_offer = max_offer;
    }
    
}
