package com.juliemartin.menus;

import java.util.Scanner;

/**
 * This class creates menus and accepts the user's choice
 *
 * @author Your Name
 * @version 0.1
 */
public class Menus {

    private final Scanner sc;

    /**
     * Default Constructor
     */
    public Menus() {
        sc = new Scanner(System.in);
    }

    /**
     * The display method for the main menu
     */
    public void displayMainMenuText() {
        System.out.println("The Bank\n");
        System.out.println("A. Savings");
        System.out.println("B. Checking");
        System.out.println("C. Exit");
    }

    /**
     * The display method for the account menu
     *
     * @param title The name of the account
     */
    public void displayAccountMenuText(String title) {
        System.out.println(title + '\n');
        System.out.println("A. Deposit");
        System.out.println("B. Withdraw");
        System.out.println("C. Report");
        System.out.println("D. Return to Main Menu");
    }

    /**
     * Menu Display Routine The maximum size is up to the letter 'Y'
     *
     * @param limit Menus start with 'A' up to the limit character
     * @return The user's choice
     */
    public char doMenu(char limit) {

        // Create the regular expression string such as [a-yA-Y]
        String limitStr = "" + limit;
        String lcLimitStr = limitStr.toLowerCase();
        String regEx = "[a-" + lcLimitStr + "A-" + limitStr + "]";

        char choice;

        do {
            System.out.println("Enter your choice: ");
            if (sc.hasNext(regEx)) {
                choice = sc.next().toUpperCase().charAt(0);
            } else {
                choice = 'z';
            }
            if (choice == 'z') {
                System.out.println("Invalid. Please enter A to " + limit + ": ");
            }
            sc.nextLine();
        } while (choice == 'z');

        return choice;
    }
}
