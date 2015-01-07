package model.ship;

import java.util.HashMap;
import java.util.Map.Entry;

import model.Orientation;
import model.Position;

public abstract class Ship {

	private String name;
	private int size; //La taille du navire
	private Position origin; //position de la  premiere case du navire
	private Orientation orientation; // orientation du navire top right bot left
	private HashMap<Position, Boolean> state; // map de correspondance position->état de chaque case composant le bateau

	/**
	 * Constructeur principale de Ship
	 * @param name Nom du bateau
	 * @param origin Position de l'origine du bateau
	 * @param size Longueur du bateau
	 * @param orientation Orientation du bateau
	 */
	public Ship(String name, Position origin, int size, Orientation orientation)
	{
		this.name = name;
		this.origin = origin;
		this.size = size;
		this.orientation = orientation;
		state=new HashMap<Position, Boolean>();
		switch (orientation) {
		case Verticale:
			for (int i = 0; i < size; i++) {
				state.put(new Position(origin.getX(),origin.getY()+i), true);
			}
			break;
		case Horizontale:
			for (int i = 0; i < size; i++) {
				state.put(new Position(origin.getX()+i,origin.getY()), true);
			}
			break;
		}
	}

	/**
	 * retourne la longueur du bateau
	 * @return int longueur du bateau
	 */
	public int getSize()
	{
		return this.size;
	}

	/**
	 * permet de savoir si une position fait partie des cases occupées par le bateau
	 * @param x coordonnée X
	 * @param y coordonée Y
	 * @return true si vrai, false sinon.
	 */
	public boolean hasPosition(int x, int y)
	{
		return hasPosition(new Position(x, y));
	}

	/**
	 *
	 * permet de savoir si une position fait partie des cases occupées par le bateau
	 * @param p Position à tester
	 * @return true si vrai, false sinon.
	 */
	public boolean hasPosition(Position p)
	{
		Boolean boll=false;
		for (Entry<Position, Boolean> entry : this.getState().entrySet()) {
			if (entry.getKey().equals(p)) {
				boll=true;
				break;
			}
			else{
				boll=false;
			}
		}

		return boll;
	}

	/**
	 * Permet de définir la position de l'origine du bateau
	 * @param p Position du bateau
	 */
	public void setPosition(Position p)
	{
		this.origin.setX(p.getX());
		this.origin.setY(p.getY());
	}

	/**
	 * Permet de définir la position de l'origine du bateau
	 * @param x coordonnée X
	 * @param y coordonnée Y
	 */
	public void setPosition(int x, int y)
	{
		this.origin.setX(x);
		this.origin.setY(y);
	}

	/**
	 * Ajoute une position dans le tableau des états du bateau
	 * @param position Position à ajouter
	 */
	public void setStates(Position position) {
		state.put(position, false);

	}

	/**
	 * Nom du bateau
	 * @return le nom du bateau
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retourne la hashmap des états du bateau
	 * @return hashmap des états du bateau
	 */
	public HashMap<Position, Boolean> getState() {
		return state;
	}

	/**
	 * Indique si un bateau est mort (tous ses états sont à FALSE)
	 * @return true si mort, false sinonz
	 */
	public boolean isDead()
	{
		boolean b=false;
		for (Entry<Position, Boolean> entry : this.getState().entrySet()) {
			if (entry.getValue()) {
				b=false;
				break;
			}
			else{
				b=true;
			}
		}
		return b;
	}
}
