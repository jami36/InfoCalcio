package dao.interfaces;

public interface IDaoSquadre {
	
	/**
	 * returns all the information of the team with the given name
	 * (/squadre/*)
	 */
	String squadra(String nome);
	
	/**
	 * returns all the information of the teams in the competition with the given id
	 * (/squadre/campionati/id)
	 */
	String squadre(int id);

}
