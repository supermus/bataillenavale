package model.mode;

import java.util.ArrayList;
import java.util.Map.Entry;

import model.*;
import model.ship.*;
import model.Grid;
import model.Orientation;
import model.Player;
import model.Position;
import model.ship.AircraftCarrier;
import model.ship.Ironclad;
import model.ship.Submarine;
import model.ship.Zodiac;

public  class Battle {
	ArrayList<Integer> numbers;
	ArrayList<Position> surrond;
	public Battle() {
		this.numbers= new ArrayList<Integer>();
		this.surrond= new ArrayList<Position>();
	}
	
	//Methode pour placer les navires	
	public void PlaceShip(Grid  g, String type, Position position,Orientation orientation){
		switch (type) {
		case "Aircraft":
			g.getShip().add(new AircraftCarrier(position,orientation));
			break; 
		case "Ironclad":
			g.getShip().add(new Ironclad(position,orientation));
			break;
		case "Submarine":
			g.getShip().add(new Submarine(position,orientation));
			break;
		case "Zodiac":
			g.getShip().add(new Zodiac(position,orientation));
			break;
		
		default:
			break;
		}
	}

}
