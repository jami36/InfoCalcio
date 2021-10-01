package entities;

import java.util.List;

/*
partite/id
dettagli della partita

partite/id/gols
lista gol di una partita

partite/id/giocatoricasa
tutti i giocatori che hanno partecipato a una partita in casa

partite/id/giocatoritrasferta
tutti i giocatori che hanno partecipato a una partita in trasferta

partite/squadra

partite/id/squadre
squadre che hanno partecipato a una partita
*/

/**@author Davide Ongaro
 * 
 * this class represents One specific Match in a specific Championship/Competition
 * 
 * an instance of @Partita contains all the schedule informations about the match
 */
public class Partita extends Entity {
	
	/** 
	 * represents the Home Team in the match
	 */
	private String casa;

	/**
	 * represents the Foreign Team in the match
	 */
	private String ospite;
	
	/**
	 * represents the Date where the Match is played
	 */
	private String dataincontro;
	
	private int idcompetizione;
	
	/** 
	 * represents the Championship/Competition under the match is played
	 */
	private String competizione;
	
	/**
	 *represents all the Gols marked in this Match 
	 */
	private List<Gol> gols;
	
	/**
	 * represents the min valued duration of this match
	 */
	private int durata;
	
	private int possesso_palla;
	
	public String possessoCasa;
	
	public String possessoOspite;
	
	private int gialliCasa;
	
	private int rossiCasa;
	
	private int tiriCasa;
	
	private int paliCasa;
	
	private int punizioniCasa;
	
	private int rigoriCasa;
	
	private int gialliOspite;
	
	private int rossiOspite;
	
	private int tiriOspite;
	
	private int paliOspite;
	
	private int punizioniOspite;
	
	private int rigoriOspite;
	
	private String risultato;
	
	public Partita() {}

	

	public Partita(int id, String casa, String ospite, String dataincontro, int idcompetizione, String competizione, List<Gol> gols,
			int durata, int possesso, int gialliCasa, int rossiCasa, int tiriCasa,
			int paliCasa, int punizioniCasa, int rigoriCasa, int gialliOspite, int rossiOspite, int tiriOspite,
			int paliOspite, int punizioniOspite, int rigoriOspite, String risultato) {
		super(id);
		this.casa = casa;
		this.ospite = ospite;
		this.dataincontro = dataincontro;
		this.idcompetizione = idcompetizione;
		this.competizione = competizione;
		this.gols = gols;
		this.durata = durata;
		this.gialliCasa = gialliCasa;
		this.rossiCasa = rossiCasa;
		this.tiriCasa = tiriCasa;
		this.paliCasa = paliCasa;
		this.punizioniCasa = punizioniCasa;
		this.rigoriCasa = rigoriCasa;
		this.gialliOspite = gialliOspite;
		this.rossiOspite = rossiOspite;
		this.tiriOspite = tiriOspite;
		this.paliOspite = paliOspite;
		this.punizioniOspite = punizioniOspite;
		this.rigoriOspite = rigoriOspite;
		this.risultato = risultato;
	}



	/**
	 * @return the casa
	 */
	public String getCasa() {
		return casa;
	}



	/**
	 * @param casa the casa to set
	 */
	public void setCasa(String casa) {
		this.casa = casa;
	}



	/**
	 * @return the ospite
	 */
	public String getOspite() {
		return ospite;
	}



	/**
	 * @param ospite the ospite to set
	 */
	public void setOspite(String ospite) {
		this.ospite = ospite;
	}



	/**
	 * @return the dataincontro
	 */
	public String getDataincontro() {
		return dataincontro;
	}



	/**
	 * @param dataincontro the dataincontro to set
	 */
	public void setDataincontro(String dataincontro) {
		this.dataincontro = dataincontro;
	}



	/**
	 * @return the competizione
	 */
	public String getCompetizione() {
		return competizione;
	}



	/**
	 * @param competizione the competizione to set
	 */
	public void setCompetizione(String competizione) {
		this.competizione = competizione;
	}



	/**
	 * @return the gols
	 */
	public List<Gol> getGols() {
		return gols;
	}



	/**
	 * @param gols the gols to set
	 */
	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}



	/**
	 * @return the durata
	 */
	public int getDurata() {
		return durata;
	}



	/**
	 * @param durata the durata to set
	 */
	public void setDurata(int durata) {
		this.durata = durata;
	}



	/**
	 * @return the possesso_palla
	 */
	public int getPossesso_palla() {
		return possesso_palla;
	}



	/**
	 * @param possesso_palla the possesso_palla to set
	 */
	public void setPossesso_palla(int possesso_palla) {
		this.possesso_palla = possesso_palla;
	}


	/**
	 * @return the gialliCasa
	 */
	public int getGialliCasa() {
		return gialliCasa;
	}



	/**
	 * @param gialliCasa the gialliCasa to set
	 */
	public void setGialliCasa(int gialliCasa) {
		this.gialliCasa = gialliCasa;
	}



	/**
	 * @return the rossiCasa
	 */
	public int getRossiCasa() {
		return rossiCasa;
	}



	/**
	 * @param rossiCasa the rossiCasa to set
	 */
	public void setRossiCasa(int rossiCasa) {
		this.rossiCasa = rossiCasa;
	}



	/**
	 * @return the tiriCasa
	 */
	public int getTiriCasa() {
		return tiriCasa;
	}



	/**
	 * @param tiriCasa the tiriCasa to set
	 */
	public void setTiriCasa(int tiriCasa) {
		this.tiriCasa = tiriCasa;
	}



	/**
	 * @return the paliCasa
	 */
	public int getPaliCasa() {
		return paliCasa;
	}



	/**
	 * @param paliCasa the paliCasa to set
	 */
	public void setPaliCasa(int paliCasa) {
		this.paliCasa = paliCasa;
	}



	/**
	 * @return the punizioniCasa
	 */
	public int getPunizioniCasa() {
		return punizioniCasa;
	}



	/**
	 * @param punizioniCasa the punizioniCasa to set
	 */
	public void setPunizioniCasa(int punizioniCasa) {
		this.punizioniCasa = punizioniCasa;
	}



	/**
	 * @return the rigoriCasa
	 */
	public int getRigoriCasa() {
		return rigoriCasa;
	}



	/**
	 * @param rigoriCasa the rigoriCasa to set
	 */
	public void setRigoriCasa(int rigoriCasa) {
		this.rigoriCasa = rigoriCasa;
	}



	/**
	 * @return the gialliOspite
	 */
	public int getGialliOspite() {
		return gialliOspite;
	}



	/**
	 * @param gialliOspite the gialliOspite to set
	 */
	public void setGialliOspite(int gialliOspite) {
		this.gialliOspite = gialliOspite;
	}



	/**
	 * @return the rossiOspite
	 */
	public int getRossiOspite() {
		return rossiOspite;
	}



	/**
	 * @param rossiOspite the rossiOspite to set
	 */
	public void setRossiOspite(int rossiOspite) {
		this.rossiOspite = rossiOspite;
	}



	/**
	 * @return the tiriOspite
	 */
	public int getTiriOspite() {
		return tiriOspite;
	}



	/**
	 * @param tiriOspite the tiriOspite to set
	 */
	public void setTiriOspite(int tiriOspite) {
		this.tiriOspite = tiriOspite;
	}



	/**
	 * @return the paliOspite
	 */
	public int getPaliOspite() {
		return paliOspite;
	}



	/**
	 * @param paliOspite the paliOspite to set
	 */
	public void setPaliOspite(int paliOspite) {
		this.paliOspite = paliOspite;
	}



	/**
	 * @return the punizioniOspite
	 */
	public int getPunizioniOspite() {
		return punizioniOspite;
	}



	/**
	 * @param punizioniOspite the punizioniOspite to set
	 */
	public void setPunizioniOspite(int punizioniOspite) {
		this.punizioniOspite = punizioniOspite;
	}



	/**
	 * @return the rigoriOspite
	 */
	public int getRigoriOspite() {
		return rigoriOspite;
	}



	/**
	 * @param rigoriOspite the rigoriOspite to set
	 */
	public void setRigoriOspite(int rigoriOspite) {
		this.rigoriOspite = rigoriOspite;
	}



	/**
	 * @return the risultato
	 */
	public String getRisultato() {
		return risultato;
	}



	/**
	 * @param risultato the risultato to set
	 */
	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}
	
	
	
	/**
	 * @return the idcompetizione
	 */
	public int getIdcompetizione() {
		return idcompetizione;
	}



	/**
	 * @param idcompetizione the idcompetizione to set
	 */
	public void setIdcompetizione(int idcompetizione) {
		this.idcompetizione = idcompetizione;
	}

	public void setPossesso_Palla() {
		this.possesso_palla = Integer.parseInt(this.possessoCasa.substring(0, possessoCasa.length()-1));
	}

	public void setPossessoCasa() {
		this.possessoCasa = possesso_palla + "%";
	}
	
	public void setPossessoOspite() {
		this.possessoOspite = (100 - possesso_palla) + "%";
	}
	
	
	
}
