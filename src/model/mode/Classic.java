package model.mode;

import model.Grid;
import model.Position;

public class Classic extends Battle {

	
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
	
}
