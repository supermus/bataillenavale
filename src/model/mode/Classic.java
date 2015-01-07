package model.mode;

import model.Position;
import model.Player.Player;

public class Classic extends Battle {

	/**
	 * Attaque la position cibl�e
	 * @param player Joueur � l'origine de l'attaque
	 * @param adversaire Joueur subissant l'attaque
	 * @param position Position cibl�e
	 */
	@Override
	public void attack(Player player, Player adversaire,Position position){
		//verifie si la case est attaqu�
		if(!adversaire.getGrid().isattacked(position)){
			//s'il n'est pas attaqu� il verifie si cette derniere contient un navire
			if(adversaire.getGrid().isship(position)){
				//change etat de la case du navire de l'adversaire
				for (int i = 0; i < adversaire.getGrid().getShip().size(); i++) {
					if(adversaire.getGrid().getShip().get(i).hasPosition(position)){
						adversaire.getGrid().getShip().get(i).setStates(position);
					}
				}
				//ajout score
				player.addScore(10);
				player.addHit();
				adversaire.getGrid().addhits(position);
			}
			else {

				//ajout des coups rat�s
				adversaire.getGrid().addMissed(position);
				player.addMiss();
			}

			//marque la case comme ataqu�
			adversaire.getGrid().addattacks(position);

		}
		else{

			System.out.println("pas d'attaque");
		}
	}

}
