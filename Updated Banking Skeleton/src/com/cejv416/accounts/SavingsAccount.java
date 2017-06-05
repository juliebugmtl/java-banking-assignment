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
        // BigDecimal temp1 = money.getCurrentBalance();
        // BigDecimal temp2 = new BigDecimal(25.0);
        
        super.makeDeposit(deposit);

    }

    /**
     *
     * @param withdrawal
     * @return
     */
    @Override
    public boolean withdrawal(BigDecimal withdrawal) {
        
        // Prepare to check if account is active (over $25)
        BigDecimal temp1 = money.getCurrentBalance();
        BigDecimal temp2 = new BigDecimal(25.0);
        
        // Create active conditions where 0 is equal, 1 is first value is greater, -1 is second value is greater
        int active;
        active = temp1.compareTo(temp2);
        
        // If logic for account activity
        
        switch(active) {
            
            case 0 :
                super.withdrawal(withdrawal);
                break;
            case 1 :
                super.withdrawal(withdrawal);
                break;
            case -1: 
                System.out.println("Cannot withdraw, account is inactive.");
                break;
        }

        // Should go back to menu?   
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public BankBean doMonthlyReport() {
        
        // Service Charge for withdrawals above 4 specified
        BigDecimal sc = new BigDecimal(1.0);
                
        // Get the current balance
        BigDecimal temp1 = money.getCurrentBalance();
        
        // Get the number of withdrawals, check if over 4 and, if so, add fees
        int temp3 = money.getNumberOfWithdrawals();
        int temp4 = temp3 - 4;
        int temp5 = temp4 * 1;
        
        // Convert to BigDecimal because Math        
        BigDecimal temp6 = new BigDecimal(temp5);
               
        if (0 < temp4) {
            
            // Subtract withdrawal fees
            BigDecimal temp7 = temp1.subtract(temp6);
            
            // Rounding
            BigDecimal temp8 = temp7.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            
            // Set new balance
            money.setCurrentBalance(temp8);
            
        } else {
        
        // Rounding
        
        BigDecimal temp7 = new BigDecimal(temp3);
        BigDecimal temp8 = temp7.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        
        // Set new balance        
        money.setCurrentBalance(temp8);
        }
                
        BankBean reportBean = super.doMonthlyReport();
        return reportBean;

    }
    
        public String toString() {
        return money.toString();
    }
    
}
