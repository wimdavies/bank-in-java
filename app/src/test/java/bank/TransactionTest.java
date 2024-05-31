package bank;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TransactionTest {
    @Test
    public void testGetAmountReturnsAmount() {
        Transaction transaction = new Transaction(1000, LocalDate.of(2021, 1, 10));
        Assert.assertEquals(1000, (int) transaction.getAmount());
    }

    @Test
    public void testGetDateReturnsDate() {
        Transaction transaction = new Transaction(1000, LocalDate.of(2021, 1, 10));
        LocalDate date = LocalDate.of(2021, 1, 10);
        Assert.assertEquals(date, transaction.getDate());
    }
}
