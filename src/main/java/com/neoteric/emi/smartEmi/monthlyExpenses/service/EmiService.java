package com.neoteric.emi.smartEmi.monthlyExpenses.service;

import com.neoteric.emi.smartEmi.monthlyExpenses.model.BillPeriod;
import com.neoteric.emi.smartEmi.monthlyExpenses.model.SmartEmi;
import com.neoteric.emi.smartEmi.monthlyExpenses.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmiService {

    BillPeriod billPeriod;

    public EmiService(BillPeriod billPeriod) {
        this.billPeriod = billPeriod;
    }

    public List<SmartEmi> emiSchedule(Transaction tran, int noofMon) {
        List<SmartEmi> smartEmiList = new ArrayList<>();

        Double totalAmount = tran.getTransAmount() ;
        Double amountPerMon = totalAmount / noofMon;
        Double remainingAmount = totalAmount;

        for (int i = 0; i < noofMon; i++) {
            SmartEmi smartEmi = new SmartEmi();
            smartEmi.setAmout(totalAmount);
            smartEmi.setAmountperMon(amountPerMon);

            remainingAmount -= amountPerMon;
            smartEmi.setAmountLeft(remainingAmount);
            if(smartEmi.getAmountLeft()==0){
                smartEmi.setAmountperMon(0.0);
                smartEmi.setAmout(0.0);
            }

            smartEmiList.add(smartEmi);
        }

        return smartEmiList;
    }


    public Double emiService(Transaction tran, int noofMon) {
        Double amountPerMon;
        if (tran.getTransDate().before(billPeriod.getFromDate()) || tran.getTransDate().after(billPeriod.getFromDate()) || tran.getTransDate().before(billPeriod.getToDate())) {

            amountPerMon = (tran.getTransAmount() + tran.getTransAmount() * 0.1) / noofMon;

        }
        else{
            amountPerMon = (tran.getTransAmount() + tran.getTransAmount() * 0.2) / noofMon;

        }

        return amountPerMon;
    }

}
