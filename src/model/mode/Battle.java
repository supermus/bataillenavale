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

	
	public ArrayList<Integer> getNumbers(Grid g, int y) {
		for (int i = 0; i < g.getSize(); i++) {
			if(!g.isattacked(new Position(i, y))){
			numbers.add(i);
			}
		}
		return numbers;
	}
	
	public int getresult(ArrayList<Integer> numbers){
		
		return numbers.get(2).intValue();	
	}
	
	public int distance(Position pos1,Position pos2){
		int x=Math.abs(pos1.getX()-pos2.getX());
		int y=Math.abs(pos1.getY()-pos2.getY());
	return Math.max(x, y);
	
}
}
