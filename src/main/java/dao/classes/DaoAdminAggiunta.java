package dao.classes;

import java.util.List;

import entities.Competizione;
import entities.Contratto;
import entities.Giocatore;
import entities.Gol;
import entities.Partita;
import entities.Squadra;

public class DaoAdminAggiunta extends BasicDao {
	
	public DaoAdminAggiunta(String dbAddress) {
		super(dbAddress);
	}
	
	public DaoAdminAggiunta() {}
	
	public String addCompetizione(List<Competizione> competizioni) {
		String ris = "";
		for(Competizione competizione : competizioni) {
			ris = execute("Insert into competizioni (nome, paese, tipo) values (?, ?, ?)", 
					competizione.getNome(),
					competizione.getPaese(),
					competizione.getTipo()
					);
			
		}
		return ris;
	}
	
	public String addSquadre(List<Squadra> squadre) {
		String ris = "";
		for(Squadra squadra : squadre) {
			ris = execute("Insert into squadre (nome, punti, citta, nazione) values (?, ?, ?, ?)", 
					squadra.getNome(),
					squadra.getPunti(),
					squadra.getCitta(),
					squadra.getNazione()
					);
		}
		return ris;
	}
	
	public String addCompetizioniSquadre(List<Competizione> competizioni) {
		String ris = "";
		for(Competizione competizione : competizioni) {
			List<String> squadre = competizione.getSquadre();
			for(String squadra : squadre) {
				ris = execute("Insert into competizione_squadre (nome_squadra, id_campionato) values (?, ?)", 
						squadra,
						competizione.getId()
						);
			}
		}
		return ris;
	}
	
	public String addPartite(List<Partita> partite) {
		String ris = "";
		for(Partita partita : partite) {
			ris = execute("Insert into partite (dataincontro, casa, ospite, id_competizione, durata, possesso_palla, tiricasa, tiriospite, palicasa, paliospite, giallicasa, gialliospite, rossicasa,"
					+ "rossiospite, punizionicasa, punizioniospite, rigoricasa, rigoriospite) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
					partita.getDataincontro(),
					partita.getCasa(),
					partita.getOspite(),
					partita.getIdcompetizione(),
					partita.getDurata(),
					partita.getPossesso_palla(),
					partita.getTiriCasa(),
					partita.getTiriOspite(),
					partita.getPaliCasa(),
					partita.getPaliOspite(),
					partita.getGialliCasa(),
					partita.getGialliOspite(),
					partita.getRossiCasa(),
					partita.getRossiOspite(),
					partita.getPunizioniCasa(),
					partita.getPunizioniOspite(),
					partita.getRigoriCasa(),
					partita.getRigoriOspite()
					);
		}
		return ris;
		
	}
	
	public String addGiocatori(List<Giocatore> giocatori) {
		String ris = "";
		for(Giocatore giocatore : giocatori) {
			ris = execute("Insert into giocatori (nome, cognome, ddn, squadra, ruolo, numero) values (?, ?, ?, ?, ?, ?)", 
					giocatore.getNome(),
					giocatore.getCognome(),
					giocatore.getDdn(),
					giocatore.getSquadra(),
					giocatore.getRuolo(),
					giocatore.getNumero()
			);
		}
		return ris;
	}
	
	public String addGols(List<Gol> gols) {
		String ris = "";
		for(Gol gol : gols) {
			ris = execute("INSERT INTO gols (id_giocatore, id_assistman, nome_squadra, minuto, rigore, punizione, autogol, ditesta, rovesciata, piede, id_partita) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
					gol.getId_realizzatore(),
					gol.getId_assistman(),
					gol.getNome_squadra(),
					gol.getMinuto(),
					gol.isRigore(),
					gol.isPunizione(),
					gol.isAutogol(),
					gol.isDiTesta(),
					gol.isRovesciata(),
					gol.isPiede(),
					gol.getId_partita()
			);
		}
		return ris;
	}
	
	public String addContratti(List<Contratto> contratti) {
		String ris = "";
		for(Contratto contratto : contratti) {
			ris = execute("INSERT INTO contratti (inizio, fine, idgiocatore, squadra) VALUES(?, ?, ?, ?)",
					contratto.getInizio(),
					contratto.getFine(),
					contratto.getIdgiocatore(),
					contratto.getSquadra()
			);
		}
		return ris;
		
	}

}
