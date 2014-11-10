package model.ship;

import model.Orientation;
import model.Position;

public class Submarine extends Ship {

	private final static String SHIP_NAME = "Sous-marin nucléaire";
	private final static int SHIP_SIZE = 4;
	
	public Submarine(Position origin, Orientation orientation) {
		super(SHIP_NAME, origin, SHIP_SIZE, orientation);
	}
}
