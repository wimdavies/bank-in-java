package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;

public class BankAccount {
    private final ArrayList<Transaction> transactions;
    private static final String header = "date || credit || debit || balance\n";

    public BankAccount() {
        this.transactions = new ArrayList<>();
    }

    public String generateStatement() {
        if (this.transactions.isEmpty()) return header;

        // Sort transactions in chronological order
        Collections.sort(this.transactions);

        ArrayList<String> lines = new ArrayList<>();
        Integer balance = 0;

        for (Transaction transaction : this.transactions) {
            Integer amount = transaction.amount();
            balance += amount;

            String formattedDate = transaction.date().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
            String formattedAmount = amount + ".00";
            String formattedBalance = balance + ".00";

            String line = String.format("%s || %s || %s || %s\n",
                    formattedDate,
                    formattedAmount,
                    "-",
                    formattedBalance
            );
            lines.add(line);
        }

        Collections.reverse(lines);

        return header + String.join("", lines);
    }

    public void deposit(Integer amount, LocalDate date) {
        Transaction transaction = new Transaction(amount, date);
        this.transactions.add(transaction);
    }

    // private
}
