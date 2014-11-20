package model.mode;

import model.*;
import model.ship.*;
import model.Orientation;
import model.Player;
import model.Position;
import model.ship.AircraftCarrier;
import model.ship.Ironclad;
import model.ship.Submarine;
import model.ship.Zodiac;

public  class Battle {
	
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
		//verifie si la case est attaqu� 
		if(!adversaire.isattacked(position)){
			//s'il n'est pas attaqu� il verifie si cette derniere contient un navire 
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
				//ajout des coups rat�s
				adversaire.addMissed(position);
			}
			//marque la case comme ataqu�
			adversaire.addattacks(position);
		}
		else{
			System.out.println("pas d'attaque");
		}
	}
}
