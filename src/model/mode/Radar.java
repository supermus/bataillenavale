package model.mode;

import java.util.Map.Entry;

import model.Position;
import model.Player.Player;

public class Radar extends Battle {

	/**
	 * Attaque la position cibl�e
	 * @param player Joueur � l'origine de l'attaque
	 * @param adversaire Joueur subissant l'attaque
	 * @param position Position cibl�e
	 */
	@Override
	public void attack(Player player, Player adversaire,Position position){
		Position pos=new Position();
		int resultat=12;
		//verifie si la case est attaqu�e
		if(!adversaire.getGrid().isattacked(position)){
			//s'il n'est pas attaqu�e il verifie si cette derniere contient un navire
			if(adversaire.getGrid().isship(position)){
				//change etat de la case du navire de l'adversaire
				for (int i = 0; i < adversaire.getGrid().getShip().size(); i++) {
					if(adversaire.getGrid().getShip().get(i).getState().containsKey(position.toString())){
						adversaire.getGrid().getShip().get(i).setStates(position);
					}
				}
				//ajout score
				player.addScore(10);
				player.addHit();
				adversaire.getGrid().addhits(position);
			}
			else{
				//ajout des coups rat�s
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
				System.out.println("Rat� mais le radar indique qu'un navire se trouve dans un rayon de "+resultat+" cases");
			}
			adversaire.getGrid().addattacks(position);

		}
		else{
			System.out.println("pas d'attaque");
		}
	}



}
