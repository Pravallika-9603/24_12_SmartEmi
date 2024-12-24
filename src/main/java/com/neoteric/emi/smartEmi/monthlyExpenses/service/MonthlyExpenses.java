package com.neoteric.emi.smartEmi.monthlyExpenses.service;

import com.neoteric.emi.smartEmi.monthlyExpenses.model.BillPeriod;
import com.neoteric.emi.smartEmi.monthlyExpenses.model.Transaction;

import java.util.List;

public class MonthlyExpenses {
    BillPeriod bi;
    public MonthlyExpenses(BillPeriod bi){
        this.bi=bi;
    }
    public Double monthlyExpenses(List<Transaction> transactionList){

        Double amount=0.0;

        for(Transaction transaction:transactionList){
            System.out.println(amount);
            if(transaction.isSmartEmi()){
                EmiService emiService=new EmiService(bi);
                Double am=emiService.emiService(transaction,5);
                amount+=am;
            }
            else {
                amount+=transaction.getTransAmount();
            }
        }

        return amount;
    }

}
