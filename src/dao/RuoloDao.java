package dao;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Ruolo;

public class RuoloDao {

	private static Connection c = collegamento.getDbConnection();
	private static java.sql.PreparedStatement cmd = null;

	public RuoloDao() {
		// TODO Auto-generated constructor stub

	}

	public static void main(String[] args) {

		try {

//			Date d = new Date(new java.util.Date().getTime());
//			RuoloDao.insert("nome");
//			RuoloDao.delete(1);
//			RuoloDao.update(2, "nuomadescrizione");
			RuoloDao.query(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insert(String descrizione) throws SQLException {

		String updateTableSQL = "INSERT INTO ruolo(descrizione) VALUES(?)";

		try {

			cmd = c.prepareStatement(updateTableSQL);
			cmd.setString(1, descrizione);

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

		String updateTableSQL = "DELETE FROM ruolo WHERE idruolo = ?";

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

	public static void update(int idruolo, String desc) throws SQLException {

		String updateTableSQL = "UPDATE ruolo SET descrizione = ?  WHERE idruolo = ?";

		try {

			cmd = c.prepareStatement(updateTableSQL);

			cmd.setString(1, desc);
			cmd.setInt(2, idruolo);

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

	public static void query(int id) {

		try {

			String qry = "SELECT * FROM ruolo WHERE idruolo= ? ";

			// Creiamo un oggetto PrepareStatement per poter interrogare il db
			PreparedStatement cmd = c.prepareStatement(qry);

			cmd.setInt(1, id);

			ResultSet res = cmd.executeQuery();

			boolean tro = res.next();// ---> la prima riga
			// --> seconda riga

			// Stampiamone i risultati riga per riga

			while (tro) {
				int idC = res.getInt("idruolo");

				System.out.println(idC);

				System.out.println(res.getString("descrizione"));

				tro = res.next();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("dddddddddd");

			e.printStackTrace();
		}
	}

}
