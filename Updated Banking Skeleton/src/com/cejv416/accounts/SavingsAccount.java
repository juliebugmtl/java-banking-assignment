package com.cejv416.accounts;

import com.cejv416.bean.BankBean;
import java.math.BigDecimal;

/**
 *
 * @author Julie Martin
 * @version 0.1
 */
public class SavingsAccount extends BankAccount {

    /**
     * Pass the initial values for starting balance and interest rate to the
     * super class
     *
     * @param startingBalance
     * @param annualInterestRate
     */
    public SavingsAccount(BigDecimal startingBalance, BigDecimal annualInterestRate) {
        super(startingBalance, annualInterestRate);
    }

    /**
     *
     * @param deposit
     */
    @Override
    public void makeDeposit(BigDecimal deposit) {
        
        // Prepare to check if account is active (over $25)
        BigDecimal temp1 = money.getCurrentBalance();
        BigDecimal temp2 = new BigDecimal(25.0);
        
        // add to the current balance
        
        BigDecimal temp3 = temp1.add(deposit);
        money.setCurrentBalance(temp3);

        // add to the total for deposits
        BigDecimal temp4 = money.getTotalDeposits();
        BigDecimal temp5 = temp4.add(deposit);
        money.setTotalDeposits(temp5);

        // add to the counter/number of deposits
        int temp6 = money.getNumberOfDeposits();
        money.setNumberOfDeposits(temp6 + 1);
        
    }

    /**
     *
     * @param withdrawal
     * @return
     */
    @Override
    public boolean withdrawal(BigDecimal withdrawal) {
        // do savings stuff
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public BankBean doMonthlyReport() {
        // do savings stuff

        BankBean reportBean = super.doMonthlyReport();
        return reportBean;

    }
}
