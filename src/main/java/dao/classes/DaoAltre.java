package dao.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.interfaces.IDaoAltre;
import entities.Competizione;
import entities.Contratto;
import entities.Giocatore;
import entities.Gol;
import utility.IMappablePro;


public class DaoAltre extends BasicDao implements IDaoAltre {

	public DaoAltre(String dbAddress) {
		super(dbAddress);
	}
	
	public DaoAltre() {
	}

	@Override
	public String campionati() {
		List<Competizione> ris = new ArrayList<>();		
		List<Map<String, String>> maps = getAll("SELECT * FROM competizioni");
		
		for(Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Competizione.class, map));
		}
		
		return gson.toJson(ris);
	}

	@Override
	public String giocatore(int id) {
		List<String> contratti = new ArrayList<>();
		Giocatore giocatore = (IMappablePro.fromMap(Giocatore.class, getOne("SELECT * FROM giocatori WHERE id = ?", id)));
		List<Map<String, String>> maps = getAll("SELECT * FROM contratti WHERE idgiocatore = ?", id);
		System.out.println(maps.isEmpty());
		for(Map<String, String> map : maps) {
			Contratto contratto = IMappablePro.fromMap(Contratto.class, map);
			System.out.println(contratto.toString());
			contratti.add(contratto.toString());
		}
		giocatore.setContratti(contratti);
		return gson.toJson(giocatore);
		
	}
	
	@Override
	public String gols(int id) {
		List<Gol> ris = new ArrayList<>();		
		List<Map<String, String>> maps = getAll("SELECT *, nome_squadra as squadra FROM gols_dettagli WHERE id_partita = ?", id);
		
		for(Map<String, String> map : maps) {
			Gol gol = (IMappablePro.fromMap(Gol.class, map));
			gol.setDettaglio(gol.getDettaglio());
			ris.add(gol);
		}
		
		return gson.toJson(ris);
	}

	@Override
	public String giocatoriPartita(int id) {
		List<Giocatore> ris = new ArrayList<>();
		List<Map<String, String>> maps = getAll("SELECT giocatori.* FROM giocatori JOIN partite WHERE (partite.casa = giocatori.squadra OR partite.ospite = giocatori.squadra) AND partite.id = ?", id);
		
		for(Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Giocatore.class, map));;
		}
		
		return gson.toJson(ris);
	}

	@Override
	public String giocatoriSquadra(String nome) {
		List<Giocatore> ris = new ArrayList<>();
		List<Map<String, String>> maps = getAll("select * from giocatori where squadra = ?", nome);
		
		for(Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Giocatore.class, map));;
		}
		
		return gson.toJson(ris);
	}
	
	

}
