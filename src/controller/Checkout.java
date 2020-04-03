package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.ValidateUserInput;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		Cart cart = null;
		
		if (session.getAttribute("cart") == null) {
			cart = new Cart();
		} else {
		    cart = (Cart)session.getAttribute("cart");
		}
		
		if(cart.cartTotal() < 1) {
			session.setAttribute("cart", cart);
			request.setAttribute("message","Cart is empty. Please add products.");
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}else {
			session.setAttribute("cart", cart);
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
