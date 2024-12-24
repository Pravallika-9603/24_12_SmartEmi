package com.neoteric.emi.smartEmi.monthlyExpenses.model;

import jakarta.persistence.*;

@Entity
public class SmartEmi {

    @Column
    private Double amout;

    @Column
    private int noofmon;

    @Column
    private Double intrest;

    @Column
    private Double amountperMon;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private Double amountLeft;

    public Double getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(Double amountLeft) {
        this.amountLeft = amountLeft;
    }

    public Double getAmout() {
        return amout;
    }

    public void setAmout(Double amout) {
        this.amout = amout;
    }

    public int getNoofmon() {
        return noofmon;
    }

    public void setNoofmon(int noofmon) {
        this.noofmon = noofmon;
    }

    public Double getIntrest() {
        return intrest;
    }

    public void setIntrest(Double intrest) {
        this.intrest = intrest;
    }

    public Double getAmountperMon() {
        return amountperMon;
    }

    public void setAmountperMon(Double amountperMon) {
        this.amountperMon = amountperMon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
