package model.ship;

import model.Orientation;
import model.Position;

public class Zodiac extends Ship {
	
	public final static String SHIP_NAME = "Zodiac";
	public final static int SHIP_SIZE = 2;
	
	/**
	 * Constructeur principal de Zodiac
	 * @param origin Position du bateau
	 * @param orientation Orientation du bateau
	 */
	public Zodiac(Position origin, Orientation orientation) {
		super(SHIP_NAME, origin, SHIP_SIZE, orientation);
	}

}
