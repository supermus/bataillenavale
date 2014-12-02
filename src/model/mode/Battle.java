package model.mode;

import java.util.ArrayList;
import java.util.Map.Entry;

import model.*;
import model.ship.*;
import model.Grid;
import model.Orientation;
import model.Player;
import model.Position;
import model.ship.AircraftCarrier;
import model.ship.Ironclad;
import model.ship.Submarine;
import model.ship.Zodiac;

public  class Battle {
	ArrayList<Integer> numbers;
	ArrayList<Position> surrond;
	public Battle() {
		super();
		this.numbers= new ArrayList<Integer>();
		this.surrond= new ArrayList<Position>();
	}
	
	//Methode pour placer les navires	
	public void PlaceShip(Grid  g, String type, Position position,Orientation orientation){
		switch (type) {
		case "Aircraft":
			g.getShip().add(new AircraftCarrier(position,orientation));
			break; 
		case "Ironclad":
			g.getShip().add(new Ironclad(position,orientation));
			break;
		case "Submarine":
			g.getShip().add(new Submarine(position,orientation));
			break;
		case "Zodiac":
			g.getShip().add(new Zodiac(position,orientation));
			break;
		
		default:
			break;
		}
	}

	
//  Methode pour attaquer
	public void attack(Grid player,Grid adversaire,Position position){
		//verifie si la case est attaqué 
		if(!adversaire.isattacked(position)){
			//s'il n'est pas attaqué il verifie si cette derniere contient un navire 
			if(adversaire.isship(position)){
				adversaire.addhits(position);
				//change etat de la case du navire de l'adversaire
				for (int i = 0; i < adversaire.getShip().size(); i++) {
					if(adversaire.getShip().get(i).getState().containsKey(position.toString())){
						adversaire.getShip().get(i).setStates(position);
					} 
				}
				//ajout score
				player.getPlayer().setScore(10);
			}
			else{
				//ajout des coups ratés
				adversaire.addMissed(position);
			}
			//marque la case comme ataqué
			adversaire.addattacks(position);
		}
		else{
			System.out.println("pas d'attaque");
		}
	}
	
	
//  Methode pour attaquer
	public void radar(Grid player,Grid adversaire,Position position){
		Position pos=new Position();
		int resultat=12;
		//verifie si la case est attaqué 
		if(!adversaire.isattacked(position)){
			//s'il n'est pas attaqué il verifie si cette derniere contient un navire 
			if(adversaire.isship(position)){
				adversaire.addhits(position);
				//change etat de la case du navire de l'adversaire
				for (int i = 0; i < adversaire.getShip().size(); i++) {
					if(adversaire.getShip().get(i).getState().containsKey(position.toString())){
						adversaire.getShip().get(i).setStates(position);
					} 
				}
				//ajout score
				player.getPlayer().setScore(10);
			}
			else{
				//ajout des coups ratés
				adversaire.addMissed(position);
				for (int i = 0; i < adversaire.getShip().size(); i++) {
						for (Entry<String, Boolean> entry : adversaire.getShip().get(i).getState().entrySet()) {
				            if (entry.getValue().equals(true)) {
				            	pos=pos.toPosition(entry.getKey());
				            	if(resultat>distance(pos, position)){
				                resultat=distance(pos, position);
				                }
				            }
						}
				}
	           	System.out.println("Raté mais le radar a detecte un navire qui se trouve dans un rayon de "+resultat+" cases");
			}
			//marque la case comme ataqué
			adversaire.addattacks(position);
		}
		else{
			System.out.println("pas d'attaque");
		}
	}
	
	public int distance(Position pos1,Position pos2){
			int x=Math.abs(pos1.getX()-pos2.getX());
			int y=Math.abs(pos1.getY()-pos2.getY());
		return Math.max(x, y);
		
	}
	
	public ArrayList<Integer> getNumbers(Grid g, int y) {
		for (int i = 0; i < g.getSize(); i++) {
			if(!g.isattacked(new Position(i, y))){
			numbers.add(i);
			}
		}
		return numbers;
	}
}
