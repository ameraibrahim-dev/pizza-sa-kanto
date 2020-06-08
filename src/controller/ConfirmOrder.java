package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.CustomerAddress;
import model.CustomerDetails;
import model.TestCloneInterface;
import model.TestSingletonInterface;
import model.Transaction;
import model.ValidateUserInput;
import utility.SingletonDBConnection;

/**
 * Servlet implementation class ConfirmOrder
 */
@WebServlet("/ConfirmOrder")
public class ConfirmOrder extends HttpServlet implements TestSingletonInterface, TestCloneInterface {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		Cart cart = null;

		if (session.getAttribute("cart") == null) {
			cart = new Cart();
		} else {
			cart = (Cart) session.getAttribute("cart");
		}

		Dictionary<String, String> userInput = new Hashtable<String, String>();

		String firstName = request.getParameter("firstName");
		userInput.put("firstName", firstName);
		String lastName = request.getParameter("lastName");
		userInput.put("lastName", lastName);
		String phoneNumber = request.getParameter("phoneNumber");
		userInput.put("phoneNumber", phoneNumber);
		String emailAddress = request.getParameter("emailAddress");
		userInput.put("emailAddress", emailAddress);

		String houseNumber = request.getParameter("houseNumber");
		userInput.put("houseNumber", houseNumber);
		String street = request.getParameter("street");
		userInput.put("street", street);
		String barangaySubdivision = request.getParameter("barangaySubdivision");
		userInput.put("barangaySubdivision", barangaySubdivision);
		String city = request.getParameter("city");
		userInput.put("city", city);
		String province = request.getParameter("province");
		userInput.put("province", province);
		String zipCode = request.getParameter("zipCode");
		userInput.put("zipCode", zipCode);

		String paymentType = request.getParameter("paymentType");
		userInput.put("paymentType", paymentType);
		String cardNumber = request.getParameter("cardNumber");
		userInput.put("cardNumber", cardNumber);

		ValidateUserInput validator = new ValidateUserInput(firstName, lastName, phoneNumber, emailAddress, street,
				barangaySubdivision, city, province, zipCode, paymentType, cardNumber);

		if (validator.validUserInput()) {
			
			CustomerAddress customerAddress = new CustomerAddress(houseNumber, street, barangaySubdivision, city, province, zipCode);
			CustomerDetails customerDetails = new CustomerDetails(firstName, lastName, phoneNumber, emailAddress, customerAddress);
			Transaction transaction = new Transaction(customerDetails, cart);
			
			try {
				//PROTOTYPE - Shallow Clone (Revision: Clone Transaction instead of Customer Details)
				System.out.println("\nCloning Customer Details...");
				//Clone Transaction
				Transaction cloneTransaction = (Transaction) transaction.clone();
				
				//Print Original Transaction before Modification
				display(transaction, "Original Transaction before modification");
						
				//Print Cloned Transaction before Modification
				display(cloneTransaction, "Cloned Transaction before modification");
					
				//Modify Cloned Transaction
				cloneTransaction.getDetails().setFirstName(validator.formatUserInput(firstName));
				cloneTransaction.getDetails().setLastName(validator.formatUserInput(lastName));
				cloneTransaction.getDetails().getAddress().setHouseNumber(validator.formatUserInput(houseNumber));
				cloneTransaction.getDetails().getAddress().setStreet(validator.formatUserInput(street));
				cloneTransaction.getDetails().getAddress().setBarangaySubdivision(validator.formatUserInput(barangaySubdivision));
				cloneTransaction.getDetails().getAddress().setCity(validator.formatUserInput(city));
				cloneTransaction.getDetails().getAddress().setProvince(validator.formatUserInput(province));
				
				//Test Cloning
				testClone(transaction, cloneTransaction);
				
				
				//Print Original Transaction after Modification
				display(transaction, "Original Transaction after modification");
						
				//Print Cloned Transaction after Modification
				display(cloneTransaction, "Cloned Transaction after modification");
				
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//Test Singleton
			try {
				testSingleton();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Connection connection = null;
			
			try {
				connection = SingletonDBConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Check if customer is already in the database
			customerDetails.validateCustomerDetails(connection);
			
			//Add transaction to database.
			if (transaction.addTransaction(connection)) {
				System.out.println("\nTransaction successfully inserted to database.");
			} else {
				System.out.println("\nSomething went wrong. Please Try Again.");
			}

			session.setAttribute("cart", cart);
			request.setAttribute("transaction", transaction);
			request.getRequestDispatcher("orderConfirmation.jsp").forward(request, response);
			cart.clearCart();
		} else {
			validator.setErrors();
			
			session.setAttribute("cart", cart);
			request.setAttribute("validator", validator);
			request.setAttribute("userInput", userInput);
			request.setAttribute("errors", validator.getErrors());
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
		}

	}
	
	@Override
	public void testSingleton() throws ClassNotFoundException {
		System.out.println("\nTesting Singleton...");
		Connection x = SingletonDBConnection.getConnection();
		Connection y = SingletonDBConnection.getConnection();
		Connection z = SingletonDBConnection.getConnection();
		
		//Reflexive Property
		if(x.equals(x)) {
			System.out.println("Passed Reflexive Property: (x.equals(x))");
		}else {

			System.out.println("Not Passed Reflexive Property: (x.equals(x))");
		}
		
		//Symmetric Property 
		if(x.equals(y) && y.equals(x)) {
			System.out.println("Passed Symmetric Property: (x.equals(y) && y.equals(x))");
		}else {

			System.out.println("Not Passed Symmetric Property: (x.equals(y) && y.equals(x))");
		}
		
		//Transitive Property
		if(x.equals(y) && y.equals(z) && z.equals(x)) {
			System.out.println("Passed Transitive Property: (x.equals(y) && y.equals(z) && z.equals(x))");
		}else {

			System.out.println("Not Passed Transitive Property: (x.equals(y) && y.equals(z) && z.equals(x))");
		}
		
		//Test Consistent Property using Transitive Property
		System.out.println("\nTesting Consistent Property...");
		for (int counter = 1; counter <=10; counter++) {
			if(x.equals(y) && y.equals(z) && z.equals(x)) {
				System.out.println("Passed Transitive Property: (x.equals(y) && y.equals(z) && z.equals(x))");
			}else {

				System.out.println("Not Passed Transitive Property: (x.equals(y) && y.equals(z) && z.equals(x))");
			}
		}
		
		//Test Non- null reference
		System.out.println("\nTesting Non-null Reference Value");
		if(x.equals(null)) {
			System.out.println("x is null - failed");
		}else {
			System.out.println("x is not null - passed");
		}
	}

	@Override
	public void testClone(Object original, Object cloned) {
		System.out.println("\nTesting Clone...");
		System.out.println("Check Memory Address: " + 
				(original != cloned));
		System.out.println("Check Class: " + 
				(original.getClass() == cloned.getClass()));
		System.out.println("Check Reference: " + 
				(original.equals(cloned)));
	}

	@Override
	public void display(Object object, String description) {
		System.out.println("\n" + description);
		System.out.println("First Name: " + ((Transaction) object).getDetails().getFirstName());
		System.out.println("Last Name: " + ((Transaction) object).getDetails().getLastName());
		System.out.println("Phone Number: " + ((Transaction) object).getDetails().getPhoneNumber());
		System.out.println("Email Address: " + ((Transaction) object).getDetails().getEmailAddress());
		System.out.println("House Number: " + ((Transaction) object).getDetails().getAddress().getHouseNumber());
		System.out.println("Street: " + ((Transaction) object).getDetails().getAddress().getStreet());
		System.out.println("Barangay/ Subdivision: " + ((Transaction) object).getDetails().getAddress().getBarangaySubdivision());
		System.out.println("City: " + ((Transaction) object).getDetails().getAddress().getCity());
		System.out.println("Province: " + ((Transaction) object).getDetails().getAddress().getProvince());
		System.out.println("Zip Code: " + ((Transaction) object).getDetails().getAddress().getZipCode());
	}
}
