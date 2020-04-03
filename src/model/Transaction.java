package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transaction {
	
	private CustomerDetails details;
	private Cart cart;
	
	public Transaction(CustomerDetails details, Cart cart){
		this.details = details;
		this.cart = cart;
	}

	public CustomerDetails getDetails() {
		return details;
	}

	public void setDetails(CustomerDetails details) {
		this.details = details;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
