package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DbConnectionManager {
	private static final String DB_NAME = "studentapp";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "postgres";
	private static final String DB_PORT = "5433";
	private static final String DB_CONNECTION_URL = "jdbc:postgresql://localhost" + ":" + DB_PORT + "/" + DB_NAME;
	
	private Connection connection = null;
	private Statement statement = null;
	
	private static DbConnectionManager instance;

	private DbConnectionManager() {}
	
	public static DbConnectionManager getInstance() {
		if(instance == null) {
			instance = new DbConnectionManager();
		}
			return instance;
	}
	
	private Connection getConnection() {
		try {
			connection = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);
			System.out.println("Connection established.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	private Statement getStatement(Connection connection) {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Couldn't create statement.");
			System.out.println(e.getMessage());
		}
		return statement;
	}
	
	public ResultSet executeQuery(String sqlQueryString) throws SQLException {
		return this.getStatement(this.getConnection()).executeQuery(sqlQueryString);
	}
	
	public PreparedStatement preparedStatement(String statementString) throws SQLException {
		return this.getConnection().prepareStatement(statementString);
	}
	
	public void closeConnection() {
		try {
			if(statement != null) statement.close();
			if(connection != null) connection.close();
			System.out.println("Connection closed.");
		} catch (SQLException e) {
			System.out.println("Couldn't close statement or connection.");
			System.out.println(e.getMessage());
		}
	}
	
}
