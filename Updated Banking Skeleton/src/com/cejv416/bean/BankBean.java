package com.cejv416.bean;

import java.math.BigDecimal;

/**
 * The account bean that holds all the data for every account type
 *
 * @author Julie Martin
 * @version 0.1
 */
public class BankBean {

    private BigDecimal startingBalance;
    private BigDecimal currentBalance;
    private BigDecimal totalDeposits;
    private int numberOfDeposits;
    private BigDecimal totalWithdrawals;
    private int numberOfWithdrawals;
    private BigDecimal annualInterestRate;
    private BigDecimal serviceCharge;
    private boolean status;

    /**
     * Default constructor that creates a been with a starting balance of 0 and
     * an interest rate of 1%
     */
    public BankBean() {
        this(BigDecimal.ZERO, new BigDecimal("0.01"));
    }

    /**
     * Non-default constructor that sets the starting balance and interest rate
     * to the values received
     *
     * @param startingBalance
     * @param annualInterestRate
     */
    public BankBean(BigDecimal startingBalance, BigDecimal annualInterestRate) {
        super();
        this.startingBalance = startingBalance;
        this.currentBalance = startingBalance;
        this.totalDeposits = BigDecimal.ZERO;
        this.numberOfDeposits = 0;
        this.totalWithdrawals = BigDecimal.ZERO;
        this.numberOfWithdrawals = 0;
        this.annualInterestRate = annualInterestRate;
        this.serviceCharge = BigDecimal.ZERO;
        this.status = startingBalance.compareTo(new BigDecimal("25.0")) != -1;
    }

    public BigDecimal getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(BigDecimal startingBalance) {
        this.startingBalance = startingBalance;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getTotalDeposits() {
        return totalDeposits;
    }

    public void setTotalDeposits(BigDecimal totalDeposits) {
        this.totalDeposits = totalDeposits;
    }

    public int getNumberOfDeposits() {
        return numberOfDeposits;
    }

    public void setNumberOfDeposits(int numberOfDeposits) {
        this.numberOfDeposits = numberOfDeposits;
    }

    public BigDecimal getTotalWithdrawals() {
        return totalWithdrawals;
    }

    public void setTotalWithdrawals(BigDecimal totalWithdrawals) {
        this.totalWithdrawals = totalWithdrawals;
    }

    public int getNumberOfWithdrawals() {
        return numberOfWithdrawals;
    }

    public void setNumberOfWithdrawals(int numberOfWithdrawals) {
        this.numberOfWithdrawals = numberOfWithdrawals;
    }

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(BigDecimal annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * The handy dandy method that can be used to display the current state of
     * the bean in a System.out.println()
     *
     * @return
     */
    @Override
    public String toString() {
        return "BankBean{" + "startingBalance=" + startingBalance.toString() + ", currentBalance=" + currentBalance.toString() + ", totalDeposits=" + totalDeposits + ", numberOfDeposits=" + numberOfDeposits + ", totalWithdrawals=" + totalWithdrawals.toString() + ", numberOfWithdrawals=" + numberOfWithdrawals + ", annualInterestRate=" + annualInterestRate.toString() + ", serviceCharge=" + serviceCharge.toString() + ", status=" + status + '}';
    }

}
