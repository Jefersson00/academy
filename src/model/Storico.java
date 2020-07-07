package model;

import java.sql.Date;

public class Storico {
	
	private int idstorico;
	private int matricola;
	private int idruolo;
	private Date datainizio;
	private Date datafine;
	
	public Storico() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idstorico
	 * @param matricola
	 * @param idruolo
	 * @param datainizio
	 * @param datafine
	 */
	public Storico(int idstorico, int matricola, int idruolo, Date datainizio, Date datafine) {
		super();
		this.idstorico = idstorico;
		this.matricola = matricola;
		this.idruolo = idruolo;
		this.datainizio = datainizio;
		this.datafine = datafine;
	}

	/**
	 * @return the idstorico
	 */
	public int getIdstorico() {
		return idstorico;
	}

	/**
	 * @param idstorico the idstorico to set
	 */
	public void setIdstorico(int idstorico) {
		this.idstorico = idstorico;
	}

	/**
	 * @return the matricola
	 */
	public int getMatricola() {
		return matricola;
	}

	/**
	 * @param matricola the matricola to set
	 */
	public void setMatricola(int matricola) {
		this.matricola = matricola;
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
	 * @return the datainizio
	 */
	public Date getDatainizio() {
		return datainizio;
	}

	/**
	 * @param datainizio the datainizio to set
	 */
	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}

	/**
	 * @return the datafine
	 */
	public Date getDatafine() {
		return datafine;
	}

	/**
	 * @param datafine the datafine to set
	 */
	public void setDatafine(Date datafine) {
		this.datafine = datafine;
	}

	@Override
	public String toString() {
		return "Storico [idstorico=" + idstorico + ", matricola=" + matricola + ", idruolo=" + idruolo + ", datainizio="
				+ datainizio + ", datafine=" + datafine + "]";
	}

}
