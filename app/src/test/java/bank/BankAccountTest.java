package bank;

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
    public void testDepositThrowsForAmountsLessThanOrEqualToZero() throws InvalidDepositAmountException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(0, LocalDate.of(2021, 1, 10));
    }

    @Test(expected = InvalidWithdrawAmountException.class)
    public void testWithdrawThrowsForAmountsGreaterThanOrEqualToZero() throws InvalidWithdrawAmountException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(0, LocalDate.of(2021, 1, 10));
    }
}
