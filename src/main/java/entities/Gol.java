package entities;

/**
 * @author Matteo
 * designs the basical structure to represent the Gol
 */
public class Gol extends Entity {
	
	/**
	 * the minute of the gol
	 */
	int minuto;
	
	int id_partita;
	
	/**
	 * the player who scores the gol
	 */
	String realizzatore;
	
	int id_realizzatore;
	
	/**
	 * the player who assist the gol
	 */
	String assistman;
	
	int id_assistman;
	
	/**
	 * 
	 */
	String nome_squadra;
	
	/**
	 * if the gol was on a rigore
	 */
	boolean rigore;
	
	/**
	 * if the gol was on a punizione
	 */
	boolean punizione;
	
	/**
	 * if the gol was an autogol
	 */
	boolean autogol;
	
	/**
	 * if the gol was ditesta
	 */
	boolean diTesta;
	
	/**
	 * if the gol was in rovesciata
	 */
	boolean rovesciata;
	
	/**
	 * true if the gold was with piede destro, false if it was with piede sinistro
	 */
	boolean piede;
	
	String dettaglio;
	

	public Gol() {}
	
	/** full fields Contructor
	 * 
	 * @param id
	 * @param minuto
	 * @param realizzatore
	 * @param assistMan
	 * @param rigore
	 * @param punizione
	 * @param autogol
	 * @param diTesta
	 * @param rovesciata
	 * @param piede
	 *
	 */
	public Gol(int id, int minuto, int id_partita, String realizzatore, int id_realizzatore, String squadra, String assistman, int id_assistman, Partita partita,
			boolean rigore, boolean punizione, boolean autogol, boolean diTesta, boolean rovesciata, boolean piede) {
		super(id);
		this.minuto = minuto;
		this.id_partita = id_partita;
		this.realizzatore = realizzatore;
		this.id_realizzatore = id_realizzatore;
		this.nome_squadra = squadra;
		this.assistman = assistman;
		this.id_assistman = id_assistman;
		this.rigore = rigore;
		this.punizione = punizione;
		this.autogol = autogol;
		this.diTesta = diTesta;
		this.rovesciata = rovesciata;
		this.piede = piede;
	}

	/**
	 * @return the minuto
	 */
	public int getMinuto() {
		return minuto;
	}

	/**
	 * @return the id_partita
	 */
	public int getId_partita() {
		return id_partita;
	}

	/**
	 * @param id_partita the id_partita to set
	 */
	public void setId_partita(int id_partita) {
		this.id_partita = id_partita;
	}

	/**
	 * @param minuto the minuto to set
	 */
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	/**
	 * @return the realizzatore
	 */
	public String getRealizzatore() {
		return realizzatore;
	}

	/**
	 * @param realizzatore the realizzatore to set
	 */
	public void setRealizzatore(String realizzatore) {
		this.realizzatore = realizzatore;
	}

	/**
	 * @return the assistMan
	 */
	public String getAssistMan() {
		return assistman;
	}

	/**
	 * @param assistMan the assistMan to set
	 */
	public void setAssistMan(String assistMan) {
		this.assistman = assistMan;
	}

	/**
	 * @return the rigore
	 */
	public boolean isRigore() {
		return rigore;
	}

	/**
	 * @param rigore the rigore to set
	 */
	public void setRigore(boolean rigore) {
		this.rigore = rigore;
	}

	/**
	 * @return the punizione
	 */
	public boolean isPunizione() {
		return punizione;
	}

	/**
	 * @param punizione the punizione to set
	 */
	public void setPunizione(boolean punizione) {
		this.punizione = punizione;
	}

	/**
	 * @return the autogol
	 */
	public boolean isAutogol() {
		return autogol;
	}

	/**
	 * @param autogol the autogol to set
	 */
	public void setAutogol(boolean autogol) {
		this.autogol = autogol;
	}

	/**
	 * @return the diTesta
	 */
	public boolean isDiTesta() {
		return diTesta;
	}

	/**
	 * @param diTesta the diTesta to set
	 */
	public void setDiTesta(boolean diTesta) {
		this.diTesta = diTesta;
	}

	/**
	 * @return the rovesciata
	 */
	public boolean isRovesciata() {
		return rovesciata;
	}

	/**
	 * @param rovesciata the rovesciata to set
	 */
	public void setRovesciata(boolean rovesciata) {
		this.rovesciata = rovesciata;
	}

	/**
	 * @return the piede
	 */
	public boolean isPiede() {
		return piede;
	}

	/**
	 * @param piede the piede to set
	 */
	public void setPiede(boolean piede) {
		this.piede = piede;
	}
	
	/**
	 * @return the assistman
	 */
	public String getAssistman() {
		return assistman;
	}

	/**
	 * @param assistman the assistman to set
	 */
	public void setAssistman(String assistman) {
		this.assistman = assistman;
	}

	/**
	 * @return the nome_squadra
	 */
	public String getNome_squadra() {
		return nome_squadra;
	}

	/**
	 * @param nome_squadra the nome_squadra to set
	 */
	public void setNome_squadra(String nome_squadra) {
		this.nome_squadra = nome_squadra;
	}

	/**
	 * @return the id_realizzatore
	 */
	public int getId_realizzatore() {
		return id_realizzatore;
	}

	/**
	 * @param id_realizzatore the id_realizzatore to set
	 */
	public void setId_realizzatore(int id_realizzatore) {
		this.id_realizzatore = id_realizzatore;
	}

	/**
	 * @return the id_assistman
	 */
	public int getId_assistman() {
		return id_assistman;
	}

	/**
	 * @param id_assistman the id_assistman to set
	 */
	public void setId_assistman(int id_assistman) {
		this.id_assistman = id_assistman;
	}

	/**
	 * @param dettaglio the dettaglio to set
	 */
	public void setDettaglio(String dettaglio) {
		this.dettaglio = dettaglio;
	}

	public String getDettaglio() {
		
		if(rigore) {
			return "Rigore";
		}
		
		if(punizione) {
			return "Punizione";
		}
		
		if(rovesciata) {
			return "Rovesciata";
		}
		
		if(autogol) {
			return "Autogol";
		}
		
		if(diTesta) {
			return "Testa";
		}
		
		if(piede) {
			return "Di destro";
		} else {
			return "Di sinistro";
		}
	}
	
	
}
