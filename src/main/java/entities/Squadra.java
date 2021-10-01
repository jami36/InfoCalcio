package entities;

import java.util.ArrayList;
import java.util.List;

import utility.IMappablePro;

/*
squadre/
lista squadre nel db

squadre/id
dettagli di una squadra

squadra/id/
lista di giocatori di una squadra
*/

/**
 * @author Matteo
 * defines a specific representation of the object : @Squadra
 */
public class Squadra implements IMappablePro {
	
	/**
	 * the Team's name
	 */
	private String nome;
	
	/** 
	 * the Team's country
	 */
	private String nazione;
	
	/** 
	 * the Team's City
	 */
	private String citta;
	
	/**
	 * the Team's points
	 */
	private int punti;
	
	/**
	 * the Team's competitions name
	 */
	private List<String> competizioni = new ArrayList<>();
	
	public Squadra() {}
	
	public Squadra(String nome, String nazione, String citta, int punti, List<String> competizioni) {
		super();
		this.nome = nome;
		this.nazione = nazione;
		this.citta = citta;
		this.punti = punti;
		this.competizioni = competizioni;
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
	 * @return the nazione
	 */
	public String getNazione() {
		return nazione;
	}

	/**
	 * @param nazione the nazione to set
	 */
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	/**
	 * @return the citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * @param citta the citta to set
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}

	/**
	 * @return the punti
	 */
	public int getPunti() {
		return punti;
	}

	/**
	 * @param punti the punti to set
	 */
	public void setPunti(int punti) {
		this.punti = punti;
	}

	/**
	 * @return the competizioni
	 */
	public List<String> getCompetizioni() {
		return competizioni;
	}

	/**
	 * @param competizioni the competizioni to set
	 */
	public void setCompetizioni(List<String> competizioni) {
		this.competizioni = competizioni;
	}
	
	
}
