package dao.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.interfaces.IDaoPartite;
import entities.Partita;
import utility.IMappablePro;

public class DaoPartite extends BasicDao implements IDaoPartite {

	public DaoPartite(String dbAddress) {
		super(dbAddress);
	}

	public DaoPartite() {
		super();
	}

	@Override
	public String partita(int id) {
		Partita partita = (IMappablePro.fromMap(Partita.class, getOne("SELECT * FROM risultati_partite WHERE id = ?", id)));
		partita.setPossessoCasa();
		partita.setPossessoOspite();
		return gson.toJson(partita);
	}

	@Override
	public String partite() {
		List<Partita> ris = new ArrayList<>();		
		List<Map<String, String>> maps = getAll("SELECT * FROM risultati_partite");
		
		for(Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Partita.class, map));
		}
		
		return gson.toJson(ris);
	}

	@Override
	public String partiteCompetizione(int id) {		
		List<Partita> ris = new ArrayList<>();		
		List<Map<String, String>> maps = getAll("SELECT * FROM risultati_partite WHERE id_competizione = ?", id);
		
		for(Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Partita.class, map));
		}
		
		return gson.toJson(ris);
	}

	@Override
	public String partiteSquadra(String squadra) {
		List<Partita> ris = new ArrayList<>();		
		List<Map<String, String>> maps = getAll("SELECT * FROM risultati_partite WHERE casa = ? or ospite = ?", squadra, squadra);
		
		for(Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Partita.class, map));
		}
		
		return gson.toJson(ris);
	}

}
