package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImpiegatoDao {
	
	
	private static Connection c = collegamento.getDbConnection();
	private static java.sql.PreparedStatement cmd = null;

	
	public ImpiegatoDao() {
		collegamento.getDbConnection();
		// TODO Auto-generated constructor stub
		
	}

	
	
	public static void main(String[] args) {

		try {

//			Date d = new Date(new java.util.Date().getTime());
			ImpiegatoDao.insert("mario");
//			RuoloDao.delete(1);
//			RuoloDao.update(2, "nuomadescrizione");
//			RuoloDao.query(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static void insert(String nome) throws SQLException {

		String updateTableSQL = "INSERT INTO impiegato(nome) VALUES(?)";

		try {

			cmd = c.prepareStatement(updateTableSQL);
			cmd.setString(1, nome);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBcorsor!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (c != null) {
				c.close();
			}

		}

	}

	public static void delete(int id) throws SQLException {

		String updateTableSQL = "DELETE FROM impiegato WHERE idmatricola = ?";

		try {
			cmd = c.prepareStatement(updateTableSQL);
			cmd.setInt(1, id);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (c != null) {
				c.close();
			}

		}

	}

	public static void update(int id, String nome) throws SQLException {

		String updateTableSQL = "UPDATE ruolo SET impiegato = ?  WHERE idmatricola = ?";

		try {

			cmd = c.prepareStatement(updateTableSQL);

			cmd.setString(1, nome);
			cmd.setInt(2, id);

			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER !");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (c != null) {
				c.close();
			}

		}

	}

	public static void query(String nome) {

		try {

			String qry = "SELECT * FROM impiegato WHERE nome= ? ";

			// Creiamo un oggetto PrepareStatement per poter interrogare il db
			PreparedStatement cmd = c.prepareStatement(qry);

			cmd.setString(1,nome);

			ResultSet res = cmd.executeQuery();

			boolean tro = res.next();// ---> la prima riga
			// --> seconda riga

			// Stampiamone i risultati riga per riga

			while (tro) {
				int idC = res.getInt("idmatricola");

				System.out.println(idC);

				System.out.println(res.getString("nome"));

				tro = res.next();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("dddddddddd");

			e.printStackTrace();
		}
	}

	
}
