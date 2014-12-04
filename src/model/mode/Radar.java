package model.mode;

import java.util.Map.Entry;

import model.GameMode;
import model.Grid;
import model.Position;

public class Radar extends Battle {
	
	
//  Methode pour attaquer
	public void attack(Grid player,Grid adversaire,Position position){
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
	           	System.out.println("Raté mais le radar indique qu'un navire se trouve dans un rayon de "+resultat+" cases");
			}
			//marque la case comme ataqué
			adversaire.addattacks(position);
		}
		else{
			System.out.println("pas d'attaque");
		}
	}
	
	

}
