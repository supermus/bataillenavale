package model;

import java.util.*;

import model.ship.*;

public abstract class Player {

	
	private String 	nom; 	// nom du joueur ou de l'ordinateur
	private String 	status; // �tat du joueur (gagnant/perdant)
	private int		score; 	// score courant
	private int 	hits; 	// compteur coups r�ussis
	private int 	miss; 	// compteur coups rat�s
	private Grid 	grid; 	// grille
	
	
	/**
	 * Constructeur principal de Player
	 * @param nom Nom du joueur
	 * @param g grille associ�e � ce joueur
	 */
	public Player(String nom, Grid g) {
		this.nom = nom;
		this.score = 0;
		this.hits = 0;
		this.miss = 0;
		this.grid = g;
		this.status = "inconnu";
	}
	
	public boolean placeBoat(String name, Position origin, int size, Orientation orientation){
		
		boolean boat=true; 
		switch(orientation)
		{
		case Horizontale :
			//V�rification si un bateau existe deja � cette position 
			for(int i=0 ; i<size && boat==true ; i++){
				if(!grid.isship(new Position(origin.getX()+i,origin.getY()))){
					boat=false;
				}
			}	
				
			if (name == "AircraftCarrier" && boat==true){
				if (grid.getSize()-origin.getX() <= AircraftCarrier.SHIP_SIZE )
					grid.addShip(new AircraftCarrier(origin,orientation) );	
			}
			
			if (name == "IronClad" && boat==true){
				if (grid.getSize()-origin.getX() <= Ironclad.SHIP_SIZE)
					grid.addShip(new Ironclad(origin,orientation) );
			}
				
			if (name == "Submarine" && boat==true){
				if (grid.getSize()-origin.getX() <= Submarine.SHIP_SIZE)
					grid.addShip(new Submarine(origin,orientation) );
			}
					
			if (name == "Zodiac" && boat==true){
				if (grid.getSize()-origin.getX() <= Zodiac.SHIP_SIZE)
					grid.addShip(new Zodiac(origin,orientation) );
				}
			
			//Ajout des position du nouveau bateau		
			for (int i = 0; i < size && boat==true; i++) {	
				grid.returnLastShip().setStates(new Position(origin.getX()+i,origin.getY()));
				}	
			
			break;
		
		
			
		case Verticale :
			//V�rification si un bateau existe deja � cette position 
			for(int i=0 ; i<size && boat==true ; i++){
				if(!grid.isship(new Position(origin.getX(),origin.getY()+i))){
					boat=false;
				}			
			}
			
			if (name == "AircraftCarrier" && boat==true){
				if (grid.getSize()-origin.getY() <= 5 ){
					grid.addShip(new AircraftCarrier(origin,orientation) );
				}
			}
			
			if (name == "IronClad" && boat==true){
				if (grid.getSize()-origin.getY() <= 3)
					grid.addShip(new Ironclad(origin,orientation) );
			
			}
				
			if (name == "Submarine" && boat==true){
				if (grid.getSize()-origin.getY() <= 4)
					grid.addShip(new Submarine(origin,orientation) );
			}
					
			if (name == "Zodiac" && boat==true){
				if (grid.getSize()-origin.getY() <= 2)
					grid.addShip(new Zodiac(origin,orientation) );
				}
			//Ajout des position du nouveau bateau
			for (int i = 0; i < size && boat==true; i++) {	
				grid.returnLastShip().setStates(new Position(origin.getX(),origin.getY()+i));
				}
				
			break;
		}
		return boat;
		
	}	
				
		
//		aircraftCarrier = new AircraftCarrier(origin,orientation);
//		switch (orientation) {
//		case Horizontale:
//			for (int i = 0; i < size; i++) {
//				state.put(new Position(origin.getX(),origin.getY()-i), true);
//				
//			}
//			break;
//		case Verticale:
//			for (int i = 0; i < size; i++) {
//				state.put(new Position(origin.getX(),origin.getY()+i), true);
//			}
//			break;
//		}
	
	
	@Override
	public String toString() {
		return "Player [nom=" + nom + ", status=" + status + ", nombre d'attaques="
				+ (miss+hits) + ", score=" + score + "]";
	}
	
	/**
	 * Retourne le nombre de coups total du joueur
	 * @return int nombre de coups
	 */
	public int getAttacks() {
		return hits + miss;
	}

	/**
	 * Retourne le nombre de coups r�ussis du joueur
	 * @return int nombre de coups r�ussis
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * Retourne le nombre de coups rat�s du joueur
	 * @return int nombre de coups rat�s
	 */
	public int getMiss() {
		return miss;
	}

	/**
	 * Remplace le score du joueur
	 * @param score nouvelle valeur du score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Incr�mente le score du joueur
	 * @param score montant � ajouter au score
	 */
	public void addScore(int score)
	{
		this.score += score;
	}

	/**
	 * Retourne le score courant du joueur
	 * @return int valeur du score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Retourne le nom du joueur
	 * @return String nom du joueur
	 */
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Retourne la grille du joueur
	 * @return Grid grille du joueur
	 */
	public Grid getGrid()
	{
		return grid;
	}
	
	/**
	 * Incr�mente de 1 le compteur de coups r�ussis
	 */
	public void addHit()
	{
		this.hits++;
	}
	
	/**
	 * Incr�mente de 1 le compteur de coups rat�s
	 */
	public void addMiss()
	{
		this.miss++;
	}

}
