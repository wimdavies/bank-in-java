package bank;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class BankAccountIntegrationTest {
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

    @Test
    public void testGenerateStatementListsMultipleDepositsAndTracksBalance() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(1000, LocalDate.of(2021, 1, 10));
        bankAccount.deposit(2000, LocalDate.of(2021, 1, 11));
        bankAccount.deposit(3000, LocalDate.of(2021, 1, 12));
        Assert.assertEquals(
                """
                        date || credit || debit || balance
                        12/01/2021 || 3000.00 || - || 6000.00
                        11/01/2021 || 2000.00 || - || 3000.00
                        10/01/2021 || 1000.00 || - || 1000.00
                        """,
                bankAccount.generateStatement()
        );
    }

    @Test
    public void testGenerateStatementReturnsCorrectOrderWhenDepositsOutOfOrder() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(3000, LocalDate.of(2021, 1, 12));
        bankAccount.deposit(1000, LocalDate.of(2021, 1, 10));
        bankAccount.deposit(2000, LocalDate.of(2021, 1, 11));
        Assert.assertEquals(
                """
                        date || credit || debit || balance
                        12/01/2021 || 3000.00 || - || 6000.00
                        11/01/2021 || 2000.00 || - || 3000.00
                        10/01/2021 || 1000.00 || - || 1000.00
                        """,
                bankAccount.generateStatement()
        );
    }

    @Test
    public void testGenerateStatementListsOneWithdrawal() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(1000, LocalDate.of(2021, 1, 10));
        Assert.assertEquals(
                """
                        date || credit || debit || balance
                        10/01/2021 || - || 1000.00 || -1000.00
                        """,
                bankAccount.generateStatement()
        );
    }

    @Test
    public void testGenerateStatementListsMultipleWithdrawalsAndTracksBalance() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(1000, LocalDate.of(2021, 1, 10));
        bankAccount.withdraw(2000, LocalDate.of(2021, 1, 11));
        bankAccount.withdraw(3000, LocalDate.of(2021, 1, 12));
        Assert.assertEquals(
                """
                        date || credit || debit || balance
                        12/01/2021 || - || 3000.00 || -6000.00
                        11/01/2021 || - || 2000.00 || -3000.00
                        10/01/2021 || - || 1000.00 || -1000.00
                        """,
                bankAccount.generateStatement()
        );
    }
}
