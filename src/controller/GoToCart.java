package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

@WebServlet("/GoToCart")
public class GoToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		cart.computeGrossPay();
		cart.computeVAT();
		cart.computeNetPay();
		
		session.setAttribute("cart", cart); //Pushes cart to JSP
		request.getRequestDispatcher("cart.jsp").forward(request, response);

	}
}
