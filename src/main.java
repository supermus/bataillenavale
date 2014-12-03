import java.util.ArrayList;

import model.*;
import model.mode.Artillery;
import model.mode.Battle;
import model.mode.Radar;


public class main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1=new Human("Player1");
		Player p2=new Human("Player2");
		Grid g1=new Grid(12, p1);
		Grid g2=new Grid(12, p2);
		Radar radar=new Radar();
		Battle battle=new Battle();
		Artillery art=new Artillery();
		battle.PlaceShip(g2, "Ironclad", new Position(12, 5), Orientation.TOP );
		battle.PlaceShip(g2, "Ironclad", new Position(3, 5), Orientation.TOP );
		battle.PlaceShip(g2, "Ironclad", new Position(1, 5), Orientation.TOP );
		//battle.attack(g1, g2, new Position(12, 6));
		radar.attack(g1, g2, new Position(5, 5));
		art.attack(g1, g2, 4);
//		battle.attack(g1, g2, new Position(3, 5));
//		System.out.println(p1.getScore());
//		System.out.println(battle.getNumbers(g2, 5));
//		System.out.println(g2.getShip().get(0).getState()+""+g1.getSize());
//	
		
		//n.setX(x+1);
		//System.out.println(n.getX());
	}

}