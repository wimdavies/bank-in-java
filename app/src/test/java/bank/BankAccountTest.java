package bank;

import bank.exceptions.BankAccountException;
import bank.exceptions.InvalidDateException;
import bank.exceptions.InvalidDepositAmountException;
import bank.exceptions.InvalidWithdrawAmountException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class BankAccountTest {
    @Test
    public void testGenerateStatementReturnsHeaderWhenNoTransactions() {
        BankAccount bankAccount = new BankAccount();
        Assert.assertEquals(
                """
                        date || credit || debit || balance
                        """,
                bankAccount.generateStatement()
        );
    }

    @Test(expected = InvalidDepositAmountException.class)
    public void testDepositThrowsForAmountsLessThanOrEqualToZero() throws BankAccountException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(0, LocalDate.of(2021, 1, 10));
    }

    @Test(expected = InvalidWithdrawAmountException.class)
    public void testWithdrawThrowsForAmountsGreaterThanOrEqualToZero() throws BankAccountException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(0, LocalDate.of(2021, 1, 10));
    }

    @Test(expected = InvalidDateException.class)
    public void testDepositThrowsForDatesBeyondToday() throws BankAccountException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(1000, LocalDate.of(2025, 1, 10));
    }

    @Test(expected = InvalidDateException.class)
    public void testWithdrawThrowsForDatesBeyondToday() throws BankAccountException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(1000, LocalDate.of(2025, 1, 10));
    }
}
