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
        // do savings stuff
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
