package model;

import java.sql.*;

public class CustomerDetails {

	private String customerID;

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;

	private CustomerAddress address;

	public CustomerDetails(String firstName, String lastName, String phoneNumber, String emailAddress,
			CustomerAddress address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		setCustomerID();
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID() {
		this.customerID = this.lastName.toUpperCase() + this.phoneNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public CustomerAddress getAddress() {
		return address;
	}

	public void setAddress(CustomerAddress address) {
		this.address = address;
	}

	// Check if customer is already in the database
	public void validateCustomerDetails(Connection connection) {
		System.out.println("\nValidating Customer Details...");
		String sqlStatement = "select customerID from customer_details where customerID = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sqlStatement);

			ps.setString(1, customerID);

			ResultSet rs = ps.executeQuery();

			// if existing, no need to add.
			if (rs.next()) {
				System.out.println("Customer is already in the database.");
			} else {
				// if new customer, add details to database.
				if (addCustomerDetails(connection)) {
					System.out.println("Customer successfully inserted to database.");
				} else {
					System.out.println("Something went wrong. Please Try Again.");
				}
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
		}
	}

	public boolean addCustomerDetails(Connection connection) {
		System.out.println("\nAdding customer in the database...");
		String sqlStatement = "insert into "
				+ "customer_details(customerID, firstName, lastName, phoneNumber, emailAddress, "
				+ "houseNumber, street, barangaySubdivision, city, province, zipcode)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sqlStatement);

			ps.setString(1, customerID);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, phoneNumber);
			ps.setString(5, emailAddress);
			ps.setString(6, address.getHouseNumber());
			ps.setString(7, address.getStreet());
			ps.setString(8, address.getBarangaySubdivision());
			ps.setString(9, address.getCity());
			ps.setString(10, address.getProvince());
			ps.setString(11, address.getZipCode());

			ps.executeUpdate();

			return true;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return false;
		} catch (Exception e) {
			return false;
		}

	}

}
