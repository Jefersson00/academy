package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Ruolo;

public class RuoloDao {
	
	Collegamento tmpC=new Collegamento(); 
	private java.sql.PreparedStatement cmd = null;
//	private Connection c = getDbConnection();
	private Connection c = tmpC.getDbConnection();

	public RuoloDao() {
		// TODO Auto-generated constructor stub
	}

	public boolean insert(String descrizione) {

		String updateTableSQL = "INSERT INTO ruolo(descrizione) VALUES(?)";

		try {

			cmd = c.prepareStatement(updateTableSQL);
			cmd.setString(1, descrizione);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("insert Ruolo Db");
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(int id) {

		String updateTableSQL = "DELETE FROM ruolo WHERE idruolo = ?";

		try {
			cmd = c.prepareStatement(updateTableSQL);
			cmd.setInt(1, id);
			// execute update SQL stetement

			Optional<Ruolo> temp = getbyId(id);
			if (temp.isPresent()) {
				System.out.println("Delete Ruolo Db");
				cmd.executeUpdate();
				if (getbyId(id).isEmpty()) {
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
		}

	}

	public Optional<Ruolo> update(int idRuolo, String desc) {

		Optional<Ruolo> tmpRuoloOptional = Optional.empty();
		String updateTableSQL = "UPDATE ruolo SET descrizione = ?  WHERE idruolo = ?";

		try {
			Optional<Ruolo> tmpTest = Optional.of(new Ruolo(idRuolo, desc));
			if (tmpTest.isPresent()) {

				cmd = c.prepareStatement(updateTableSQL);
				cmd.setString(1, desc);
				cmd.setInt(2, idRuolo);

				cmd.executeUpdate();

				tmpRuoloOptional = Optional.of(getbyId(idRuolo).get());
				System.out.println("Record is updated to DBUSER !");

			} else {
				System.out.println("Ruolo by id " + idRuolo + "isnt present ");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return tmpRuoloOptional;

	}

	public List<Ruolo> getAll() {
		List<Ruolo> listaImpiegati = new ArrayList<Ruolo>();

		try {

			String qry = "SELECT * FROM ruolo ";
			PreparedStatement cmd = c.prepareStatement(qry);
			ResultSet res = cmd.executeQuery();
			boolean tro = res.next();
			while (tro) {
				Ruolo tmp = new Ruolo();
				System.out.println(res.getInt("idruolo"));
				tmp.setIdruolo(res.getInt("idruolo"));
				tmp.setDescrizione(res.getString("descrizione"));
				System.out.println(res.getString("descrizione"));
				System.out.println(tmp.toString());
				listaImpiegati.add(tmp); // aggiungo un impiegato alla lista
				tro = res.next();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("dddddddddd");

			e.printStackTrace();
		}
		return listaImpiegati;
	}

	public Optional<Ruolo> getbyId(int id) {

		Optional<Ruolo> tmpRuoloOptional = Optional.empty();

		try {

			String qry = "SELECT * FROM ruolo WHERE idruolo= ? ";

			PreparedStatement cmd = c.prepareStatement(qry);
			cmd.setInt(1, id);
			System.out.println("arriva");
			ResultSet res = cmd.executeQuery();
			boolean tro = res.next();
			System.out.println(res.getRow());
			System.out.println("arriva2");
			if (res.getRow() == 1) {
				System.out.println(res.getInt("idruolo") + "!!!!!!!!!!!!!" + res.getString("descrizione"));
				Ruolo ruoloTemp = new Ruolo(res.getInt("idruolo"), res.getString("descrizione"));
				tmpRuoloOptional = Optional.of(ruoloTemp);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("cccc");

			e.printStackTrace();
		}
		return tmpRuoloOptional;
	}
//
//	public static void main(String[] args) {
//
//		try {
//			RuoloDao t = new RuoloDao();
//
//			boolean testProva = t.insert("ciaciaciaciaci");
//			System.out.println(testProva);
////			Optional<Ruolo> tmp = t.update(8, "ged");
////			System.out.println(tmp.toString());
////			System.out.println(testProva);
////			System.out.println(t.delete(7));
////			List<Ruolo> d = t.getAll();
////			System.out.println(d.toString());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

//	DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
//	Connection con = ds.getConnection();
}
