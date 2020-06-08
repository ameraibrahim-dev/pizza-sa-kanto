package model;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUserInput implements ValidatorInterface, FormatterInterface {

	private boolean isValidFirstName = false;
	private boolean isValidLastName = false;
	private boolean isValidPhoneNumber = false;
	private boolean isValidEmailAddress = false;

	private boolean isValidStreet = false;
	private boolean isValidBarangaySubdivision = false;
	private boolean isValidCity = false;
	private boolean isValidProvince = false;
	private boolean isValidZipCode = false;
	
	private String paymentType;
	private boolean isValidCardNumber = false;
	
	private Dictionary<String, String> errors = new Hashtable<String, String>();


	public ValidateUserInput(String firstName, String lastName, String phoneNumber, String emailAddress, String street,
			String barangaySubdivision, String city, String province, String zipCode, String paymentType, String cardNumber) {
		this.isValidFirstName = validateTextFormat(firstName);
		this.isValidLastName = validateTextFormat(lastName);
		this.isValidPhoneNumber = phoneNumber.length() == 11 && validateNumberFormat(phoneNumber);
		this.isValidEmailAddress = validateEmail(emailAddress);

		this.isValidStreet = validateTextFormat(street);
		this.isValidBarangaySubdivision = validateTextFormat(barangaySubdivision);
		this.isValidCity = validateTextFormat(city);
		this.isValidProvince = validateTextFormat(province);
		this.isValidZipCode = zipCode.length() == 4 && validateNumberFormat(zipCode);
		this.paymentType = cardNumber;
		this.isValidCardNumber = validateNumberFormat(cardNumber) && validateCardNumber(cardNumber);
	}
	
	public ValidateUserInput() {
	}
	
	public Dictionary<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Dictionary<String, String> errors) {
		this.errors = errors;
	}

	public boolean isValidFirstName() {
		return isValidFirstName;
	}

	public void setValidFirstName(boolean isValidFirstName) {
		this.isValidFirstName = isValidFirstName;
	}

	public boolean isValidLastName() {
		return isValidLastName;
	}

	public void setValidLastName(boolean isValidLastName) {
		this.isValidLastName = isValidLastName;
	}

	public boolean isValidPhoneNumber() {
		return isValidPhoneNumber;
	}

	public void setValidPhoneNumber(boolean isValidPhoneNumber) {
		this.isValidPhoneNumber = isValidPhoneNumber;
	}

	public boolean isValidEmailAddress() {
		return isValidEmailAddress;
	}

	public void setValidEmailAddress(boolean isValidEmailAddress) {
		this.isValidEmailAddress = isValidEmailAddress;
	}

	public boolean isValidStreet() {
		return isValidStreet;
	}

	public void setValidStreet(boolean isValidStreet) {
		this.isValidStreet = isValidStreet;
	}

	public boolean isValidBarangaySubdivision() {
		return isValidBarangaySubdivision;
	}

	public void setValidBarangaySubdivision(boolean isValidBarangaySubdivision) {
		this.isValidBarangaySubdivision = isValidBarangaySubdivision;
	}

	public boolean isValidCity() {
		return isValidCity;
	}

	public void setValidCity(boolean isValidCity) {
		this.isValidCity = isValidCity;
	}

	public boolean isValidProvince() {
		return isValidProvince;
	}

	public void setValidProvince(boolean isValidProvince) {
		this.isValidProvince = isValidProvince;
	}

	public boolean isValidZipCode() {
		return isValidZipCode;
	}

	public void setValidZipCode(boolean isValidZipCode) {
		this.isValidZipCode = isValidZipCode;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public boolean isValidCardNumber() {
		return isValidCardNumber;
	}

	public void setValidCardNumber(boolean isValidCardNumber) {
		this.isValidCardNumber = isValidCardNumber;
	}

	public boolean validUserInput() {
		if (paymentType.contentEquals("card")) {
			return isValidFirstName && isValidLastName && isValidPhoneNumber && isValidEmailAddress && isValidStreet
					&& isValidBarangaySubdivision && isValidCity && isValidProvince & isValidZipCode && isValidCardNumber;
		}else {
			return isValidFirstName && isValidLastName && isValidPhoneNumber && isValidEmailAddress && isValidStreet
			&& isValidBarangaySubdivision && isValidCity && isValidProvince & isValidZipCode;
		}
	}
	
	public void setErrors() {
		if(!isValidFirstName) {
			errors.put("firstName", "Invalid, Letters only.");
		}
		if(!isValidLastName) {
			errors.put("lastName", "Invalid, Letters only.");
		}
		if(!isValidPhoneNumber) {
			errors.put("phoneNumber", "Invalid, Numbers only/ must Contain 11 digits.");
		}
		if(!isValidEmailAddress) {
			errors.put("emailAddress", "Invalid, please include '@'. ");
		}
		if(!isValidStreet) {
			errors.put("street", "Invalid, Letters only.");
		}
		if(!isValidBarangaySubdivision) {
			errors.put("barangaySubdivision", "Invalid, Letters only.");
		}
		if(!isValidCity) {
			errors.put("city", "Invalid, Letters only.");
		}
		if(!isValidProvince) {
			errors.put("province", "Invalid, Letters only.");
		}
		if(!isValidZipCode) {
			errors.put("zipCode", "Invalid, Numbers Only/ Must contain 4 digits.");
		}
		if(!isValidCardNumber) {
			errors.put("cardNumber", "Invalid Card Number/ Numbers Only.");
		}
	}

	@Override
	public boolean validateTextFormat(String text) {
		boolean isValidText = true;

		Pattern digit = Pattern.compile("[0-9]");
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

		Matcher hasDigit = digit.matcher(text);
		Matcher hasSpecial = special.matcher(text);

		if (hasDigit.find() || hasSpecial.find()) {
			isValidText = false;
		}

		return isValidText;
	}

	@Override
	public boolean validateNumberFormat(String numbers) {
		boolean isValidNumber = true;

		Pattern letter = Pattern.compile("[a-zA-z]");
		Pattern special = Pattern.compile("[!@#$%&*()_=|<>?{}\\[\\]~-]");

		Matcher hasLetter = letter.matcher(numbers);
		Matcher hasSpecial = special.matcher(numbers);

		if (hasLetter.find() || hasSpecial.find()) {
			isValidNumber = false;
		}

		return isValidNumber;
	}

	@Override
	public boolean validateEmail(String email) {
		return email.contains("@");
	}

	@Override
	public boolean validateCardNumber(String cardNumber) {
		int sum = 0;
		boolean alternate = false;
		for (int index = cardNumber.length() - 1; index >= 0; index--) {
			int n = Integer.parseInt(cardNumber.substring(index, index + 1));
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		return (sum % 10 == 0);
	}

	@Override
	public String formatUserInput(String input) {
			String[] inputs = input.toLowerCase().split(" ");
			String output = "";
			
			for(String string : inputs) {
				char first = Character.toUpperCase(string.charAt(0));
				String succeeding = string.substring(1, string.length());
				string = first + succeeding;
				output += string + " "; 
			}
			return output.trim();
	}
}
