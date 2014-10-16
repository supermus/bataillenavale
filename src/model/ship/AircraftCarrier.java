package model.ship;

import model.Position;

public class AircraftCarrier extends Ship {

	private final static String SHIP_NAME = "Porte-avion";
	private final static int SHIP_SIZE = 5;
	
	public AircraftCarrier(Position origin, boolean orientation) {
		super(SHIP_NAME, origin, SHIP_SIZE, orientation);
	}
}
