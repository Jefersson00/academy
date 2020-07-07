package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Collegamento {
	
	
	private  Connection dbConnection = null;
	private  String nameDb="corsor";
	private  String port="localhost:3305";
	private  String driver = "com.mysql.cj.jdbc.Driver";
	private  String userName = "root";
	private  String password = "MariaLocalDB";
	
	/**
	 * 
	 */
	public Collegamento() {
		super();
		// TODO Auto-generated constructor stub
	}



	private  boolean conessione() {
		
		try {
			Class.forName(driver);
			String url = "jdbc:mysql://"+port+"/"+nameDb+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			dbConnection = DriverManager.getConnection(url, userName, password);
			System.out.println("conessione!");
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch!!!!!!");
			return false;
		}
			
		
	}



	/**
	 * @return the dbConnection
	 */
	public Connection getDbConnection() {
		
		boolean testC =conessione();
		System.out.println("Risultato connessione :"+testC);
		return dbConnection;
	}



	/**
	 * @param dbConnection the dbConnection to set
	 */
	public void setDbConnection(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}



	/**
	 * @return the nameDb
	 */
	public String getNameDb() {
		return nameDb;
	}



	/**
	 * @param nameDb the nameDb to set
	 */
	public void setNameDb(String nameDb) {
		this.nameDb = nameDb;
	}



	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}



	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}



	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}



	/**
	 * @param driver the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}



	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}



	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "collegamento [dbConnection=" + dbConnection + ", nameDb=" + nameDb + ", port=" + port + ", driver="
				+ driver + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	
}
