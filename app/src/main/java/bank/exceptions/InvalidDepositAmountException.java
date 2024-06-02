package bank.exceptions;

public class InvalidDepositAmountException extends BankAccountException {
    public InvalidDepositAmountException(String errorMessage) {
        super(errorMessage);
    }
}
