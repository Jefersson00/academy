package dao;

import java.sql.SQLException;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Ruolo;

public class RuoloDao extends Collegamento {

	private java.sql.PreparedStatement cmd = null;
	private Connection c = getDbConnection();

	public RuoloDao() {
		// TODO Auto-generated constructor stub
	}
//
//	public static void main(String[] args) {
//
//		try {
//
////			Date d = new Date(new java.util.Date().getTime());
////			RuoloDao.insert("nome");
////			RuoloDao.delete(1);
////			RuoloDao.update(2, "nuomadescrizione");
//			RuoloDao.query(2);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	public boolean insert(String descrizione) throws SQLException {

		String updateTableSQL = "INSERT INTO ruolo(descrizione) VALUES(?)";

		try {

			cmd = getDbConnection().prepareStatement(updateTableSQL);
			cmd.setString(1, descrizione);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("insert Ruolo Db");
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (c != null) {
				c.close();
			}

		}

	}

	public boolean delete(int id) throws SQLException {

		String updateTableSQL = "DELETE FROM ruolo WHERE idruolo = ?";
		
		try {
			cmd = c.prepareStatement(updateTableSQL);
			cmd.setInt(1, id);
			// execute update SQL stetement
			cmd.executeUpdate();
			
			Optional<Ruolo> temp =Optional.of(getbyId(id).get());
			if(temp.isEmpty()) {
				System.out.println("Delete Ruolo Db");
				return true;
			}
			else {
				
				System.out.println("Delete Ruolo Db false errore");
				return false;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" catch :errore durante la delete ");
			return false;
		} 
		finally {

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

	public static void getAll(int id) {

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

	public Optional<Ruolo> getbyId(int id) {

		Optional<Ruolo> tmpRuoloOptional = Optional.empty();

		try {

			String qry = "SELECT * FROM ruolo WHERE idruolo= ? ";

			PreparedStatement cmd = c.prepareStatement(qry);

			cmd.setInt(1, id);

			ResultSet res = cmd.executeQuery();

			tmpRuoloOptional = Optional.of(new Ruolo(res.getInt("idruolo"), res.getString("descrizione")));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("dddddddddd");

			e.printStackTrace();
		}
		return tmpRuoloOptional;
	}

}
