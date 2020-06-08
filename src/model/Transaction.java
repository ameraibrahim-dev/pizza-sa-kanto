package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction implements Cloneable{
	
	private CustomerDetails details;
	private Cart cart;
	
	public Transaction(CustomerDetails details, Cart cart){
		this.details = details;
		this.cart = cart;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
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
	
	public boolean addTransaction(Connection connection) {
		System.out.println("\nAdding transaction in the database...");
		String sqlStatement = "insert into "
				+ "transactions(customerID, transaction_grossPay, transaction_VAT, transaction_netPay)"
				+ "values (?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sqlStatement);
			
			ps.setString(1, details.getCustomerID());
			ps.setFloat(2, cart.getGrossPay());
			ps.setFloat(3, cart.getVAT());
			ps.setFloat(4, cart.getNetPay());
			
			ps.executeUpdate();
			
			return true;
		}catch(SQLException sqle) {
			System.out.println(sqle);
			return false;
		}catch(Exception e) {
			return false;
		}
				
	}
}
