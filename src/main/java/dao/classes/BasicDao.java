package dao.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public abstract class BasicDao {

	private Connection connection;
	protected Gson gson;
	
	public BasicDao() {
		gson = new Gson();
	}
	
	public BasicDao(String dbAddress) {
		super();
		try {
			connection = DriverManager.getConnection(dbAddress);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Verificare nel build la presenza del connector ");
			System.out.println("Verificare dbAddress, username e la password ");
		}
		gson = new Gson();
	}
	
	/**
	 * Una mappa � la rappresentazione di un record (row) di una tabella.
	 * La lista quindi � l'insieme dei record di una tabella
	 * @param sql  si tratta della query da inviare al DB
	 * @param conditions   sono i valori da sostituire ai placeholders nella query
	 * @return  Lista di tutte le mappe restituire dal DB in funzione alla query
	 */
	public List<Map<String, String>> getAll(String sql, Object... conditions) {
		/*-------------------------------     VARARGS   ---------------------------*/
		// il simbolo "..." indica che si pu� ricevere da 0 a infiniti parametri di quel tipo
		List<Map<String, String>> ris = new ArrayList<>();
		
		try {
			ResultSet rs = executeQuery(sql, conditions);
			
			while (rs.next()) {
				Map<String, String> map = mapFromRS(rs);
				ris.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ris;
	}

	/**
	 * Esegue la query in input e restituisce il relativo ResultSet
	 * @param sql si tratta della query da inviare al DB
	 * @param conditions sono i valori da sostituire ai placeholders nella query
	 * @return L'oggetto ResultSet risultante in funzione alla query inserita
	 * @throws SQLException
	 */
	private ResultSet executeQuery(String sql, Object... conditions) throws SQLException {
		return preparedStm(sql, conditions).executeQuery();
	}

	/**
	 * Restituisce l'oggetto di tipo PreparedStatement per effetuare query
	 * 
	 * String sql = "SELECT * FROM tabella WHERE id = ?" => conditions[0] => 1
	 * ?(1) => conditions[0]
	 * ?(2) => conditions[1]
	 * @param sql la query da inviare
	 * @param conditions il/i valore/i da sostituire ai placeholders della query
	 * @return il PreparedStatement contenente la query con i placeholders sostituiti
	 * @throws SQLException
	 */
	private PreparedStatement preparedStm(String sql, Object... conditions) throws SQLException {
		PreparedStatement stm = connection.prepareStatement(sql);
		
		// itero i parametri e assegno al ? della query la condizione corrispondente
		for (int i = 0; i < conditions.length; i++) {
			stm.setObject(i + 1, conditions[i]);
		}
		
		return stm;
	}

	/**
	 * Restituire la mappa di una singola riga di un ResultSet dove la chiave
	 * rappresenta il nome della colonna della tabella e il valore quello nella cella
	 * di quella determinata riga
	 * @param rs il ResultSet ottenuto dal DB eseguendo una determinata query
	 * @return la mappa che desccrive la singola riga di un ResultSet
	 * @throws SQLException
	 */
	private Map<String, String> mapFromRS(ResultSet rs) throws SQLException {
		Map<String, String> map = new HashMap<>();
		
		ResultSetMetaData meta = rs.getMetaData();
		
		for (int i = 1; i <= meta.getColumnCount(); i++) {
			map.put(meta.getColumnName(i), rs.getString(i));
		}
		
		return map;
	}
	
	/**
	 * Mappa che descrive un'entit� nella persistenza
	 * @param sql la query da inviare
	 * @param conditions il/i valore/i da sostituire ai placeholders della query
	 * @return La mappa restituita dal DB in base alla query inserita
	 */
	public Map<String, String> getOne(String sql, Object... conditions) {
		Map<String, String> ris = null;
		
		try {
			ResultSet rs = executeQuery(sql, conditions);
			
			if (rs.next()) {
				ris = mapFromRS(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ris;
	}
	
	/**
	 * Esegue una query impostando prima le condizioni
	 * @param sql la query da inviare
	 * @param conditions il/i valore/i da sostituire ai placeholders della query
	 */
	public String execute(String sql, Object... conditions) {
		String ris = "";
		try {
			PreparedStatement stm = preparedStm(sql, conditions);
			stm.execute();
			ris = stm.getWarnings() == null ? "Ok" : stm.getWarnings().toString();
		} catch (SQLException e) {
			ris = e.toString();
			e.printStackTrace();		
		}
		return ris;
	}
	
	
}
