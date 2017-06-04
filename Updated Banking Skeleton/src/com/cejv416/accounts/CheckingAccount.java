package com.cejv416.accounts;

import com.cejv416.bean.BankBean;
import java.math.BigDecimal;

/**
 * The Checking Account class
 *
 * @author Julie Martin
 * @version 0.1
 */
public class CheckingAccount extends BankAccount {

    /**
     * Pass the initial values for starting balance and interest rate to the
     * super class
     *
     * @param startingBalance
     * @param annualInterestRate
     */
    public CheckingAccount(BigDecimal startingBalance, BigDecimal annualInterestRate) {
        super(startingBalance, annualInterestRate);
    }

    /**
     *
     * @param withdrawal
     * @return
     */
    
    @Override
    public boolean withdrawal(BigDecimal withdrawal) {
        
        // Set penalty fee
        BigDecimal penalty = (new BigDecimal("25.0"));

        // do checking stuff
        
        BigDecimal temp1 = money.getCurrentBalance();
        BigDecimal temp2 = withdrawal;
        BigDecimal temp3 = temp1.subtract(temp2);
        
        if (temp3.compareTo(BigDecimal.ZERO) < 0){
            
        money.setCurrentBalance(temp1.subtract(penalty));    
            
        } 
        
        // subtract from the current balance
        // add to the total for withdrawals
        // add to the counter/number of deposits
        
        
        BigDecimal temp4 = money.getTotalWithdrawals();
        int temp5 = money.getNumberOfWithdrawals();

        money.setCurrentBalance(temp1.subtract(withdrawal));
        money.setTotalWithdrawals(temp4.add(withdrawal));
        money.setNumberOfWithdrawals(temp5 + 1);
        
        
        return true;
    }

    /**
     *
     */
    @Override
    public BankBean doMonthlyReport() {
        // do checking stuff

        BankBean reportBean = super.doMonthlyReport();
        return reportBean;

    }
    
    public String toString() {
        return money.toString();
    }
    
}
