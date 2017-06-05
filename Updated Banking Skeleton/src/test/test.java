package test;

import com.cejv416.accounts.CheckingAccount;
import com.cejv416.accounts.SavingsAccount;
import java.math.BigDecimal;

/**
 *
 * @author Julie Martin
 */
public class test {
    
    private void testCheckingDeposit() {
        
        CheckingAccount ca = new CheckingAccount(new BigDecimal("100.0"), new BigDecimal ("0.05"));
        ca.makeDeposit(new BigDecimal("10.0"));
        System.out.println(ca.toString());
        
    }
    
    private void testCheckingWithdraw() {
        
        CheckingAccount ca = new CheckingAccount(new BigDecimal("100.0"), new BigDecimal ("0.05"));
        ca.withdrawal(new BigDecimal("25.0"));
        System.out.println(ca.toString());
        
    }

    private void testCheckingOverdrawn() {
        
        CheckingAccount ca = new CheckingAccount(new BigDecimal("10.0"), new BigDecimal ("0.05"));
        ca.withdrawal(new BigDecimal("55.0"));
        System.out.println(ca.toString());
        
    }

    private void testLotsOfChecking() {
        
        CheckingAccount ca = new CheckingAccount(new BigDecimal("100.0"), new BigDecimal ("0.05"));
        ca.withdrawal(new BigDecimal("15.0"));
        ca.withdrawal(new BigDecimal("15.0"));
        ca.withdrawal(new BigDecimal("15.0"));
        ca.withdrawal(new BigDecimal("15.0"));
        ca.withdrawal(new BigDecimal("15.0"));
        ca.doMonthlyReport();
        System.out.println(ca.toString());
        
    }
    
        private void testSavingsDeposit() {
        
        SavingsAccount sa = new SavingsAccount(new BigDecimal("100.0"), new BigDecimal ("0.05"));
        sa.makeDeposit(new BigDecimal("10.0"));
        sa.doMonthlyReport();
        System.out.println(sa.toString());
        
    }
    
    
    public void perform() {
        
        //testCheckingDeposit();
        //testCheckingWithdraw();
        //testCheckingOverdrawn();
        //testLotsOfChecking();
        
        testSavingsDeposit();
        
    }
    
    public static void main(String[] args) {
        test te = new test();
        te.perform();
        System.exit(0);
    }
    
}
