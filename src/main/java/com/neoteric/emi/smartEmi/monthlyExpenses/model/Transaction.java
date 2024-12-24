package com.neoteric.emi.smartEmi.monthlyExpenses.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int transId;

    @Column(nullable = false)
    private Date transDate;

    @Column(nullable = false)
    private Double transAmount;

    @Column(nullable = false)
    private String transType;

    @Column(nullable = false)
    private boolean isSmartEmi;


    @ManyToOne
    @JoinColumn(name = "credit_card_no", nullable = false)
    private CreditCard creditCard;

    public Transaction() {}


    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Double transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public boolean isSmartEmi() {
        return isSmartEmi;
    }

    public void setSmartEmi(boolean smartEmi) {
        isSmartEmi = smartEmi;
    }

}
