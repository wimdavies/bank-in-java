package bank;

import java.time.LocalDate;

public class Transaction implements Comparable<Transaction> {
    private final Integer amount;
    private final LocalDate date;

    public Transaction(Integer amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public int compareTo(Transaction other) {
        return this.date.compareTo(other.date);
    }
}
