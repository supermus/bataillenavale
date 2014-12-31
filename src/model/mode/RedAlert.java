package model.mode;

import java.util.Map.Entry;

import model.Position;
import model.Player.Player;

public class RedAlert extends Battle {
	
	public void attack(Player player, Player adversaire,int y){
		int x;
		Position pos = new Position();
		
		if(!this.getNumbers(adversaire.getGrid(), y).isEmpty()){
		x=this.getresult(this.getNumbers(adversaire.getGrid(), y));
		Position position=new Position(x, y);
			if(adversaire.getGrid().isship(position)){
				for (int i = 0; i < adversaire.getGrid().getShip().size(); i++) {
					if(adversaire.getGrid().getShip().get(i).getState().containsKey(position.toString())){
						adversaire.getGrid().getShip().get(i).setStates(position);
					} 
				}
				player.addScore(10);
				adversaire.getGrid().addhits(position);
			}
			else{
				//ajout des coups ratÃ©s
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

			adversaire.getGrid().addattacks(position);
		
		}
		else{
			System.out.println("pas d'attaque");
		}

	}
}
