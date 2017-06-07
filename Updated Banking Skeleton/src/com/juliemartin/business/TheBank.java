package com.juliemartin.business;

import com.juliemartin.accounts.CheckingAccount;
import com.juliemartin.accounts.SavingsAccount;
import com.juliemartin.bean.BankBean;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * This class simulates a private bank that has just two accounts, all actions
 * must pass through this class
 *
 * @author Julie Martin
 * @version 0.1
 */
public class TheBank {

    private final SavingsAccount savings;
    private final CheckingAccount checking;

    /**
     * Receives the account objects and carries out the necessary operations on
     * the accounts
     *
     * @param savings
     * @param checking
     */
    public TheBank(SavingsAccount savings, CheckingAccount checking) {
        super();
        this.savings = savings;
        this.checking = checking;
    }

    /**
     *
     */
    public void doSavingsDeposit() {

        // ask for the value
        // ask the user for input
        
        Scanner sc = new Scanner(System.in);
        
        double in = -1.0;
            do {
                System.out.print("Please enter amount of deposit: $");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    in = sc.nextDouble();
                }
                if (in == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (in == -1.0);
        
            BigDecimal temp1 = new BigDecimal(in);
            BigDecimal deposit = temp1.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            System.out.println("input " + deposit);
        
        savings.makeDeposit(deposit);
    }

    /**
     *
     */
    public void doSavingsWithdrawal() {
        
        // ask for the value
        // ask the user for input
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("doSavingsWithdrawal");
        
        double in = -1.0;
            do {
                System.out.print("Please enter amount of withdrawal: ");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    in = sc.nextDouble();
                }
                if (in == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (in == -1.0);
        
            BigDecimal temp1 = new BigDecimal(in);
            BigDecimal withdrawal = temp1.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            System.out.println("input " + withdrawal);
        
        savings.withdrawal(withdrawal);
        
    }

    /**
     *
     * @return
     */
    public BankBean doSavingsReport() {
        // Monthly Report
        
        return savings.doMonthlyReport();
    }

    /**
     *
     */
    public void doCheckingDeposit() {
        System.out.println("doCheckingDeposit");
    }

    /**
     *
     */
    public void doCheckingWithdrawal() {
        System.out.println("doCheckingWithdrawal");
    }

    /**
     *
     * @return
     */
    public BankBean doCheckingReport() {
        // Monthly Report
        return checking.doMonthlyReport();

    }
}
