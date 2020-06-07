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
import model.Transaction;
import model.ValidateUserInput;
import utility.SingletonDBConnection;

/**
 * Servlet implementation class ConfirmOrder
 */
@WebServlet("/ConfirmOrder")
public class ConfirmOrder extends HttpServlet {
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
				System.out.println("Cloning Customer Details...");
				//Clone CustomerDetails
				CustomerDetails formatCustomerDetails = (CustomerDetails) customerDetails.clone();
				
				//Print Original Customer Details before Modification
				printClone(customerDetails, "ORIGINAL BEFORE MODIFICATION");
				
				//Print Cloned Customer Details before Modification
				printClone(formatCustomerDetails, "CLONED BEFORE MODIFICATION");
				
				//Modify Cloned CustomerDetails
				formatCustomerDetails.setFirstName(formatCustomerDetails.formatUserInput(firstName));
				formatCustomerDetails.setLastName(formatCustomerDetails.formatUserInput(lastName));
				formatCustomerDetails.getAddress().setHouseNumber(formatCustomerDetails.formatUserInput(houseNumber));
				formatCustomerDetails.getAddress().setStreet(formatCustomerDetails.formatUserInput(street));
				formatCustomerDetails.getAddress().setBarangaySubdivision(formatCustomerDetails.formatUserInput(barangaySubdivision));
				formatCustomerDetails.getAddress().setCity(formatCustomerDetails.formatUserInput(city));
				formatCustomerDetails.getAddress().setProvince(formatCustomerDetails.formatUserInput(province));
				
				//Test Cloning
				System.out.println("Check Memory Address: " + 
						(customerDetails != formatCustomerDetails));
				System.out.println("Check Class: " + 
						(customerDetails.getClass() == formatCustomerDetails.getClass()));
				System.out.println("Check Reference: " + 
						(customerDetails.equals(formatCustomerDetails)));
				
				//Print Original Customer Details after Modification
				printClone(customerDetails, "ORIGINAL AFTER MODIFICATION");
				
				//Print Cloned Customer Details after Modification
				printClone(formatCustomerDetails, "CLONED AFTER MODIFICATION");
				
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//Test Singleton
			/*try {
				testObjectEqualsProperties();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			
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
				System.out.println("Transaction successfully inserted to database.");
			} else {
				System.out.println("Something went wrong. Please Try Again.");
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
	
	public static void printClone(CustomerDetails details, String status) {
		System.out.println(status);
		System.out.println(details.getFirstName());
		System.out.println(details.getLastName());
		System.out.println(details.getPhoneNumber());
		System.out.println(details.getEmailAddress());
		System.out.println(details.getAddress().getHouseNumber());
		System.out.println(details.getAddress().getStreet());
		System.out.println(details.getAddress().getBarangaySubdivision());
		System.out.println(details.getAddress().getCity());
		System.out.println(details.getAddress().getProvince());
		System.out.println(details.getAddress().getZipCode());
	}
	
	public static void testObjectEqualsProperties() throws ClassNotFoundException {
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
		System.out.println("TESTING CONSISTENT PROPERTY");
		for (int counter = 1; counter <=10; counter++) {
			if(x.equals(y) && y.equals(z) && z.equals(x)) {
				System.out.println("Passed Transitive Property: (x.equals(y) && y.equals(z) && z.equals(x))");
			}else {

				System.out.println("Not Passed Transitive Property: (x.equals(y) && y.equals(z) && z.equals(x))");
			}
		}
		
		//Test Non- null reference
		System.out.println("TESTING NON-NULL REFERENCE VALUE");
		if(x.equals(null)) {
			System.out.println("x is null - failed");
		}else {
			System.out.println("x is not null - passed");
		}
	}

}
