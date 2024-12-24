package com.neoteric.emi.smartEmi.monthlyExpenses.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "creditcard")
public class CreditCard {

    @Id
    @Column(name = "cardno", nullable = false)
    private String cardNo; // Assuming card numbers are assigned externally

    @Column(nullable = false)
    private Double cardlimit;


    @OneToMany(mappedBy = "creditCard")
    private List<Transaction> transactionList;


    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Double getCardlimit() {
        return cardlimit;
    }

    public void setCardlimit(Double cardlimit) {
        this.cardlimit = cardlimit;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

}
