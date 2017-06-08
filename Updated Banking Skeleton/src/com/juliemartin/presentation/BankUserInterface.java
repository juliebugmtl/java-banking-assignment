package com.juliemartin.presentation;

import com.juliemartin.bean.BankBean;
import com.juliemartin.business.TheBank;
import com.juliemartin.menus.Menus;

/**
 * This class simulates a private bank that has just two accounts
 *
 * @author Julie Martin
 * @version 0.1
 */
public class BankUserInterface {

    private final Menus menus;

    private final String savingsTitle;
    private final String checkingTitle;

    private final TheBank theBank;

    /**
     * Constructor to initialize TheBank and Menus objects
     *
     * @param theBank
     */
    public BankUserInterface(TheBank theBank) {
        savingsTitle = "Savings Account";
        checkingTitle = "Checking Account";

        this.theBank = theBank;
        menus = new Menus();
    }

    /**
     * Display the main bank menu
     */
    public void mainMenu() {
        char choice;
        do {
            menus.displayMainMenuText();
            choice = menus.doMenu('C');
            switch (choice) {
                case 'A':
                    savingsMenu();
                    break;
                case 'B':
                    checkingMenu();
                    break;
            }

        } while (choice != 'C');
    }

    /**
     * Display the savings menu
     */
    private void savingsMenu() {

        char choice;
        do {
            menus.displayAccountMenuText(savingsTitle);
            choice = menus.doMenu('D');
            switch (choice) {
                case 'A':
                    theBank.doSavingsDeposit();
                    break;
                case 'B':
                    theBank.doSavingsWithdrawal();
                    break;
                case 'C':
                    // doSavingsReport returns a copy of the AccountBean after
                    // calculations but before reset
                    presentReport(theBank.doSavingsReport());
                    break;
            }

        } while (choice != 'D');
    }

    /**
     * Display the checking menu
     */
    private void checkingMenu() {
        char choice;

        do {
            menus.displayAccountMenuText(checkingTitle);
            choice = menus.doMenu('D');
            switch (choice) {
                case 'A':
                    theBank.doCheckingDeposit();
                    break;
                case 'B':
                    theBank.doCheckingWithdrawal();
                    break;
                case 'C':
                    // doCheckingReport returns a copy of the AccountBean after
                    // calculations but before reset
                    presentReport(theBank.doCheckingReport());
                    break;
            }

        } while (choice != 'D');
    }

    /**
     * Create a report The BankAccount object is a copy of the main BankAccount
     * bean after the calculations are preformed at the end of the month but
     * before the bean is reset for the next month
     *
     * @param account a copy of the AccountBean
     */
    public void presentReport(BankBean money) {
        System.out.println(money.toString());

    }
}
