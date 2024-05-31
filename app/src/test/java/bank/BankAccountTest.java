package bank;

import org.junit.Assert;
import org.junit.Test;

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
}
