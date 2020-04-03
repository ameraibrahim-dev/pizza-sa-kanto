package model;

public interface ValidatorInterface {
	public boolean validateTextFormat(String text);
	public boolean validateNumberFormat(String number);
	public boolean validateEmail(String text);
	public boolean validateCardNumber(String cardNumber);
}
