package crud.operation.connection;

import java.sql.*;

import jakarta.servlet.ServletContext;

public class DBConnection {

	public static Connection getConnection(ServletContext context) throws Exception {

		String url = context.getInitParameter("url");
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		String driver = context.getInitParameter("driver");

		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

}
