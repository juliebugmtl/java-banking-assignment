package com.juliemartin.accounts;

import com.juliemartin.bean.BankBean;
import java.math.BigDecimal;

/**
 * This is the super class for all account types
 *
 * @author Julie Martin
 * @version 0.1
 */
public abstract class BankAccount {

    // protected so that the subclasses can acces it directly
    protected BankBean money;

    /**
     * Initialize the account with a starting balance and an interest rate
     *
     * @param startingBalance
     * @param annualInterestRate
     */
    public BankAccount(BigDecimal startingBalance, BigDecimal annualInterestRate) {
        money = new BankBean(startingBalance, annualInterestRate);
    }

    /**
     *
     * @param deposit
     */
    public void makeDeposit(BigDecimal deposit) {
        // add to the current balance
        // add to the total for deposits
        // add to the counter/number of deposits
        
        BigDecimal temp1 = money.getCurrentBalance();
        BigDecimal temp2 = money.getTotalDeposits();
        int temp3 = money.getNumberOfDeposits();

        money.setCurrentBalance(temp1.add(deposit));
        money.setTotalDeposits(temp2.add(deposit));
        money.setNumberOfDeposits(temp3 + 1);
    }

    /**
     *
     * @param withdrawal
     * @return
     */
    public boolean withdrawal(BigDecimal withdrawal) {
        // subtract from the current balance
        // add to the total for withdrawals
        // add to the counter/number of deposits
        
        BigDecimal temp1 = money.getCurrentBalance();
        BigDecimal temp2 = money.getTotalWithdrawals();
        int temp3 = money.getNumberOfWithdrawals();

        money.setCurrentBalance(temp1.subtract(withdrawal));
        money.setTotalWithdrawals(temp2.add(withdrawal));
        money.setNumberOfWithdrawals(temp3 + 1);

        return true;
    }

    /**
     *
     */
    protected void calculateInterest() {
        // As part of a report calculate the interest to be added this month

        // Fetch annual interest rate and months in year for later monthly interest rate calculation
        BigDecimal ai = money.getAnnualInterestRate();
        BigDecimal months = new BigDecimal(12.0);
        
        // Calculate monthly interest rate and store as temp1        
        BigDecimal temp1 = ai.divide(months, 5, BigDecimal.ROUND_HALF_EVEN);
        
        // Calculate monthly interest
        BigDecimal temp2 = money.getCurrentBalance();
        BigDecimal temp3 = temp2.multiply(temp1);
        
        // Add monthly interest to balance
        BigDecimal temp4 = temp2.add(temp3);
              
        // Rounding
        BigDecimal temp5 = temp4.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        
        // Set new balance        
        money.setCurrentBalance(temp5);
        
    }

    /**
     *
     */
    public BankBean doMonthlyReport() {

        // calculate the interest
        calculateInterest();
        BankBean reportBean = new BankBean();
        reportBean.setCurrentBalance(money.getCurrentBalance());
        
        // copy every field
        // make a copy of the bean

        reportBean.setTotalDeposits(money.getTotalDeposits());
        reportBean.setNumberOfDeposits(money.getNumberOfDeposits());
        reportBean.setTotalWithdrawals(money.getTotalWithdrawals());
        reportBean.setNumberOfWithdrawals(money.getNumberOfWithdrawals());
        reportBean.setAnnualInterestRate(money.getAnnualInterestRate());
        reportBean.setServiceCharge(money.getServiceCharge());
   
        // reset
        
        BankBean BankBean = new BankBean();
        
        return reportBean;  // the copy

    }    

    /**
     *
     */
    void reset() {
        // reset the values at the end of the month for money
    }

}
