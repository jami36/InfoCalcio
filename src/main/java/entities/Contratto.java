package entities;

import java.time.LocalDate;

/**
 * @author Matteo
 * designs the basical structure to represent the Contratto
 */
public class Contratto extends Entity {
	
	/**
	 * the time rappresenting the start of the contract
	 */
	private String inizio;
	
	/**
	 * the time rappresenting the end of the contract
	 */
	private String fine;
	
	/**
	 * the team who signed the contract
	 */
	private String squadra;
	
	private int idgiocatore;
	
	public Contratto() {}
	
	/** full fields Contructor
	 * 
	 * @param id
	 * @param inizio
	 * @param fine
	 * @param squadra
	 *
	 */
	public Contratto(int id, String inizio, String fine, String squadra, int idgiocatore) {
		super(id);
		this.inizio = inizio;
		this.fine = fine;
		this.squadra = squadra;
		this.idgiocatore = idgiocatore;
	}

	/**
	 * @return the inizio
	 */
	public String getInizio() {
		return inizio;
	}

	/**
	 * @param inizio the inizio to set
	 */
	public void setInizio(String inizio) {
		this.inizio = inizio;
	}

	/**
	 * @return the fine
	 */
	public String getFine() {
		return fine;
	}

	/**
	 * @param fine the fine to set
	 */
	public void setFine(String fine) {
		this.fine = fine;
	}

	/**
	 * @return the squadra
	 */
	public String getSquadra() {
		return squadra;
	}

	/**
	 * @param squadra the squadra to set
	 */
	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	/**
	 * @return the idgiocatore
	 */
	public int getIdgiocatore() {
		return idgiocatore;
	}

	/**
	 * @param idgiocatore the idgiocatore to set
	 */
	public void setIdgiocatore(int idgiocatore) {
		this.idgiocatore = idgiocatore;
	}

	public String toString() {
		return "Squadra: " + this.squadra + " Data inizio: " + this.inizio + " Data fine: " + this.fine + "";
	}
	
	
}
