package model.mode;

import java.util.ArrayList;

import model.Grid;
import model.Orientation;
import model.Position;
import model.Player.Player;
import model.ship.AircraftCarrier;
import model.ship.Ironclad;
import model.ship.Submarine;
import model.ship.Zodiac;

public abstract class Battle {
	ArrayList<Integer> numbers;
	ArrayList<Position> surrond;

	/**
	 * Constructeur principal de Battle
	 */
	public Battle() {
		this.numbers= new ArrayList<Integer>();
		this.surrond= new ArrayList<Position>();
	}

	/**
	 * Place un bateau (obsol�te : m�thode d�plac�e dans Player !)
	 * @param player Joueur qui place
	 * @param type Type du bateau
	 * @param position Position du bateau
	 * @param orientation Orientation du bateau
	 */
	public void PlaceShip(Player player, String type, Position position,Orientation orientation){
		switch (type) {
		case "Aircraft":
			player.getGrid().getShip().add(new AircraftCarrier(position,orientation));
			break;
		case "Ironclad":
			player.getGrid().getShip().add(new Ironclad(position,orientation));
			break;
		case "Submarine":
			player.getGrid().getShip().add(new Submarine(position,orientation));
			break;
		case "Zodiac":
			player.getGrid().getShip().add(new Zodiac(position,orientation));
			break;

		default:
			break;
		}
	}

	public void attack(Player player, Player adversaire,Position position)
	{

	}

	public ArrayList<Integer> getNumbers(Grid g, int y) {
		for (int i = 0; i < g.getSize(); i++) {
			if(!g.isattacked(new Position(i, y))){
				numbers.add(i);
			}
		}
		return numbers;
	}

	public int getresult(ArrayList<Integer> numbers){

		return numbers.get(2).intValue();
	}

	/**
	 * Distance entre 2 positions
	 * @param pos1 1�re position
	 * @param pos2 2�me position
	 * @return distance entre les 2 points
	 */
	public int distance(Position pos1,Position pos2){
		int x=Math.abs(pos1.getX()-pos2.getX());
		int y=Math.abs(pos1.getY()-pos2.getY());
		return Math.max(x, y);

	}
}
