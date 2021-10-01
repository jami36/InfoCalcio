package dao.classes;

import entities.Giocatore;
import entities.Partita;
import entities.Squadra;

public class DaoAdminModifica extends BasicDao {
	
	public DaoAdminModifica(String dbAddress) {
		super(dbAddress);
	}
	
	public DaoAdminModifica() {}
	
	public String modificaGiocatore(Giocatore giocatore) {
		String ris = "";
		
		ris = execute("UPDATE giocatori SET nome = ?, cognome = ?, ddn = ?, ruolo = ?, numero = ? WHERE id = ?",
				giocatore.getNome(),
				giocatore.getCognome(),
				giocatore.getDdn(),
				giocatore.getRuolo(),
				giocatore.getNumero(),
				giocatore.getId()
				);
		
		return ris;
	}
	
	public String modificaPartita(Partita partita) {
		String ris = "";
		partita.setPossesso_Palla();
		
		ris = execute("UPDATE partite SET dataincontro = ?, durata = ?, possesso_palla = ?, palicasa = ?, tiricasa = ?, giallicasa = ?, rossicasa = ?, punizionicasa = ?, rigoricasa = ?,"
				+ " paliospite = ?, tiriospite = ?, gialliospite = ?, rossiospite = ?, punizioniospite = ?, rigoriospite = ? WHERE id = ?",
				partita.getDataincontro(),
				partita.getDurata(),
				partita.getPossesso_palla(),
				partita.getPaliCasa(),
				partita.getTiriCasa(),
				partita.getGialliCasa(),
				partita.getRossiCasa(),
				partita.getPunizioniCasa(),
				partita.getRigoriCasa(),
				partita.getPaliOspite(),
				partita.getTiriOspite(),
				partita.getGialliOspite(),
				partita.getRossiOspite(),
				partita.getPunizioniOspite(),
				partita.getRigoriOspite(),
				partita.getId()
				);
		
		return ris;
	}
	
	public String modificaSquadra(Squadra squadra) {
		String ris = "";
		
		ris = execute("UPDATE squadre SET nazione = ?, citta = ? WHERE nome = ?",
				squadra.getNazione(),
				squadra.getCitta(),
				squadra.getNome()
				);
		
		return ris;
	}

}
