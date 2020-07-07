package model;

import java.util.Date;

public class Storico {
	
	private int idstorico;
	private int idmatricola;
	private int idruolo;
	private Date datainizio;
	private Date datafine;
	/**
	 * 
	 */
	public Storico() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idstorico
	 * @param idmatricola
	 * @param idruolo
	 * @param datainizio
	 * @param datafine
	 */
	public Storico(int idstorico, int idmatricola, int idruolo, Date datainizio, Date datafine) {
		super();
		this.idstorico = idstorico;
		this.idmatricola = idmatricola;
		this.idruolo = idruolo;
		this.datainizio = datainizio;
		this.datafine = datafine;
	}
	/**
	 * @param idmatricola
	 * @param idruolo
	 * @param datainizio
	 * @param datafine
	 */
	public Storico(int idmatricola, int idruolo, Date datainizio, Date datafine) {
		super();
		this.idmatricola = idmatricola;
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
	 * @return the idmatricola
	 */
	public int getIdmatricola() {
		return idmatricola;
	}
	/**
	 * @param idmatricola the idmatricola to set
	 */
	public void setIdmatricola(int idmatricola) {
		this.idmatricola = idmatricola;
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
		return "Storico [idstorico=" + idstorico + ", idmatricola=" + idmatricola + ", idruolo=" + idruolo
				+ ", datainizio=" + datainizio + ", datafine=" + datafine + "]";
	}
	
	
	
	
}
