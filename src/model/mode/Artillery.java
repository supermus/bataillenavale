package model.mode;

import java.util.ArrayList;

import model.Grid;
import model.Position;

public class Artillery extends Battle{

	public void attack(Grid player,Grid adversaire,int y){
		int x;
		if(!this.getNumbers(adversaire, y).isEmpty()){
		x=this.getresult(this.getNumbers(adversaire, y));
		Position position=new Position(x, y);
			if(adversaire.isship(position)){
				adversaire.addhits(position);
				for (int i = 0; i < adversaire.getShip().size(); i++) {
					if(adversaire.getShip().get(i).getState().containsKey(position.toString())){
						adversaire.getShip().get(i).setStates(position);
					} 
				}
				player.getPlayer().setScore(10);
			}
			else{
				adversaire.addMissed(position);
			}
			adversaire.addattacks(position);
		
		}
		else{
			System.out.println("pas d'attaque");
		}
	}

	public ArrayList<Integer> getNumbers(Grid g, int y) {
		for (int i = 0; i < g.getSize(); i++) {
			if(!g.isattacked(new Position(i, y))){
			numbers.add(i);
			}
		}
		return numbers;
	}
	
	public int getresult(ArrayList<Integer> numbers){
		
		return numbers.get(2).intValue();	
	}
	
	
}
