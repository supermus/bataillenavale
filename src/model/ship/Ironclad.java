package model.ship;

import model.Orientation;
import model.Position;

public class Ironclad extends Ship {

	private final static String SHIP_NAME = "Cuirass� furtif";
	private final static int SHIP_SIZE = 3;
	
	public Ironclad(Position origin, Orientation orientation) {
		super(SHIP_NAME, origin, SHIP_SIZE, orientation);
	}
}
