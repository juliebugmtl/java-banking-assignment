package test;

import com.juliemartin.accounts.CheckingAccount;
import com.juliemartin.accounts.SavingsAccount;
import com.juliemartin.accounts.BankAccount;
import java.math.BigDecimal;

/**
 *
 * @author Julie Martin
 */
public class test {
    
    private void testCheckingDeposit() {
        
        CheckingAccount ca = new CheckingAccount(new BigDecimal("100.0"), new BigDecimal ("0.05"));
        ca.makeDeposit(new BigDecimal("10.0"));
        ca.doMonthlyReport();
        System.out.println(ca.toString());
        
    }
    
    private void testCheckingWithdraw() {
        
        CheckingAccount ca = new CheckingAccount(new BigDecimal("100.0"), new BigDecimal ("0.05"));
        ca.withdrawal(new BigDecimal("20.0"));
        ca.doMonthlyReport();
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
        
        SavingsAccount sa = new SavingsAccount(new BigDecimal("50.0"), new BigDecimal ("0.05"));
        sa.makeDeposit(new BigDecimal("10.0"));
        System.out.println(sa.toString());
        
    }

    private void testSavingsWithdrawInactive() {
        
        SavingsAccount sa = new SavingsAccount(new BigDecimal("10.0"), new BigDecimal ("0.05"));
        sa.withdrawal(new BigDecimal("5.0"));
        System.out.println(sa.toString());
        
    }
    
    private void testSavingsWithdraw() {
        
        SavingsAccount sa = new SavingsAccount(new BigDecimal("100.0"), new BigDecimal ("0.05"));
        sa.withdrawal(new BigDecimal("10.0"));
        sa.withdrawal(new BigDecimal("10.0"));
        sa.withdrawal(new BigDecimal("10.0"));
        sa.withdrawal(new BigDecimal("10.0"));
        sa.withdrawal(new BigDecimal("10.0"));
        sa.withdrawal(new BigDecimal("10.0"));
        sa.doMonthlyReport();
        System.out.println(sa.toString());
        
    }

   public void perform() {
        
        //testCheckingDeposit();
        //testCheckingWithdraw();
        //testCheckingOverdrawn();
        //testLotsOfChecking();
        testSavingsDeposit();
        //testSavingsWithdrawInactive();
        //testSavingsWithdraw();
             
    }
    
    public static void main(String[] args) {
        test te = new test();
        te.perform();
        System.exit(0);
    }
    
}
