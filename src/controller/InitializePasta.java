package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PastaFactory;
import model.PastaInterface;

/**
 * Servlet implementation class InitializePasta
 */
@WebServlet("/pasta")
public class InitializePasta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
		
		PastaInterface chickenAlfredo = new PastaFactory().getPasta("CHICKENALFREDO");
		PastaInterface spaghettiMeatballs = new PastaFactory().getPasta("SPAGHETTIMEATBALLS");
		PastaInterface shrimpAlfredo = new PastaFactory().getPasta("SHRIMPALFREDO");
		
		request.setAttribute("chickenAlfredo", chickenAlfredo);
		request.setAttribute("spaghettiMeatballs", spaghettiMeatballs);
		request.setAttribute("shrimpAlfredo", shrimpAlfredo);
		
		request.getRequestDispatcher("pasta.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
