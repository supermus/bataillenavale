package model.mode;

import model.Player;
import model.Position;

public class Artillery extends Battle{

	public void attack(Player player, Player adversaire,int y){
		int x;
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
				adversaire.getGrid().addMissed(position);
			}
			adversaire.getGrid().addattacks(position);
		
		}
		else{
			System.out.println("pas d'attaque");
		}
	}


	

	
	
}
