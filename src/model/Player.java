package model;

import java.util.*;

import model.ship.*;

public abstract class Player {

	private String nom;
	private int attacks;
	private int score;
	private ArrayList<Ship> ships;
	private ArrayList<Position> missed ;
	private ArrayList<Position> hits ;
	
	
	public Player(String nom) {
		this.nom = nom;
		this.attacks = 0;
		this.score = 0;
		this.ships =new ArrayList<Ship>();
		this.missed = new ArrayList<Position>();
		this.hits = new ArrayList<Position>();
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
	public void attack(Player adversaire,Position position){
		this.attacks++;
		if(isship(adversaire,position)&&!ishits(adversaire, position)){
					hits.add(position);
					score+=10;
		}
	
	}
	public boolean isship(Player adversaire,Position position){
		 boolean isship=false;
		for (int i = 0; i < adversaire.getShips().size(); i++) {
			if(adversaire.getShips().get(i).hasPosition(position))
				isship=true;
			break;
				}
		return isship;
		}
	
	public boolean ishits(Player adversaire,Position position){
		 boolean ishits=false;
		for (int i = 0; i < hits.size(); i++) {
			if(hits.get(i).equals(position))
				ishits=true;
			break;
				}
		return ishits;
		}
	
	public ArrayList<Ship> getShips() {
		return ships;
	}
	
}
