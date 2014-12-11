package model.mode;

import java.util.Map.Entry;

import model.Player;
import model.Position;

public class Radar extends Battle {
	
	
	
//  Methode pour attaquer
	public void attack(Player player, Player adversaire,Position position){
		Position pos=new Position();
		int resultat=12;
		//verifie si la case est attaqué 
		if(!adversaire.getGrid().isattacked(position)){
			//s'il n'est pas attaqué il verifie si cette derniere contient un navire 
			if(adversaire.getGrid().isship(position)){
				adversaire.getGrid().addhits(position);
				//change etat de la case du navire de l'adversaire
				for (int i = 0; i < adversaire.getGrid().getShip().size(); i++) {
					if(adversaire.getGrid().getShip().get(i).getState().containsKey(position.toString())){
						adversaire.getGrid().getShip().get(i).setStates(position);
					} 
				}
				//ajout score
				player.addScore(10);
			}
			else{
				//ajout des coups ratés
				adversaire.getGrid().addMissed(position);
				for (int i = 0; i < adversaire.getGrid().getShip().size(); i++) {
						for (Entry<Position, Boolean> entry : adversaire.getGrid().getShip().get(i).getState().entrySet()) {
				            if (entry.getValue().equals(true)) {
				            	pos = entry.getKey();
				            	if(resultat>distance(pos, position)){
				            		resultat=distance(pos, position);
				                }
				            }
						}
				}
	           	System.out.println("Raté mais le radar indique qu'un navire se trouve dans un rayon de "+resultat+" cases");
			}
			//marque la case comme ataqué
			adversaire.getGrid().addattacks(position);
		}
		else{
			System.out.println("pas d'attaque");
		}
	}
	
	

}
