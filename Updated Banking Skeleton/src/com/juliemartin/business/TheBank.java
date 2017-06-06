package com.juliemartin.business;

import com.juliemartin.accounts.CheckingAccount;
import com.juliemartin.accounts.SavingsAccount;
import com.juliemartin.bean.BankBean;
import java.math.BigDecimal;

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
        BigDecimal input = null;
        //System.out.println("doSavingsDeposit");
        // ask for the value
        // ask the user for input
        savings.makeDeposit(input);
    }

    /**
     *
     */
    public void doSavingsWithdrawal() {
        System.out.println("doSavingsWithdrawal");
    }

    /**
     *
     * @return
     */
    public BankBean doSavingsReport() {
        System.out.println("doSavingsReport");
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
        return checking.doMonthlyReport();

    }
}
