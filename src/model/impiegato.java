package model;

public class impiegato {
	
	private int matricola;
	private String nome;
	private String cognome;
	private String email;
	/**
	 * 
	 */
	public impiegato() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param matricola
	 * @param nome
	 * @param cognome
	 * @param email
	 */
	public impiegato(int matricola, String nome, String cognome, String email) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	/**
	 * @param nome
	 * @param cognome
	 * @param email
	 */
	public impiegato(String nome, String cognome, String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "impiegato [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ "]";
	}
	
}
