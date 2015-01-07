package model;

import java.util.ArrayList;

import model.ship.Ship;

public class Grid {
	int size;
	private ArrayList<Ship> ships;//liste des navires
	private ArrayList<Position> missed ; //liste des coups ratÃ©s de l'adversaire
	private ArrayList<Position> attacks; //rends la methode attaque plus facile(- de conditions..)
	private ArrayList<Position> hits; //utilisable (Computer->difficulté normal)

	/**
	 * Constructeur principal de Grid
	 * @param size Taille de la grille
	 */
	public Grid(int size) {
		this.size = size;
		this.ships = new ArrayList<Ship>();
		this.missed = new ArrayList<Position>();
		this.attacks = new ArrayList<Position>();
		this.hits = new ArrayList<Position>();
	}

	/**
	 * Retourne la liste des attaques (ratées ou pas)
	 * @return Liste des positions attaquées
	 */
	public ArrayList<Position> getAttacks() {
		return attacks;
	}

	/**
	 * Ajoute une position dans la liste des positions attaquées
	 * @param att Position à ajouter
	 */
	public void addattacks(Position att	) {
		this.attacks.add(att);
	}

	/**
	 * Ajoute un bateau dans la liste des bateaux
	 * @param ship Bateau à ajouter
	 */
	public void addShip(Ship ship){
		ships.add(ship);
	}

	/**
	 * Retourne le dernier bateau ajouté à la liste
	 * @return Dernier bateau ajouté
	 */
	public Ship returnLastShip(){
		return ships.get(ships.size()-1);
	}

	/**
	 * Retourne la liste des bateaux
	 * @return Liste des bateaux de la grille
	 */
	public ArrayList<Ship> getShip() {
		return ships;
	}

	/**
	 * Vérifie si la case est un morceau d'un navire
	 * @param position Position à vérifier
	 * @return true si la position fait partie d'un navire, false sinon.
	 */
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

	/**
	 * Retourne la taille de la carte
	 * @return Taille de la map
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Ajouté un coup manqué dans la liste des coups manqués
	 * @param miss Position à ajouter
	 */
	public void addMissed(Position miss) {
		this.missed.add(miss);
	}

	/**
	 * Retourne la liste des attaques ratées
	 * @return Liste des attaques ratées
	 */
	public ArrayList<Position> getMissed() {
		return missed;
	}

	/**
	 * Vérifie si il y a un coup raté à la position désirée
	 * @param position Position à tester
	 * @return true si il y a un coup manqué, false sinon.
	 */
	public boolean ismissed(Position position){
		boolean ismissed=false;
		for (int i = 0; i < this.missed.size(); i++) {
			if(this.missed.get(i).equals(position)){
				ismissed=true;
				break;}
		}
		return ismissed;
	}

	/**
	 * Vérifie si il y a eu une attaque à la position désirée
	 * @param position Position à tester
	 * @return true si la position a été attaquée, false sinon.
	 */
	public boolean isattacked(Position position){
		boolean isattacked=false;
		for (int i = 0; i < this.getAttacks().size(); i++) {
			if(this.getAttacks().get(i).equals(position)){
				isattacked=true;
				break;}
		}
		return isattacked;
	}

	/**
	 * Ajoute une position dans la liste des positions attaquées
	 * @param hit Position à ajouter
	 */
	public void addhits(Position hit) {
		this.hits.add(hit);
	}

	/**
	 * Retourne la liste des coups réussis
	 * @return Liste des coups réussis
	 */
	public ArrayList<Position> getHits() {
		return hits;
	}

	/**
	 * Vérifie si une position a été attaquée avec succès
	 * @param position Position à tester
	 * @return true si la position a été attaquée avec succès, false sinon.
	 */
	public boolean ishits(Position position){
		boolean ishits=false;
		for (int i = 0; i < this.hits.size(); i++) {
			if(this.hits.get(i).equals(position)){
				ishits=true;
				break;}
		}
		return ishits;
	}

}
