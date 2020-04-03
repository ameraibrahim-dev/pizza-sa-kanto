package controller;

import java.io.IOException;
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

		Transaction transaction = null;

		if (validator.validUserInput()) {
			transaction = new Transaction(
					new CustomerDetails(firstName, lastName, phoneNumber, emailAddress,
							new CustomerAddress(houseNumber, street, barangaySubdivision, city, province, zipCode)),
					cart);

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

}
