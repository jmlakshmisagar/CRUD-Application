package crud.operation.services;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import crud.operation.connection.DBConnection;

@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection connection = DBConnection.getConnection(getServletContext());
			Statement statement = connection.createStatement();

			String name = request.getParameter("emp_name");
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");
			String department = request.getParameter("department");
			String salary = request.getParameter("salary");
			String city = request.getParameter("city");
			String phone = request.getParameter("phone");

			String insertQuery = "INSERT INTO employee (emp_name, gender, age, department, salary, city, phone) VALUES "
					+ "('" + name + "', '" + gender + "', '" + age + "', '" + department + "', '" + salary + "', '"
					+ city + "', '" + phone + "')";

			statement.executeUpdate(insertQuery);

			// Fetch updated list
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

			request.setAttribute("result", resultSet);

			// Forward to home.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
