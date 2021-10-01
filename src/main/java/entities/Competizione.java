package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matteo
 * designs the basical structure to represent the Competizione
 */
public class Competizione extends Entity {
	
	/**
	 * The name of the competition
	 */
	String nome;
	
	/**
	 * The country of the competition
	 */
	String paese;
	
	/**
	 * The type of the competition
	 */
	String tipo;
	
	List<String> squadre = new ArrayList<>();
	
	public Competizione() {}


	/** full fields Contructor
	 * 
	 * @param id
	 * @param nome
	 * @param nazione
	 * @param citta
	 * @param giocatori
	 *
	 */
	public Competizione(int id, String nome, String paese, String tipo) {
		super(id);
		this.nome = nome;
		this.paese = paese;
		this.tipo = tipo;
	}
	
	public Competizione(int id, String nome, String paese, String tipo, List<String> squadre) {
		super(id);
		this.nome = nome;
		this.paese = paese;
		this.tipo = tipo;
		this.squadre = squadre;
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
	 * @return the paese
	 */
	public String getPaese() {
		return paese;
	}

	/**
	 * @param paese the paese to set
	 */
	public void setPaese(String paese) {
		this.paese = paese;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	/**
	 * @return the squadre
	 */
	public List<String> getSquadre() {
		return squadre;
	}


	/**
	 * @param squadre the squadre to set
	 */
	public void setSquadre(List<String> squadre) {
		this.squadre = squadre;
	}
	
	


}
