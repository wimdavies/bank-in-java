package bank;

import bank.exceptions.InvalidDepositAmountException;
import bank.exceptions.InvalidWithdrawAmountException;

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

        ArrayList<String> statementLines = new ArrayList<>();
        Integer balance = 0;

        for (Transaction transaction : this.transactions) {
            Integer amount = transaction.amount();
            balance += amount;

            String formattedDate = transaction.date().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
            String formattedAmount = Math.abs(amount) + ".00";
            String formattedBalance = balance + ".00";

            String line = String.format("%s || %s || %s || %s\n",
                    formattedDate,
                    (amount > 0 ? formattedAmount : "-"),
                    (amount < 0 ? formattedAmount : "-"),
                    formattedBalance
            );
            statementLines.add(line);
        }

        Collections.reverse(statementLines);

        return header + String.join("", statementLines);
    }

    public void deposit(Integer amount, LocalDate date) throws InvalidDepositAmountException {
        if (amount <= 0) {
            throw new InvalidDepositAmountException("Deposit amounts must be greater than zero.");
        }
        Transaction transaction = new Transaction(amount, date);
        this.transactions.add(transaction);
    }

    public void withdraw(Integer amount, LocalDate date) throws InvalidWithdrawAmountException {
        if (amount <= 0) {
            throw new InvalidWithdrawAmountException("Withdrawal amounts must be greater than zero.");
        }
        Transaction transaction = new Transaction(-amount, date);
        this.transactions.add(transaction);
    }

    // private
}
