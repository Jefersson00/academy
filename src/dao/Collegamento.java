package dao;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Collegamento {

	private DataSource ds;
	private Connection dbConnection;

	/**
	 * 
	 */
	public Collegamento() {

		super();
		try {

			ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection = ds.getConnection();
			System.out.println(dbConnection+"test db ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("errore db connection");
			// TODO: handle exception
		}
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the ds
	 */
	public DataSource getDs() {
		return ds;
	}

	/**
	 * @param ds the ds to set
	 */
	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	/**
	 * @return the dbConnection
	 */
	public Connection getDbConnection() {
		return dbConnection;
	}

	/**
	 * @param dbConnection the dbConnection to set
	 */
	public void setDbConnection(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}

	

}
