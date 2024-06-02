package bank;

import bank.exceptions.InvalidDepositAmountException;
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
}
