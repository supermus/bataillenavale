package model;

import java.util.ArrayList;

import model.ship.Ship;

public class Grid {
	int size;
	private ArrayList<Ship> ships;//liste des navires	
	private ArrayList<Position> missed ; //liste des coups ratés de l'adversaire
	private ArrayList<Position> attacks; //rends la methode attaque plus facile(- de conditions..)
	private ArrayList<Position> hits; //utilisable (Computer->difficult� normal) 
	
	public Grid(int size) {
		this.size = size;
		this.ships =new ArrayList<Ship>();
		this.missed = new ArrayList<Position>();
		this.attacks= new ArrayList<Position>();
		this.hits= new ArrayList<Position>();
	}
	
	public ArrayList<Position> getAttacks() {
		return attacks;
	}
	
	public void addattacks(Position att	) {
		this.attacks.add(att);
	}

	public void addShip(Ship ship){
		ships.add(ship);
	}
	
	public Ship returnLastShip(){
		return ships.get(ships.size()-1);
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

		public int getSize() {
			return size;
		}


		public void addMissed(Position miss) {
			this.missed.add(miss);
		}

		public ArrayList<Position> getMissed() {
			return missed;
		}
		public boolean ismissed(Position position){
			 boolean ismissed=false;
			for (int i = 0; i < this.missed.size(); i++) {
				if(this.missed.get(i).equals(position)){
					ismissed=true;
				break;}
					}
			return ismissed;
			}
		
		
		
		//verifie si la case est attaquée
				public boolean isattacked(Position position){
					 boolean isattacked=false;
					for (int i = 0; i < this.getAttacks().size(); i++) {
						if(this.getAttacks().get(i).equals(position)){
							isattacked=true;
						break;}
						}
					return isattacked;
					}


		public void addhits(Position hit) {
			this.hits.add(hit);
		}
		
		
		public ArrayList<Position> getHits() {
			return hits;
		}
		
	public boolean ishits(Position position){
		 boolean ishits=false;		
		 for (int i = 0; i < this.hits.size(); i++) {
			if(this.hits.get(i).equals(position)){
				ishits=true;
				break;}
				}
			return ishits;
			}
		
	//verifie si la case est attaquée
//	public boolean isattacked(Position position){
//		 boolean boll=false;
//			for (int i = 0; i <this.getShip().size(); i++) {
//				for (Entry<Position, Boolean> entry : this.getShip().get(i).getState().entrySet()) {
//		            if (entry.getKey().equals(position)) {
//		            	boll=entry.getValue();
//		            	break;
//		            }
//				}
//					}
//			return boll;
//		}		
	

}
