package academyR;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EsempioJDBC {

	public EsempioJDBC() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {

		try {
			
			
			
//			Date d = new Date(new java.util.Date().getTime());
			EsempioJDBC.insert(01, "nome");
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public static void insert(int mat, String nom) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String updateTableSQL = "INSERT INTO impiegato(matricola, nome) VALUES(?,?)";

		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3305/corsor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "MariaLocalDB");

	

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, mat);
			cmd.setString(2, nom);

			// execute update SQL stetement
		    cmd.executeUpdate();
			
			

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	

}











