package bank;

import java.time.LocalDate;

public class Transaction {
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
}
