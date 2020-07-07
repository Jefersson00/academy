package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class collegamento {
	
	
	
	private static Connection dbConnection = null;
	private static String nameDb="corsor";
	private static String port="localhost:3305";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String userName = "root";
	private static String password = "MariaLocalDB";
	
	
	collegamento() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	
	
	private static void conessione() {
		
		try {
			

			Class.forName(driver);
			String url = "jdbc:mysql://"+port+"/"+nameDb+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			dbConnection = DriverManager.getConnection(url, userName, password);
			System.out.println("conessione!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch!!!!!!");
		}
			
		
	}

	
	
	/**
	 * @return the dbConnection
	 * @throws SQLException 
	 */
	public static Connection getDbConnection() {
		conessione();
		return dbConnection;
	}

	/**
	 * @param dbConnection the dbConnection to set
	 */
	public static void setDbConnection(Connection dbConnection) {
		collegamento.dbConnection = dbConnection;
	}
	
}
