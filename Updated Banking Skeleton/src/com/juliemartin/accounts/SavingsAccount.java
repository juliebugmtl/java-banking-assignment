package com.juliemartin.accounts;

import com.juliemartin.bean.BankBean;
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
//    @Override
//    public void makeDeposit(BigDecimal deposit) {
//        
//        super.makeDeposit(deposit);
//
//    }

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
        
         // Check if withdrawal will overdraw account
         BigDecimal temp3 = temp1.subtract(withdrawal);
                 
         if (temp3.compareTo(BigDecimal.ZERO) < 0 ) {
             
             System.out.println("Cannot withdraw, your account would be overdrawn.");
             
         } else {
        
        
        // Create active conditions where 0 is equal, 1 is first value is greater, -1 is second value is greater
        int active;
        active = temp1.compareTo(temp2);
        
        // If logic for account activity
        
        switch(active) {
            
            case 0 :
                super.withdrawal(withdrawal); // account is active, proceed with withdrawal
                break;
            case 1 :
                super.withdrawal(withdrawal); // account is active, proceed with withdrawal
                break;
            case -1: 
                System.out.println("Cannot withdraw, account is inactive."); // account is inactive, stop transaction
                break;
        }

            return false;
        }
    return true;
    }

    /**
     *
     * @return
     */
    @Override
    public BankBean doMonthlyReport() {
        
        // Get the current balance
        BigDecimal temp1 = money.getCurrentBalance();
        
        // Get the number of withdrawals
        int temp3 = money.getNumberOfWithdrawals();
        int temp4 = temp3 - 4;
                
        // Convert to BigDecimal because Math        
        BigDecimal temp5 = new BigDecimal(temp4);
        
        // Logic to see if withdrawal fees have already been applied
        
        boolean addedFees = false;
            
            do { 
            
                boolean feesAdded = false;

                if (!addedFees) {
                
                feesAdded = true;
            }
            
            do {

                if (0 < temp4 && !feesAdded) {
                    // Subtract withdrawal fees
                    BigDecimal temp6 = temp1.subtract(temp5);

                    // Round and set service charge
                    BigDecimal temp7 = temp5.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    money.setServiceCharge(temp7);

                    // Rounding balance
                    BigDecimal temp8 = temp6.setScale(2, BigDecimal.ROUND_HALF_EVEN);

                    // Set new balance
                    money.setCurrentBalance(temp8);

                    
                    System.out.println("Status of feesAdded? " + feesAdded);

                 } else {

                    // Rounding
                    BigDecimal temp8 = temp1.setScale(2, BigDecimal.ROUND_HALF_EVEN);

                    // Set new balance        
                    money.setCurrentBalance(temp8);

                    System.out.println("Status of feesAdded? " + feesAdded);
                }
            } while(feesAdded = false);
                
                
        
        
        // Withdrawal fee loop
//            for (int fees = 0; fees <= 2; fees++)    {
//        
//                if (0 < temp4) { // THIS keeps repeating because the value is always true if it was true once. REWORK LOGIC.
//
//                    // Subtract withdrawal fees
//                    BigDecimal temp6 = temp1.subtract(temp5);
//
//                    // Round and set service charge
//                    BigDecimal temp7 = temp5.setScale(2, BigDecimal.ROUND_HALF_EVEN);
//                    money.setServiceCharge(temp7);
//
//                    // Rounding balance
//                    BigDecimal temp8 = temp6.setScale(2, BigDecimal.ROUND_HALF_EVEN);
//
//                    // Set new balance
//                    money.setCurrentBalance(temp8);
//                    
//                    System.out.println("FEES IN IF: " + fees);
//                                
//                    break;
//
//                } else {
//
//                // Rounding
//                BigDecimal temp8 = temp1.setScale(2, BigDecimal.ROUND_HALF_EVEN);
//
//                // Set new balance        
//                money.setCurrentBalance(temp8);
//
//                System.out.println("FEES IN ELSE: " + fees);
//            
//                break;
//                }
//
//            }
        
         BankBean reportBean = new BankBean();
         reportBean.setStartingBalance(money.getStartingBalance());
         reportBean.setCurrentBalance(money.getCurrentBalance());
         reportBean.setTotalDeposits(money.getTotalDeposits());
         reportBean.setNumberOfDeposits(money.getNumberOfDeposits());
         reportBean.setTotalWithdrawals(money.getTotalWithdrawals());
         reportBean.setNumberOfWithdrawals(money.getNumberOfWithdrawals());
         reportBean.setAnnualInterestRate(money.getAnnualInterestRate());
         reportBean.setServiceCharge(money.getServiceCharge());
        
        return reportBean;

    }
    
        public String toString() {
        return money.toString();
    }
    
}
