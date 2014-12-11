package model.ship;

import model.Orientation;
import model.Position;

public class AircraftCarrier extends Ship {

	private final static String SHIP_NAME = "Porte-avion";
	private final static int SHIP_SIZE = 5;

	/**
	 * Constructeur principal de AircraftCarrier
	 * @param origin Position du bateau
	 * @param orientation Orientation du bateau
	 */
	public AircraftCarrier(Position origin, Orientation orientation) {
		super(SHIP_NAME, origin, SHIP_SIZE, orientation);
	}
}
