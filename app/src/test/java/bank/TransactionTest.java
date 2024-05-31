package bank;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TransactionTest {
    @Test
    public void testAmountReturnsAmount() {
        Transaction transaction = new Transaction(1000, LocalDate.of(2021, 1, 10));
        Assert.assertEquals(1000, (int) transaction.amount());
    }

    @Test
    public void testDateReturnsDate() {
        Transaction transaction = new Transaction(1000, LocalDate.of(2021, 1, 10));
        LocalDate date = LocalDate.of(2021, 1, 10);
        Assert.assertEquals(date, transaction.date());
    }

    @Test
    public void testCompareTo() {
        Transaction transaction1 = new Transaction(1000, LocalDate.of(2021, 1, 10));
        Transaction transaction2 = new Transaction(1000, LocalDate.of(2021, 1, 10));
        Assert.assertEquals(0, transaction1.compareTo(transaction2));
    }
}
