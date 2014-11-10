package model.ship;

import model.Orientation;
import model.Position;

public class Zodiac extends Ship {
	
	private final static String SHIP_NAME = "Zodiac";
	private final static int SHIP_SIZE = 2;
	
	public Zodiac(Position origin, Orientation orientation) {
		super(SHIP_NAME, origin, SHIP_SIZE, orientation);
	}

}
