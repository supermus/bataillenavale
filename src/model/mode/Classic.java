package model.mode;

import model.Player;
import model.Position;

public class Classic extends Battle {

	
//  Methode pour attaquer
	public void attack(Player player, Player adversaire,Position position){
		//verifie si la case est attaqu� 
		if(!adversaire.getGrid().isattacked(position)){
			//s'il n'est pas attaqu� il verifie si cette derniere contient un navire 
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
				//ajout des coups rat�s
				adversaire.getGrid().addMissed(position);
			}
			//marque la case comme ataqu�
			adversaire.getGrid().addattacks(position);
		}
		else{
			System.out.println("pas d'attaque");
		}
	}
	
}
