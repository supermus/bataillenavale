package model;

import java.util.*;

import model.ship.*;

public abstract class Player {

	private String nom;
	private int attacks;
	private int score;
	private ArrayList<Ship> ships;
	private ArrayList<Position> missed ;
	
	
	public Player(String nom) {
		this.nom = nom;
		this.attacks = 0;
		this.score = 0;
		this.ships =new ArrayList<Ship>();
		this.missed = new ArrayList<Position>();
	}
//Methode pour placer les navires
	public void PlaceShip(String type, Position position,boolean orientation){
		switch (type) {
		case "Aircraft":
			ships.add(new AircraftCarrier(position,orientation));
			break;
		case "Ironclad":
			ships.add(new Ironclad(position,orientation));
			break;
		case "Submarine":
			ships.add(new Submarine(position,orientation));
			break;
		case "Zodiac":
			ships.add(new Zodiac(position,orientation));
			break;
		default:
			break;
		}
	}
//Methode pour attaquer
	public void attack(Position position,Player adversaire){
		this.attacks++;
	//	adversaire.getShips().get(1).
	//	if(){
			
	//	}
	}
	
	public ArrayList<Ship> getShips() {
		return ships;
	}
	
}
