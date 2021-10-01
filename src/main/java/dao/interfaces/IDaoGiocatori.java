package dao.interfaces;

/*
giocatori/id
dettagli del giocatore singolo

giocatori/id/minutitot
minuti totali del giocatore in campo
*/

public interface IDaoGiocatori {
	
	/**
	 * returns all the informations of a player with the given id
	 * (/giocatore/*)
	 */
	String giocatore(int id);
	
	/**
	 * returns all the informations of all the player of the match with the given id
	 * (/giocatore/*)
	 */
	String giocatoriPartita(int id);
	
	/**
	 * returns all the informations of a player of the team the given id
	 * (/giocatore/*)
	 */
	String giocatoriSquadra(String nome);

}
