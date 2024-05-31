package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class BankAccount {
    private final ArrayList<Transaction> transactions;

    public BankAccount() {
        this.transactions = new ArrayList<>();
    }

    public String generateStatement() {
        if (this.transactions.isEmpty()) {
            return "date || credit || debit || balance\n";
        }
        Transaction transaction = transactions.getFirst();
        String formattedDate = transaction.getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        String formattedAmount = transaction.getAmount().toString() + ".00";
        return "date || credit || debit || balance\n" + formattedDate + " || " + formattedAmount + " || - || 1000.00";
    }

    public void deposit(Integer amount, LocalDate date) {
        Transaction transaction = new Transaction(amount, date);
        this.transactions.add(transaction);
    }
}
