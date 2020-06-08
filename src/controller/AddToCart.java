package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.ProductOrder;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Cart cart = null;
		
		if (session.getAttribute("cart") == null) {
			cart = new Cart();
		} else {
		    cart = (Cart)session.getAttribute("cart");
		}
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		String imageSource = request.getParameter("imageSource");
		String size = request.getParameter("size");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		ProductOrder order = new ProductOrder(name, category, description, imageSource, size, quantity);
		
		String message = "Succesfully added " + name + " to cart.";
		
		//Facade Design Pattern
		order.process();
		cart.addToCart(order);
		
		session.setAttribute("cart", cart);
		request.setAttribute("message", message);
		request.getRequestDispatcher("./pizza").forward(request, response);
		
	}

}
