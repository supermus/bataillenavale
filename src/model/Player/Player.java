package model.Player;


import model.*;
import model.ship.*;

public abstract class Player {

	
	private String 	nom; 	// nom du joueur ou de l'ordinateur
	private String 	status; // état du joueur (gagnant/perdant)
	private int		score; 	// score courant
	private int 	hits; 	// compteur coups réussis
	private int 	miss; 	// compteur coups ratés
	private Grid 	grid; 	// grille
	private boolean turn;
	
	/**
	 * Constructeur principal de Player
	 * @param nom Nom du joueur
	 * @param g grille associée à ce joueur
	 */
	public Player(String nom, Grid g) {
		this.nom = nom;
		this.score = 0;
		this.hits = 0;
		this.miss = 0;
		this.grid = g;
		this.status = "inconnu";
		this.turn=true;
	}
	
	public boolean placeBoat(String name, Position origin,  Orientation orientation){
		int size=this.getGrid().getSize();
		boolean boat=true; 
		switch(orientation)
		{
		case Horizontale :
			//Vérification si un bateau existe deja à cette position 
			for(int i=0 ; i<size && boat==true ; i++){
				if(grid.isship(new Position(origin.getX()+i,origin.getY()))){
					boat=false;
				}
			}	
				
			if (name == "AircraftCarrier" && boat==true){
				if (grid.getSize()-origin.getX() >= AircraftCarrier.SHIP_SIZE )
					grid.addShip(new AircraftCarrier(origin,orientation) );	
			}
			
			if (name == "IronClad" && boat==true){
				if (grid.getSize()-origin.getX() >= Ironclad.SHIP_SIZE)
					grid.addShip(new Ironclad(origin,orientation) );
			}
				
			if (name == "Submarine" && boat==true){
				if (grid.getSize()-origin.getX() >= Submarine.SHIP_SIZE)
					grid.addShip(new Submarine(origin,orientation) );
			}
					
			if (name == "Zodiac" && boat==true){
				if (grid.getSize()-origin.getX() >= Zodiac.SHIP_SIZE)
					grid.addShip(new Zodiac(origin,orientation) );
				}
			
			//Ajout des position du nouveau bateau	
			/*for (int i = 0; i < size && boat==true; i++) {	
				grid.returnLastShip().setStates(new Position(origin.getX()+i,origin.getY()));
				}	
			
			break;
		*/
		case Verticale :
			//Vérification si un bateau existe deja à cette position 
			for(int i=0 ; i<size && boat==true ; i++){
				if(grid.isship(new Position(origin.getX(),origin.getY()+i))){
					boat=false;
				}			
			}
			
			if (name == "AircraftCarrier" && boat==true){
				if (grid.getSize()-origin.getY() >= AircraftCarrier.SHIP_SIZE ){
					grid.addShip(new AircraftCarrier(origin,orientation) );
				}
			}
			
			if (name == "IronClad" && boat==true){
				if (grid.getSize()-origin.getY() >= Ironclad.SHIP_SIZE)
					grid.addShip(new Ironclad(origin,orientation) );
			
			}
				
			if (name == "Submarine" && boat==true){
				if (grid.getSize()-origin.getY() >= Submarine.SHIP_SIZE)
					grid.addShip(new Submarine(origin,orientation) );
			}
					
			if (name == "Zodiac" && boat==true){
				if (grid.getSize()-origin.getY() >= Zodiac.SHIP_SIZE)
					grid.addShip(new Zodiac(origin,orientation) );
				}
			// Pas besoin Ship l'ajoute automatiquement
			//Ajout des position du nouveau bateau
			/*for (int i = 0; i < size && boat==true; i++) {	
				grid.returnLastShip().setStates(new Position(origin.getX(),origin.getY()+i));
				}*/
				
			break;
		}
		return boat;
		
	}	
				
	/*-----------------------------**/
	/*
public boolean placeBoat(String name, Position origin, int size, Orientation orientation){
		
		boolean boat=true; 
		switch(orientation)
		{
		case Horizontale :
			//Vérification si un bateau existe deja à cette position 
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
			//Vérification si un bateau existe deja à cette position 
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
		
	}	*/
	
	/*--------------------------------*/
		
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
	 * Retourne le nombre de coups réussis du joueur
	 * @return int nombre de coups réussis
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * Retourne le nombre de coups ratés du joueur
	 * @return int nombre de coups ratés
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
	}/**
	 * Incrémente le score du joueur
	 * @param score montant à ajouter au score
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
	 * Incrémente de 1 le compteur de coups réussis
	 */
	public void addHit()
	{
		this.hits++;
	}
	
	/**
	 * Incrémente de 1 le compteur de coups ratés
	 */
	public void addMiss()
	{
		this.miss++;
	}
	
	/**
	 * Gagnant ou perdant
	 */
	public boolean win(Player adversaire){
		boolean bool=true;
		for (int i = 0; i <adversaire.getGrid().getShip().size(); i++) {
			if(!adversaire.getGrid().getShip().get(i).isDead()){
				bool=false;
				break;
			}
		}
		
		return bool;
		
	}

	public void enable(){
		this.turn=true;
		}

	public void disable(){
		this.turn=false;
	}
	public boolean getturn(){
		return this.turn;
	}
}
