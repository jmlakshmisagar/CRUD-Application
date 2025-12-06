package crud.operation.services;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;
import java.io.IOException;

import crud.operation.connection.DBConnection;

public class ListEmployees extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection connection = DBConnection.getConnection(getServletContext());

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

            request.setAttribute("result", resultSet);

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
