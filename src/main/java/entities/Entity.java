package entities;

import utility.IMappablePro;

/**
 * The Superclass designed for any entity in the program
 * @author Davide
 */
public class Entity implements IMappablePro {
	
	/**
	 * the @id represents the position in the corrispondent DB table
	 */
	private int id;
	
	/**
	 * the public basical contructor
	 * @param id
	 */
	public Entity(int id) {
		super();
		this.id = id;
	}
	/**
	 * void contructor
	 */
	public Entity() {
		super();
	}
	/**
	 * @return the @id
	 */
	public int getId() {
		return id;
	}
	/**
	 * set the @id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
