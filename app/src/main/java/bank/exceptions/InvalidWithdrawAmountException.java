package bank.exceptions;

public class InvalidWithdrawAmountException extends BankAccountException {
    public InvalidWithdrawAmountException(String errorMessage) {
        super(errorMessage);
    }
}
