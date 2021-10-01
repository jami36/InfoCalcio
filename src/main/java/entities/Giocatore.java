package entities;

import java.util.List;
/**
 * @author Davide, Matteo
 * designs the basical structure to represent the Giocatore
 */
public class Giocatore extends Entity {

	/** 
	 * the name of the player
	 */
	private String nome;
	
	/**
	 *  the surname of the player
	 */
	private String cognome;
	
	/**
	 * the date of birth
	 */
	private String ddn;
	
	/**
	 * The Team where this player plays
	 */
	private String squadra;
	
	/**
	 * the ruolo of this player
	 */
	private String ruolo;
	
	/**
	 * the number of this player
	 */
	private int numero;
	
	/**
	 * the list of old engagements with other teams
	 */
	private List<String> contratti;
	
	/**
	 * the career gols of this player
	 */
	private int gols;
	
	/**
	 * the number of parate of this player
	 */
	private int parate;
	
	public Giocatore() {}
	
	/**
	 * Full Fields constructor
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param data
	 * @param squadra
	 * @param contratti
	 * @param gols
	 */
	public Giocatore(int id, String nome, String cognome, String ddn, String squadra, String ruolo, int numero,
			List<String> contratti, int gols, int parate) {
		super(id);
		this.nome = nome;
		this.cognome = cognome;
		this.ddn = ddn;
		this.squadra = squadra;
		this.ruolo = ruolo;
		this.numero = numero;
		this.contratti = contratti;
		this.gols = gols;
		this.parate = parate;
	}
	
	/**
	 * the without- lists (engagement / gols / parate ) Constructor
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param data
	 * @param squadra
	 */
	public Giocatore(int id, String nome, String cognome, String ddn, String squadra, String ruolo, int numero) {
		super(id);
		this.nome = nome;
		this.cognome = cognome;
		this.ddn = ddn;
		this.squadra = squadra;
		this.ruolo = ruolo;
		this.numero = numero;
		
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
	 * @return the ddn
	 */
	public String getDdn() {
		return ddn;
	}

	/**
	 * @param ddn the ddn to set
	 */
	public void setDdn(String ddn) {
		this.ddn = ddn;
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
	 * @return the ruolo
	 */
	public String getRuolo() {
		return ruolo;
	}

	/**
	 * @param ruolo the ruolo to set
	 */
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the contratti
	 */
	public List<String> getContratti() {
		return contratti;
	}

	/**
	 * @param contratti the contratti to set
	 */
	public void setContratti(List<String> contratti) {
		this.contratti = contratti;
	}

	/**
	 * @return the gols
	 */
	public int getGols() {
		return gols;
	}

	/**
	 * @param gols the gols to set
	 */
	public void setGols(int gols) {
		this.gols = gols;
	}

	/**
	 * @return the parate
	 */
	public int getParate() {
		return parate;
	}

	/**
	 * @param parate the parate to set
	 */
	public void setParate(int parate) {
		this.parate = parate;
	}
		
	
}
