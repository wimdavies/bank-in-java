package bank;

import java.time.LocalDate;

public record Transaction(Integer amount, LocalDate date) implements Comparable<Transaction> {

    @Override
    public int compareTo(Transaction other) {
        return this.date.compareTo(other.date);
    }
}
