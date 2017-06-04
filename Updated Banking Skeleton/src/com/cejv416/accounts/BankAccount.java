package com.cejv416.accounts;

import com.cejv416.bean.BankBean;
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

        money.setCurrentBalance(temp1.add(withdrawal));
        money.setTotalWithdrawals(temp2.add(withdrawal));
        money.setNumberOfWithdrawals(temp3 + 1);

        return true;
    }

    /**
     *
     */
    private void calculateInterest() {
        // As part of a report calculate the interest to be added this month

    }

    /**
     *
     */
    public BankBean doMonthlyReport() {
        // do stuff
        // calculate the interest

        BankBean reportBean = new BankBean();
        reportBean.setCurrentBalance(money.getCurrentBalance());
        // copy every field

        // make a copy of the bean
        // reset
        return reportBean;  // the copy

    }

    /**
     *
     */
    void reset() {
        // reset the values at the end of the month for money
    }

}
