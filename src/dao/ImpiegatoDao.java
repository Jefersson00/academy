package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import model.Impiegato;
import model.Ruolo;

public class ImpiegatoDao extends Collegamento {
	
	

	private java.sql.PreparedStatement cmd = null;
	private Connection c = getDbConnection();

	
	public ImpiegatoDao() {

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


	public boolean insert(String nome,String cognome,String email) throws SQLException {

		String updateTableSQL = "INSERT INTO impiegato(nome,cognome,email) VALUES(?,?,?)";

		try {

			cmd = c.prepareStatement(updateTableSQL);
			cmd.setString(1, nome);
			cmd.setString(1, cognome);
			cmd.setString(1, email);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("insert impiegato Db!");
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

		String updateTableSQL = "DELETE FROM impiegato WHERE matricola = ?";

		try {
			cmd = c.prepareStatement(updateTableSQL);
			cmd.setInt(1, id);

			Optional<Impiegato> temp = getbyId(id);
			if (temp.isPresent()) {
				System.out.println("Delete Ruolo Db");
				cmd.executeUpdate();
				if (Optional.of(getbyId(id).get()).isEmpty()) {
					System.out.println("eliminato corretamente");

					return true;
				} else {
					System.out.println("non eliminato");

					return false;
				}
			} else {

				System.out.println("elemento non trovato ");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" catch :errore durante la delete ");
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
	
	
	public Optional<Impiegato> getbyId(int id) {

		Optional<Impiegato> tmpImpiegatoOptional = Optional.empty();

		try {

			String qry = "SELECT * FROM impiegato WHERE matricola= ? ";

			PreparedStatement cmd = c.prepareStatement(qry);
			cmd.setInt(1, id);
			System.out.println("arriva");
			ResultSet res = cmd.executeQuery();
			boolean tro = res.next();
			System.out.println(res.getRow());
			System.out.println("arriva2");
			if (res.getRow() == 1) {
				System.out.println(res.getInt("matricola") + "!!!!!!!!!!!!!" + res.getString("nome")+ "!!!!!!!!!!!!!" + res.getString("cognome")+ "!!!!!!!!!!!!!" + res.getString("email"));
				Impiegato impiegatoTmp = new Impiegato(res.getInt("matricola"), res.getString("nome"), res.getString("cognome"), res.getString("email"));
				tmpImpiegatoOptional = Optional.of(impiegatoTmp);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("cccc");

			e.printStackTrace();
		}
		return tmpImpiegatoOptional;
	}

	
	
}
