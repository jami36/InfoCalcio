package dao.interfaces;

/*
partite/id
dettagli della partita

partite/id/gols
lista gol di una partita

partite/id/giocatori
tutti i giocatori che hanno partecipato a una partita 

partite/id/squadre
squadre che hanno partecipato a una partita
*/

public interface IDaoPartite {
	
	/**
	 * returns the information of the match with the given id
	 * (/partite/*)
	 */
	String partita(int id);
	
	/**
	 * returns all the matches
	 * (/partite)
	 */
	String partite();
	
	/**
	 * return all the matches of the competition with the given id
	 * (/partite/campionati/*)
	 */
	String partiteCompetizione(int id);
	
	/**
	 * return all the matches of the team with the given id
	 * (/partite/squadre/*)
	 */
	String partiteSquadra(String idSquadra);


}
