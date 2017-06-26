package com.juliemartin.accounts;

import com.juliemartin.bean.BankBean;
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
        BigDecimal penalty = (new BigDecimal("15.0"));

        // Check if there are sufficient funds
        BigDecimal temp1 = money.getCurrentBalance();
        BigDecimal temp2 = withdrawal;
        BigDecimal temp3 = temp1.subtract(temp2);
        
        if (temp3.compareTo(BigDecimal.ZERO) < 0){
            
        // If NSF, halt transaction, add penalty charge    
        money.setCurrentBalance(temp1.subtract(penalty));
        money.setPenaltyCharge(penalty);
        System.out.println("Cannot withdraw, insufficient funds.");
                    
        } else {
        
        // subtract from the current balance
        money.setCurrentBalance(temp3);
        
        // add to the total for withdrawals
        BigDecimal temp4 = money.getTotalWithdrawals();
        money.setTotalWithdrawals(temp4.add(withdrawal));
        
        // add to the counter/number of deposits
        int temp5 = money.getNumberOfWithdrawals();

        //money.setCurrentBalance(temp1.subtract(withdrawal));
        money.setNumberOfWithdrawals(temp5 + 1);
        }
        return true;
    }

    /**
     *
     */
    @Override
    public BankBean doMonthlyReport() {

        // Service Charge and Withdrawal Fees specified
        BigDecimal sc = new BigDecimal(5.0);
        BigDecimal wf = new BigDecimal(0.1);
        
        // Get the current balance
        BigDecimal temp1 = money.getCurrentBalance();
        
        // Get the number of withdrawals, convert to BigDecimal, add withdrawal fees
        int temp3 = money.getNumberOfWithdrawals();
        BigDecimal temp4 = new BigDecimal(temp3);
        BigDecimal temp5 = wf.multiply(temp4);
        
        // Subtract service charge
        BigDecimal temp6 = temp1.subtract(sc);
        System.out.println("Monthly service charge: " + sc.setScale(2, BigDecimal.ROUND_HALF_EVEN));
        
        // Subtract withdrawal fees
        BigDecimal temp7 = temp6.subtract(temp5);
        System.out.println("Withdrawal fees: " + temp5.setScale(2, BigDecimal.ROUND_HALF_EVEN));
        
        // Rounding
        BigDecimal temp8 = temp7.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        
        // Set new balance        
        money.setCurrentBalance(temp8);
        //super.calculateInterest();
        BankBean reportBean = super.doMonthlyReport();
        return reportBean;

    }
    
    public String toString() {
        return money.toString();
    }
    
}
