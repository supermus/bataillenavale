package model.mode;

import model.ship.AircraftCarrier;
import model.ship.Ironclad;
import model.ship.Submarine;
import model.ship.Zodiac;

public  class Battle {
	
	
	//Methode pour placer les navires	
	public void PlaceShip(Player p, String type, Position position,Orientation orientation){
		switch (type) {
		case "Aircraft":
			p.getShip().add(new AircraftCarrier(position,orientation));
			break;
		case "Ironclad":
			p.getShip().add(new Ironclad(position,orientation));
			break;
		case "Submarine":
			p.getShip().add(new Submarine(position,orientation));
			break;
		case "Zodiac":
			p.getShip().add(new Zodiac(position,orientation));
			break;
		
		default:
			break;
		}
	}

//  Methode pour attaquer
	public void attack(Player player,Player adversaire,Position position){
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
				player.setScore(10);
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
}
