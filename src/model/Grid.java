package model;

import java.util.ArrayList;

import model.ship.Ship;

public class Grid {
	int size;
	
	private ArrayList<Ship> ships;//liste des navires	
	private ArrayList<Position> missed ; //liste des coups ratés de l'adversaire
	private ArrayList<Position> hits ; //liste des coups reussits de l'adversaire
	private ArrayList<Position> attacks; //liste des attaques de l'adversaire
	
	public Grid(int size) {
		this.size = size;
		this.ships =new ArrayList<Ship>();
		this.missed = new ArrayList<Position>();
		this.hits = new ArrayList<Position>();
		this.attacks = new ArrayList<Position>();
		
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
			for (int i = 0; i < this.getAttacks().size(); i++) {
				if(this.getAttacks().get(i).toString().equals(position.toString())){
					isattacked=true;
				break;}
				}
			return isattacked;
			}
		public int getSize() {
			return size;
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
