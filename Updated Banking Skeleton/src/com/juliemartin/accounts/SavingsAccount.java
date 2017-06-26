package com.juliemartin.accounts;

import com.juliemartin.bean.BankBean;
import java.math.BigDecimal;

/**
 *
 * @author Julie Martin
 * @version 0.1
 */
public class SavingsAccount extends BankAccount {

    // Protection against additional service fees
    boolean addedFees = false;
    
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
        
        // Check for account active status
        // Prepare to check if account is active (over $25)
        BigDecimal temp1 = money.getCurrentBalance();
        BigDecimal temp2 = new BigDecimal(25.0);
        
        // Create active conditions where 0 is equal, 1 is first value is greater, -1 is second value is greater
        int active;
        active = temp1.compareTo(temp2);
        
        BigDecimal temp3 = temp1.add(temp2);
        
        int becomesActive = (temp3.compareTo(temp2)); 

        // Add deposit to the current balance
        // Add deposit to the total for deposits
        // Add to the counter/number of deposits
        
        BigDecimal temp4 = money.getCurrentBalance();
        BigDecimal temp5 = money.getTotalDeposits();
        int temp6 = money.getNumberOfDeposits();
        
        // If logic for account activity
        
        switch(active) {
            
            case 0 :
                money.setCurrentBalance(temp4.add(deposit));
                money.setTotalDeposits(temp5.add(deposit));
                money.setNumberOfDeposits(temp6 + 1);
                break;
            case 1 :
                money.setCurrentBalance(temp4.add(deposit));
                money.setTotalDeposits(temp5.add(deposit));
                money.setNumberOfDeposits(temp6 + 1);
                break;
            case -1: 
                if (becomesActive == 0) {
                    
                    money.setCurrentBalance(temp4.add(deposit));
                    money.setTotalDeposits(temp5.add(deposit));
                    money.setNumberOfDeposits(temp6 + 1);
                    break;

                } else if (becomesActive == 1) {
                    
                    money.setCurrentBalance(temp4.add(deposit));
                    money.setTotalDeposits(temp5.add(deposit));
                    money.setNumberOfDeposits(temp6 + 1);
                    break;
                    
                } else {
                    money.setCurrentBalance(temp4.add(deposit));
                    money.setTotalDeposits(temp5.add(deposit));
                    money.setNumberOfDeposits(temp6 + 1);
                    money.setStatus(true);
                    break;
                }
                
        }
      
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
                money.setStatus(false);
                break;
            case 1 :
                super.withdrawal(withdrawal); // account is active, proceed with withdrawal
                money.setStatus(false);
                break;
            case -1: 
                System.out.println("Cannot withdraw, account is inactive."); // account is inactive, stop transaction
                money.setStatus(true);
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
                
                if (0 < temp4 && !addedFees) { // Fixed repeating logic by defining addedFees as false earlier on and marking as true within

                    // Subtract withdrawal fees
                    BigDecimal temp6 = temp1.subtract(temp5);

                    // Round and set service charge
                    BigDecimal temp7 = temp5.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    money.setServiceCharge(temp7);

                    // Rounding balance
                    BigDecimal temp8 = temp6.setScale(2, BigDecimal.ROUND_HALF_EVEN);

                    // Set new balance
                    money.setCurrentBalance(temp8);
                    
                    addedFees = true;
                                
                } else {

                    // Rounding
                    BigDecimal temp8 = temp1.setScale(2, BigDecimal.ROUND_HALF_EVEN);

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
