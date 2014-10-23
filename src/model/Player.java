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
		if(adversaire.isship(position)&&!adversaire.ishits(position)&&!adversaire.ismissed(position)){
					this.hits.add(position);
					this.setScore(10);
		}
	
	}
	
//Methode pour tester si la cible contient un navire
	
	public boolean isship(Position position){
		 boolean isship=false;
		for (int i = 0; i < this.getShip().size(); i++) {
			if(this.getShip().get(i).hasPosition(position))
				isship=true;
			break;
				}
		return isship;
		}

//Methodes pour tester si la cible est deja attaqués
	
	public boolean ishits(Position position){
		 boolean ishits=false;
		for (int i = 0; i < this.hits.size(); i++) {
			if(this.hits.get(i).equals(position))
				ishits=true;
			break;
				}
		return ishits;
		}
	public boolean ismissed(Position position){
		 boolean ismissed=false;
		for (int i = 0; i < this.missed.size(); i++) {
			if(this.missed.get(i).equals(position))
				ismissed=true;
			break;
				}
		return ismissed;
		}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public ArrayList<Ship> getShip() {
		return ships;
	}	


	public int getAttacks() {
		return attacks;
	}
	
	public boolean getSuccess(ArrayList<Position> po) {
	
		boolean bool=true;
		for (int i = 0; i < po.size(); i++) {
		if (!ishits(po.get(i))) {
			bool=false;
			break;
		}	
		}
		return bool;
	}

	public ArrayList<Position> getMissed() {
		return missed;
	}
	
	//	public Ship getShip(Player adversaire,Position position) {
//		return ships;
//	}
}
