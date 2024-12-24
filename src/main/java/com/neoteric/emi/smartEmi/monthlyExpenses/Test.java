package com.neoteric.emi.smartEmi.monthlyExpenses;

import com.neoteric.emi.smartEmi.monthlyExpenses.model.BillPeriod;
import com.neoteric.emi.smartEmi.monthlyExpenses.model.CreditCard;
import com.neoteric.emi.smartEmi.monthlyExpenses.model.SmartEmi;
import com.neoteric.emi.smartEmi.monthlyExpenses.model.Transaction;
import com.neoteric.emi.smartEmi.monthlyExpenses.service.EmiService;
import com.neoteric.emi.smartEmi.monthlyExpenses.service.MonthlyExpenses;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateDemo");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Transaction> transactionList=new ArrayList<>();

        CreditCard creditCard=new CreditCard();
        creditCard.setCardNo("74659");
        creditCard.setCardlimit(50000.0);

        Transaction transaction=new Transaction();
        transaction.setCreditCard(creditCard);
        transaction.setTransType("debit");
        transaction.setTransAmount(100.0);
        transaction.setSmartEmi(false);
        transaction.setTransDate(new Date());

        Transaction transaction1=new Transaction();
        transaction1.setCreditCard(creditCard);
        transaction1.setTransType("debit");
        transaction1.setTransAmount(100.0);
        transaction1.setSmartEmi(false);

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        transaction1.setTransDate(calendar.getTime());


        Transaction transaction2=new Transaction();
        transaction2.setCreditCard(creditCard);
        transaction2.setTransType("debit");
        transaction2.setTransAmount(100.0);
        transaction2.setSmartEmi(false);
        Date currentDate1 = new Date();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(currentDate1);
        calendar1.add(Calendar.DAY_OF_MONTH, 2);
        transaction2.setTransDate(calendar1.getTime());

        Transaction transaction3=new Transaction();
        transaction3.setCreditCard(creditCard);
        transaction3.setTransType("debit");
        transaction3.setTransAmount(100.0);
        transaction3.setSmartEmi(false);

        Date currentDate2 = new Date();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(currentDate2);
        calendar2.add(Calendar.DAY_OF_MONTH, 3);
        transaction3.setTransDate(calendar2.getTime());

        Transaction transaction4=new Transaction();
        transaction4.setCreditCard(creditCard);
        transaction4.setTransType("debit");
        transaction4.setTransAmount(1000.0);
        transaction4.setSmartEmi(true);
        Date currentDate3 = new Date();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(currentDate3);
        calendar3.add(Calendar.DAY_OF_MONTH, 4);
        transaction4.setTransDate(calendar3.getTime());

        transactionList.add(transaction);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);

        creditCard.setTransactionList(transactionList);

//            em.persist(creditCard);
//            em.persist(transaction);
//            em.persist(transaction1);
//            em.persist(transaction2);
//            em.persist(transaction3);
//            em.persist(transaction4);

        BillPeriod billPeriod=new BillPeriod();
        billPeriod.setFromDate(new Date());

        Date date=new Date();
        Calendar cal= Calendar.getInstance();
        cal.setTime(date);
        cal.add(cal.DAY_OF_MONTH, 3);

        billPeriod.setToDate(cal.getTime());



        System.out.println(creditCard.getTransactionList().size());




       EmiService emiService=new EmiService(billPeriod);
       List<SmartEmi> emis=emiService.emiSchedule(transaction4,5);
       for (SmartEmi emi:emis){
           em.persist(emi);
       }

        MonthlyExpenses monthlyExpenses=new MonthlyExpenses(billPeriod);
        System.out.println(monthlyExpenses.monthlyExpenses(transactionList));

        em.getTransaction().commit();
    }

}
