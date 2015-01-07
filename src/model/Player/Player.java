package model.Player;


import model.Grid;
import model.Orientation;
import model.Position;
import model.ship.AircraftCarrier;
import model.ship.Ironclad;
import model.ship.Submarine;
import model.ship.Zodiac;

public abstract class Player {


	private String 	nom; 	// nom du joueur ou de l'ordinateur
	private String 	status; // �tat du joueur (gagnant/perdant)
	private int		score; 	// score courant
	private int 	hits; 	// compteur coups r�ussis
	private int 	miss; 	// compteur coups rat�s
	private Grid 	grid; 	// grille
	private boolean turn;

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
		this.turn=true;
	}

	/**
	 * Place un bateau
	 * @param name
	 * @param origin
	 * @param orientation
	 * @return true si un bateau a �t� plac�, false sinon.
	 */
	public boolean placeBoat(String name, Position origin,  Orientation orientation){
		int size=this.getGrid().getSize();
		boolean boat=true;
		switch(orientation)
		{
		case Horizontale :
			//V�rification si un bateau existe deja �cette position
			for(int i=0 ; i<size && boat==true ; i++){
				if(grid.isship(new Position(origin.getX()+i,origin.getY()))){
					boat=false;
				}
			}

			if (name == "AircraftCarrier" && boat==true){
				if (grid.getSize()-origin.getX() >= AircraftCarrier.SHIP_SIZE ) {
					grid.addShip(new AircraftCarrier(origin,orientation) );
				}
			}

			if (name == "IronClad" && boat==true){
				if (grid.getSize()-origin.getX() >= Ironclad.SHIP_SIZE) {
					grid.addShip(new Ironclad(origin,orientation) );
				}
			}

			if (name == "Submarine" && boat==true){
				if (grid.getSize()-origin.getX() >= Submarine.SHIP_SIZE) {
					grid.addShip(new Submarine(origin,orientation) );
				}
			}

			if (name == "Zodiac" && boat==true){
				if (grid.getSize()-origin.getX() >= Zodiac.SHIP_SIZE) {
					grid.addShip(new Zodiac(origin,orientation) );
				}
			}

			//Ajout des position du nouveau bateau
			/*for (int i = 0; i < size && boat==true; i++) {
				grid.returnLastShip().setStates(new Position(origin.getX()+i,origin.getY()));
				}

			break;
			 */
		case Verticale :
			//V�rification si un bateau existe deja � cette position
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
				if (grid.getSize()-origin.getY() >= Ironclad.SHIP_SIZE) {
					grid.addShip(new Ironclad(origin,orientation) );
				}

			}

			if (name == "Submarine" && boat==true){
				if (grid.getSize()-origin.getY() >= Submarine.SHIP_SIZE) {
					grid.addShip(new Submarine(origin,orientation) );
				}
			}

			if (name == "Zodiac" && boat==true){
				if (grid.getSize()-origin.getY() >= Zodiac.SHIP_SIZE) {
					grid.addShip(new Zodiac(origin,orientation) );
				}
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

	@Override
	public String toString() {
		return "Player [nom=" + nom + ", status=" + status + ", nombre d'attaques="
				+ (miss+hits) + ", score=" + score + "]";
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
	 * Retourne le nombre de coups total du joueur
	 * @return int nombre de coups
	 */
	public int getAttacks() {
		return hits + miss;
	}

	/**
	 * Retourne le nombre de coups rأ©ussis du joueur
	 * @return int nombre de coups rأ©ussis
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * Retourne le nombre de coups ratأ©s du joueur
	 * @return int nombre de coups ratأ©s
	 */
	public int getMiss() {
		return miss;
	}

	/**
	 * Retourne le score courant du joueur
	 * @return int valeur du score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Retourne le nombre de bateaux touch�s
	 * @param adversaire Joueur adverse
	 * @return le nombre de bateaux touch�s
	 */
	public int nbrboathits(Player adversaire){
		int nbrboats=0;
		for (int i = 0; i <adversaire.getGrid().getShip().size(); i++) {
			if(adversaire.getGrid().getShip().get(i).isDead()){
				nbrboats++;
			}
		}

		return nbrboats;
	}

	/**
	 * Remplace le score du joueur
	 * @param score nouvelle valeur du score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Incrأ©mente le score du joueur
	 * @param score montant أ  ajouter au score
	 */
	public void addScore(int score)
	{
		this.score += score;
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

	/**
	 * Indique si le joueur est gagnant ou perdant
	 * @param adversaire Joueur adverse
	 * @return true si gagnant, false si perdant
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

	/**
	 * D�finit que c'est le tour du joueur
	 */
	public void enable(){
		this.turn=true;
	}

	/**
	 * D�finit que ce n'est pas le tour du joueur
	 */
	public void disable(){
		this.turn=false;
	}

	/**
	 * Obtient l'�tat du tour (si oui ou non c'est son tour)
	 * @return true si c'est son tour, false sinon
	 */
	public boolean getturn(){
		return this.turn;
	}
}
