package com.cejv416.app;

import com.cejv416.accounts.CheckingAccount;
import com.cejv416.accounts.SavingsAccount;
import com.cejv416.business.TheBank;
import com.cejv416.presentation.BankUserInterface;
import java.math.BigDecimal;

/**
 * The objects used by the program are created here and then the user interface
 * takes over running the program
 *
 * @author Julie Martin
 * @version 0.1
 */
public class MainApp {

    private final SavingsAccount savings;
    private final CheckingAccount checking;
    private final TheBank theBank;
    private final BankUserInterface userInterface;

    /**
     * Default constructor that creates the objects
     */
    public MainApp() {
        savings = new SavingsAccount(new BigDecimal("50.0"), new BigDecimal(".05"));
        checking = new CheckingAccount(new BigDecimal(100.0), new BigDecimal(.01));
        theBank = new TheBank(savings, checking);
        userInterface = new BankUserInterface(theBank);
    }

    /**
     * Control is given to the user interface
     */
    public void perform() {
        userInterface.mainMenu();
    }

    /**
     * This where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.perform();
        System.exit(0);
    }
}
