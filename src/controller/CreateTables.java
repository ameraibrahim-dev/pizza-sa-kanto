package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.DatabaseMetaData;

import utility.CreateTablesDBConnection;

/**
 * Servlet implementation class createtables
 */
@WebServlet("/createtables.action")
public class CreateTables extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTables() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = null;
		Connection connection = null;
		try {
			//Get Connection
			connection = CreateTablesDBConnection.getConnection();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		try {
			ResultSet resultSet = connection.getMetaData().getCatalogs();
			Statement statement = connection.createStatement();
			boolean databaseExisting = false;
			//Iterate each catalog in the ResultSet to check if Database exists
			while (resultSet.next()) {
				String databaseName = resultSet.getString(1);
				if (databaseName.equals("pizzasakantodb")) {
					databaseExisting = true;
				}
			}
			resultSet.close();
			if (databaseExisting) {
				System.out.println("Database already exists.");
				message = "pizzasakantodb Already exists.";

			} else {
				// Create Database if not existing
				// Create pizzasakantodb schema
				String createDB = "CREATE DATABASE pizzasakantodb";
				statement.executeUpdate(createDB);
				System.out.println("Successfully created pizzasakantodb database.");
				//Create customer_details table
				String createCustomerDetailsTable = "CREATE TABLE pizzasakantodb.`customer_details` (\r\n"
						+ "  `customerID` varchar(50) NOT NULL,\r\n" + "  `firstName` varchar(50) NOT NULL,\r\n"
						+ "  `lastName` varchar(50) NOT NULL,\r\n" + "  `phoneNumber` varchar(50) NOT NULL,\r\n"
						+ "  `emailAddress` varchar(50) NOT NULL,\r\n" + "  `houseNumber` varchar(50) NOT NULL,\r\n"
						+ "  `street` varchar(50) NOT NULL,\r\n" + "  `barangaySubdivision` varchar(50) NOT NULL,\r\n"
						+ "  `city` varchar(50) NOT NULL,\r\n" + "  `province` varchar(50) NOT NULL,\r\n"
						+ "  `zipcode` varchar(5) NOT NULL,\r\n" + "    PRIMARY KEY (customerID)\r\n"
						+ ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
				statement.executeUpdate(createCustomerDetailsTable);
				System.out.println("Successfully created customer_details table");
				//Create transactions table
				String createTransactionsTable = "CREATE TABLE pizzasakantodb.`transactions` (\r\n"
						+ "  `transactionID` int(11) NOT NULL AUTO_INCREMENT,\r\n"
						+ "  `customerID` varchar(50) NOT NULL,\r\n" + "  `transaction_grossPay` float NOT NULL,\r\n"
						+ "  `transaction_VAT` float NOT NULL,\r\n" + "  `transaction_netPay` float NOT NULL,\r\n"
						+ "    PRIMARY KEY (transactionID),\r\n"
						+ "    FOREIGN KEY (customerID) REFERENCES customer_details(customerID)\r\n"
						+ ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
				statement.executeUpdate(createTransactionsTable);
				System.out.println("Successfully created transactions table");
				message = "Successfully created pizzasakantodb with customer_details and transaction tables.";
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("./pizza").forward(request, response);
	}
}
