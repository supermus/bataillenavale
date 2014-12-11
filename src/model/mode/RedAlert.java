package model.mode;

import java.util.Map.Entry;

import model.Player;
import model.Position;

public class RedAlert extends Battle {
	
	public void attack(Player player, Player adversaire,int y){
		int x;
		Position pos = new Position();
		
		if(!this.getNumbers(adversaire.getGrid(), y).isEmpty()){
		x=this.getresult(this.getNumbers(adversaire.getGrid(), y));
		Position position=new Position(x, y);
			if(adversaire.getGrid().isship(position)){
				adversaire.getGrid().addhits(position);
				for (int i = 0; i < adversaire.getGrid().getShip().size(); i++) {
					if(adversaire.getGrid().getShip().get(i).getState().containsKey(position.toString())){
						adversaire.getGrid().getShip().get(i).setStates(position);
					} 
				}
				player.addScore(10);
			}
			else{
				//ajout des coups ratés
				int resultat=12;
				adversaire.getGrid().addMissed(position);
				for (int i = 0; i < adversaire.getGrid().getShip().size(); i++) {
						for (Entry<Position, Boolean> entry : adversaire.getGrid().getShip().get(i).getState().entrySet()) {
				            if (entry.getValue().equals(true)) {
				            	pos=(entry.getKey());
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
