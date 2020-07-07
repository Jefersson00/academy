package model;

public class impiegato {
	
	private int idmatricola;
	private String nome;
	
	public impiegato() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idmatricola
	 * @param nome
	 */
	public impiegato(int idmatricola, String nome) {
		super();
		this.idmatricola = idmatricola;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "impiegato [idmatricola=" + idmatricola + ", nome=" + nome + "]";
	}

}
