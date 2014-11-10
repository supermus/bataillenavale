package model;

import java.util.*;

import model.ship.*;

public abstract class Player {

	private String nom;
	private String Statu;
	private int score;
	private ArrayList<Ship> ships;//liste des navires
	private ArrayList<Position> missed ; //liste des coups ratés de l'adversaire
	private ArrayList<Position> hits ; //liste des coups reussits de l'adversaire
	private ArrayList<Position> attacks; //liste des attaques de l'adversaire
	
	public Player(String nom) {
		this.nom = nom;
		this.score = 0;
		this.ships =new ArrayList<Ship>();
		this.missed = new ArrayList<Position>();
		this.hits = new ArrayList<Position>();
		this.attacks = new ArrayList<Position>();
	}
	
	@Override
	public String toString() {
		return "Player [nom=" + nom + ", Statu=" + Statu + ", attacks="
				+ attacks + ", score=" + score + ", ships=" + ships
				+ ", missed=" + missed + ", hits=" + hits + "]";
	}

	
	public ArrayList<Ship> getShip() {
		return ships;
	}	
//voir si la case contient un navire 
	public boolean isship(Position position){
		 boolean isship=false;
		for (int i = 0; i <this.getShip().size(); i++) {
			if(this.getShip().get(i).hasPosition(position)){
				isship=true;
			break;
			}
				}
		return isship;
		}

//verifie si la case est attaquée
	public boolean isattacked(Position position){
		 boolean isattacked=false;
		for (int i = 0; i < this.attacks.size(); i++) {
			if(this.attacks.get(i).toString().equals(position.toString())){
				isattacked=true;
			break;}
			}
		return isattacked;
		}

	public void setScore(int score) {
		this.score += score;
	}
	public void addMissed(Position miss) {
		this.missed.add(miss);
	}

	public void addhits(Position hit) {
		this.hits.add(hit);
	}
	public void addattacks(Position att	) {
		this.attacks.add(att);
	}

	public ArrayList<Position> getAttacks() {
		return attacks;
	}

	public int getScore() {
		return score;
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

	public ArrayList<Position> getHits() {
		return hits;
	}
	public ArrayList<Position> getMissed() {
		return missed;
	}
	public boolean ishits(Position position){
		 boolean ishits=false;
		for (int i = 0; i < this.hits.size(); i++) {
			if(this.hits.get(i).toString().equals(position.toString())){
				ishits=true;
			break;}
				}
		return ishits;
		}
	public boolean ismissed(Position position){
		 boolean ismissed=false;
		for (int i = 0; i < this.missed.size(); i++) {
			if(this.missed.get(i).toString().equals(position.toString())){
				ismissed=true;
			break;}
				}
		return ismissed;
		}
	
}
