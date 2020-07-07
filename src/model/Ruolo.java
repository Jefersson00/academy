package model;

public class Ruolo {
	
	
	private int idruolo;
	private String descrizione;
	
	
	public Ruolo() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param idruolo
	 * @param descrizione
	 */
	public Ruolo(int idruolo, String descrizione) {
		super();
		this.idruolo = idruolo;
		this.descrizione = descrizione;
	}
	
	/**
	 * @param descrizione
	 */
	public Ruolo(String descrizione) {
		super();
		this.descrizione = descrizione;
	}


	/**
	 * @return the idruolo
	 */
	public int getIdruolo() {
		return idruolo;
	}


	/**
	 * @param idruolo the idruolo to set
	 */
	public void setIdruolo(int idruolo) {
		this.idruolo = idruolo;
	}


	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}


	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	@Override
	public String toString() {
		return "Ruolo [idruolo=" + idruolo + ", descrizione=" + descrizione + "]";
	}
	
	
}
