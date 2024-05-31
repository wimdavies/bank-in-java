package bank;

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

    @Test
    public void testGenerateStatementListsOneDeposit() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(1000, LocalDate.of(2021, 1, 10));
        Assert.assertEquals(
                """
                        date || credit || debit || balance
                        10/01/2021 || 1000.00 || - || 1000.00
                        """,
                bankAccount.generateStatement()
        );
    }
}
