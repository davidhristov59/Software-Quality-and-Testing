package aud1.test;

import aud1.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(100.0);
    }

    @Test
    void testGetBalance() {
        Assertions.assertEquals(100.0, bankAccount.getBalance(), "Initial balance should be 100.0");
    }

    @Test
    void testDepositValidAmount(){
        bankAccount.deposit(50.0); //100 + 50 = 150
        Assertions.assertEquals(150.0, bankAccount.getBalance(), "After depositing 50.0, balance should be 150.0");
    }

    @Test
    void testDepositInvalidAmount(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-10.0));
    }

    @Test
    void testDepositNegativeAmountThrowsExceptionMessage() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-10.0));
        Assertions.assertEquals("Deposit amount must be positive.", exception.getMessage());
    }

    @Test
    void testWithdrawValidAmount(){
        bankAccount.withdraw(50.0);
        Assertions.assertEquals(50.0, bankAccount.getBalance(), "After withdrawing 50.0, balance should be 50.0");
    }

    @Test
    void testWithdrawInvalidAmount(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-10.0));
    }

    @Test
    void testWithdrawNegativeAmountThrowsExceptionMessage() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-10.0));
        Assertions.assertEquals("Withdrawal amount must be positive.", exception.getMessage());
    }

    @Test
    void testWithdrawInsufficientFundsThrowsExceptionType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(200.0));
    }

    @Test
    void testWithdrawInsufficientFundsThrowsExceptionMessage() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(200.0));
        Assertions.assertEquals("Insufficient funds.", exception.getMessage());
    }


}