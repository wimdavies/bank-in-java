package bank.exceptions;

public class InvalidDateException extends BankAccountException {
    public InvalidDateException(String errorMessage) {
        super(errorMessage);
    }
}
