package utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public interface IMappablePro {

	/*
	 * Java reflection � una libreria di Java che permette di accedere alla
	 * struttura dei metadati dei progetti Java 
	 * Permette di accedere a classi, metodi, propriet� intesi come parole chiave
	 * Permette di accedere alla struttura della classe -> getClass()
	 * class, String... getClass().getSimpleName() -> il nome della classe "pulito"
	 */
	public default Map<String, String> toMap() {
		Map<String, String> ris = new LinkedHashMap<>();
		Class<? extends IMappablePro> classe = this.getClass();
		for (Method m : classe.getMethods()) {
			if (!m.getName().equalsIgnoreCase("getclass") &&
					m.getName().startsWith("get") || m.getName().startsWith("is")) {
				try {
					int indexStart = m.getName().startsWith("get") ? 3 : 2;
					String chiave = m.getName().substring(indexStart).toLowerCase();
					// String valore = m.invoke(this).toString();
					String valore = m.invoke(this) == null ? "" : m.invoke(this).toString();
					// System.out.println("valore => " + valore);
					if (valore != null) {
						ris.put(chiave, valore);
					}
					
				} catch (IllegalAccessException |
						 IllegalArgumentException |
						 InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		ris.put("Class", classe.getSimpleName());
		return ris;
	}
	
	public static Map<String, String> chiaviMinuscole(Map<String, String> mappa) {
		Map<String, String> ris = new LinkedHashMap<>();
		for (String chiavi : mappa.keySet()) {
			String chiave = chiavi.toLowerCase();
			ris.put(chiave, mappa.get(chiavi));
		}
		return ris;
	}
	
	default void fromMap(Map<String, String> map) {
		Map<String, String> mappa = chiaviMinuscole(map);
		for (Method m : this.getClass().getMethods()) {
			if (m.getName().startsWith("set") && m.getParameterCount() == 1) {
				String nomeMetodo = m.getName().substring(3).toLowerCase();
				if (mappa.containsKey(nomeMetodo)) {
					String nomeTipoParametro = m.getParameters()[0].getType().getSimpleName();
					
					try {
						switch (nomeTipoParametro) {
						
						case "String":
							m.invoke(this, mappa.get(nomeMetodo));
							break;
						
						case "int":
							m.invoke(this, ConsoleApp.getInt(mappa.get(nomeMetodo)));
						break;
						
						case "double":
							m.invoke(this, ConsoleApp.getDouble(mappa.get(nomeMetodo)));
							break;
							
						case "boolean":
							m.invoke(this, ConsoleApp.getBoolean(mappa.get(nomeMetodo)));
							break;
							
						case "Date":
							m.invoke(this, ConsoleApp.getData(mappa.get(nomeMetodo)));
							break;
					
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	static <T extends IMappablePro> T fromMap(Class<T> type, Map<String, String> map) {
		T ris = null;
	
		try {
			Constructor<T> constructor = type.getConstructor();
			ris = constructor.newInstance();
			ris.fromMap(map);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.err.println("Manca il costruttore senza parametri, impossibile istanziare l'oggetto");
		}

		return ris;
	}
	
}	
	
	
	
