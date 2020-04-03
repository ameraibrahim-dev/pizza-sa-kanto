package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.PastaFactory;
import model.PastaInterface;
import model.PizzaFactory;
import model.PizzaInterface;

/**
 * Servlet implementation class InitializeProducts
 */
@WebServlet("/pizza")
public class InitializePizza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		PizzaInterface hawaiian = new PizzaFactory().getPizza("HAWAIIAN");
		PizzaInterface fourSeasons = new PizzaFactory().getPizza("FOURSEASONS");
		PizzaInterface roastedGarlicShrimp = new PizzaFactory().getPizza("ROASTEDGARLICSHRIMP");
	
		
		request.setAttribute("hawaiian", hawaiian);
		request.setAttribute("fourSeasons", fourSeasons);
		request.setAttribute("roastedGarlicShrimp", roastedGarlicShrimp);
		
		request.getRequestDispatcher("pizza.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
