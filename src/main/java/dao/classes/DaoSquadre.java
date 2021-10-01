package dao.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.interfaces.IDaoSquadre;
import entities.Squadra;
import utility.IMappablePro;

public class DaoSquadre extends BasicDao implements IDaoSquadre {

	public DaoSquadre(String dbAddress) {
		super(dbAddress);
	}

	public DaoSquadre() {
		super();
	}

	@Override
	public String squadra(String nome) {
		Squadra squadra = IMappablePro.fromMap(Squadra.class, getOne("SELECT * FROM squadre WHERE nome = ?", nome));
		List<String> competizioni = new ArrayList<>();
		List<Map<String, String>> maps = getAll("SELECT nome FROM competizioni INNER JOIN competizione_squadre "
				+ "ON competizione_squadre.id_campionato = competizioni.id WHERE nome_squadra = ?", nome);
		for(Map<String, String> map : maps) {
			competizioni.add(map.get("nome"));
		}
		squadra.setCompetizioni(competizioni);
		return gson.toJson(squadra);
	}

	@Override
	public String squadre(int id) {
		List<Squadra> ris = new ArrayList<>();		
		List<Map<String, String>> maps = getAll("SELECT * FROM squadre JOIN competizione_squadre "
				+ "WHERE squadre.nome = competizione_squadre.nome_squadra AND id_campionato = ?", id);
		for(Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Squadra.class, map));
		}	
		
		return gson.toJson(ris);
		
		
	}

}
