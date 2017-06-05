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
//        
//        if ( active == 0 ) {
//            
//            super.withdrawal(withdrawal);
//        
//        }
//            
//      else if ( active == 1 ){
//            
//            super.withdrawal(withdrawal);
//        
//        }
//      
//      else if ( active == -1 )
//         System.out.println("Cannot withdraw, account is inactive.");
//        // Should go back to menu?   
        return false;
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
    
        public String toString() {
        return money.toString();
    }
    
}
