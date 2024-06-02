package bank.exceptions;

public class BankAccountException extends Throwable {
    public BankAccountException(String errorMessage) {
        super(errorMessage);
    }
}
